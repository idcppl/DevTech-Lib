package com.zook.devtechlib.api.test;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ItemLayerModel;

import java.io.FileNotFoundException;

public class TestModel implements ICustomModelLoader {

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        return false;
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception {
        String path = modelLocation.getResourcePath();

        if ("item/generated".equals(path)) {
            return ItemLayerModel.INSTANCE;
        }

        throw new FileNotFoundException(modelLocation.toString());
    }
}
