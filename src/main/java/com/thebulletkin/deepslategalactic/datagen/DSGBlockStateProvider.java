package com.thebulletkin.deepslategalactic.datagen;


import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DSGBlockStateProvider extends BlockStateProvider {
    public DSGBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeepSlateGalactic.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
