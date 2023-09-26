package com.thebulletkin.deepslategalactic.block.entity;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DSGBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DeepSlateGalactic.MODID);


    public static final RegistryObject<BlockEntityType<ZiplinePillarBlockEntity>> ZIPLINE_PILLAR_BE =
            BLOCK_ENTITIES.register("zipline_pillar_block_entity", () -> BlockEntityType.Builder.of(ZiplinePillarBlockEntity::new, DSGBlocks.ZIPLINE_PILLAR.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }



}
