package com.zook.devtechlib.api.items;

import gregtech.api.gui.ModularUI;
import gregtech.api.items.gui.ItemUIFactory;
import gregtech.api.items.gui.PlayerInventoryHolder;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.items.metaitem.stats.IItemModelIndexProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class ItemProxyUI implements IItemBehaviour, ItemUIFactory, IItemModelIndexProvider {
    private static final ProxyModeSwitchBehavior MODE_SWITCH_BEHAVIOR = new ProxyModeSwitchBehavior();

    public Method test = ObfuscationReflectionHelper.findMethod(MetaTileEntity.class, "createUI", ModularUI.class, EntityPlayer.class);

    @Override
    public ModularUI createUI(PlayerInventoryHolder playerInventoryHolder, EntityPlayer entityPlayer) {
        MetaTileEntity tileEntity = getMetaTileEntity(getWorld(playerInventoryHolder.getCurrentItem()), getBlockPos(playerInventoryHolder.getCurrentItem()));
        if(tileEntity != null) {
            try {
                return (ModularUI) test.invoke(tileEntity, entityPlayer);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static MetaTileEntity getMetaTileEntity(IBlockAccess blockAccess, BlockPos pos) {
        if(pos != null) {
            TileEntity holder = blockAccess.getTileEntity(pos);
            return holder instanceof MetaTileEntityHolder ? ((MetaTileEntityHolder) holder).getMetaTileEntity() : null;
        }
        return null;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        if(!world.isRemote && !Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && !Keyboard.isKeyDown(Keyboard.KEY_RCONTROL)) {
            if(player.isSneaking()) {
                MODE_SWITCH_BEHAVIOR.onItemRightClick(world, player, hand);
            } else {
                MetaTileEntity tileEntity = getMetaTileEntity(getWorld(itemStack), getBlockPos(itemStack));
                if(tileEntity != null) {
                    PlayerInventoryHolder holder = new PlayerInventoryHolder(player, hand);
                    holder.openUI();
                }
            }
        }
        return ActionResult.newResult(EnumActionResult.PASS, itemStack);
    }

    @Override
    public ActionResult<ItemStack> onItemUse(EntityPlayer player, World world, BlockPos blockPos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemStack = player.getHeldItem(hand);
        String mode = MODE_SWITCH_BEHAVIOR.getModeFromItemStack(itemStack).getUnlocalizedName();
        if(!world.isRemote && player.isSneaking() && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL)) {
            NBTTagList nbttaglist = new NBTTagList();
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setInteger("ID", player.dimension);
            nbttagcompound.setInteger("X", blockPos.getX());
            nbttagcompound.setInteger("Y", blockPos.getY());
            nbttagcompound.setInteger("Z", blockPos.getZ());
            nbttaglist.appendTag(nbttagcompound);
            itemStack.setTagInfo(mode, nbttaglist);
        }
        return ActionResult.newResult(EnumActionResult.PASS, itemStack);
    }

    public static BlockPos getBlockPos(ItemStack itemStack) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        String mode = MODE_SWITCH_BEHAVIOR.getModeFromItemStack(itemStack).getUnlocalizedName();
        if(tagCompound != null && tagCompound.hasKey(mode)) {
            NBTTagCompound block = tagCompound.getTagList(mode, 10).getCompoundTagAt(0);
            int x = block.getInteger("X");
            int y = block.getInteger("Y");
            int z = block.getInteger("Z");
            return new BlockPos(x, y, z);
        } else return null;
    }

    @Override
    public int getModelIndex(ItemStack itemStack) {
        String mode = MODE_SWITCH_BEHAVIOR.getModeFromItemStack(itemStack).getUnlocalizedName();
        return Integer.parseInt(mode) - 1;
    }

    @Override
    public void addInformation(ItemStack itemStack, List<String> lines) {
        MODE_SWITCH_BEHAVIOR.addInformation(itemStack, lines);
    }

    public static World getWorld(ItemStack itemStack) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        String mode = MODE_SWITCH_BEHAVIOR.getModeFromItemStack(itemStack).getUnlocalizedName();
        if(tagCompound != null && tagCompound.hasKey(mode)) {
            NBTTagCompound world = tagCompound.getTagList(mode, 10).getCompoundTagAt(0);
            return DimensionManager.getWorld(world.getInteger("ID"));
        }
        return DimensionManager.getWorld(0);
    }
}
