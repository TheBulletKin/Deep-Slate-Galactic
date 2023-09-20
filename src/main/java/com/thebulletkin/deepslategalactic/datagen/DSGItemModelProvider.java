package com.thebulletkin.deepslategalactic.datagen;


import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DSGItemModelProvider extends ItemModelProvider {
    public DSGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeepSlateGalactic.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


    }


    private ItemModelBuilder complexBlock(Block block){
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(DeepSlateGalactic.MODID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeepSlateGalactic.MODID, "item/" + item.getId().getPath()));


    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DeepSlateGalactic.MODID, "item/" + item.getId().getPath()));
    }
}
