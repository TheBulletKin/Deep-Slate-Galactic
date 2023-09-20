package com.thebulletkin.deepslategalactic.datagen.loot;

import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class DSGBlockLootTables extends BlockLootSubProvider{

        public DSGBlockLootTables() {

            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            this.dropSelf(DSGBlocks.ZIPLINE_PILLAR.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return DSGBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }

}
