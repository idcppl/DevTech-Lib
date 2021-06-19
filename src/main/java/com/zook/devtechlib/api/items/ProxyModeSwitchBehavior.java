package com.zook.devtechlib.api.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.common.items.behaviors.ModeSwitchBehavior;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

public class ProxyModeSwitchBehavior extends ModeSwitchBehavior<ProxyModeSwitchBehavior.ProxyMode> {
    public ProxyModeSwitchBehavior() {
        super(ProxyMode.class);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        if (!world.isRemote && player.isSneaking()) {
            ProxyMode currentMode = this.getModeFromItemStack(itemStack);
            int currentModeIndex = ArrayUtils.indexOf(ProxyMode.values(), currentMode);
            ProxyMode nextMode = ProxyMode.values()[(currentModeIndex + 1) % ProxyMode.values().length];
            this.setModeForItemStack(itemStack, nextMode);
            MetaTileEntity tileEntity = ItemProxyUI.getMetaTileEntity(world, ItemProxyUI.getBlockPos(itemStack));
            String tileEntityName = "Empty";
            if(tileEntity != null) {
                tileEntityName = I18n.format(tileEntity.getMetaFullName());
            }
            ITextComponent textComponent = new TextComponentTranslation("metaitem.behavior.proxy_mode_switch.mode_switched", tileEntityName);
            player.sendStatusMessage(textComponent, true);
            return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
        }
        return ActionResult.newResult(EnumActionResult.PASS, itemStack);
    }

    @Override
    public void addInformation(ItemStack itemStack, List<String> lines) {
        if(itemStack != null) {
            MetaTileEntity tileEntity = ItemProxyUI.getMetaTileEntity(ItemProxyUI.getWorld(itemStack), ItemProxyUI.getBlockPos(itemStack));
            String tileEntityName = "Empty";
            if (tileEntity != null) {
                tileEntityName = I18n.format(tileEntity.getMetaFullName());
            }
            lines.add(ChatFormatting.YELLOW + "Set to: " + ChatFormatting.WHITE + tileEntityName);
        }
        lines.add(ChatFormatting.GRAY + "Sneak to switch modes");
        lines.add(ChatFormatting.GRAY + "Hold CTRL + sneak to set to block");
    }

    public enum ProxyMode implements ModeSwitchBehavior.ILocalizationKey {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6");

        private final String localizationKey;


        ProxyMode(String localizationKey) {
            this.localizationKey = localizationKey;
        }

        @Override
        public String getUnlocalizedName() {
            return localizationKey;
        }
    }
}

