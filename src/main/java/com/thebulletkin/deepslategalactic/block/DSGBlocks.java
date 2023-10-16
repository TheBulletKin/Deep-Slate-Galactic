package com.thebulletkin.deepslategalactic.block;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.custom.PlatformBlock;
import com.thebulletkin.deepslategalactic.block.custom.ZiplinePillarBlock;
import com.thebulletkin.deepslategalactic.item.DSGItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DSGBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DeepSlateGalactic.MODID);


    public static final RegistryObject<Block> ZIPLINE_PILLAR = registerBlock("zipline_pillar",
            () -> new ZiplinePillarBlock(BlockBehaviour.Properties.copy(Blocks.LIGHTNING_ROD).noCollission().noOcclusion()));

    public static final RegistryObject<Block> PLATFORM_BLOCK = registerBlock("platform_block",
            () -> new PlatformBlock(BlockBehaviour.Properties.copy(Blocks.SPONGE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return DSGItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
