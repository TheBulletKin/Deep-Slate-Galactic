package com.thebulletkin.deepslategalactic.entity;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import com.thebulletkin.deepslategalactic.block.entity.ZiplinePillarBlockEntity;
import com.thebulletkin.deepslategalactic.entity.nonliving.ZiplineWinchEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DSGEntities {




    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeepSlateGalactic.MODID);

    public static final RegistryObject<EntityType<ZiplineWinchEntity>> ZIPLINE_WINCH =
            ENTITY_TYPES.register("zipline_winch_entity", () -> EntityType.Builder.<ZiplineWinchEntity>of(ZiplineWinchEntity::new, MobCategory.MISC)
                    .sized(1f, 1f).build("zipline_winch_entity"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
