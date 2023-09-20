package com.thebulletkin.deepslategalactic.datagen;


import com.thebulletkin.deepslategalactic.datagen.loot.DSGBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class DSGLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(DSGBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
