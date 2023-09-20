package com.thebulletkin.deepslategalactic.datagen;


import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class DSGGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public DSGGlobalLootModifierProvider(PackOutput output) {
        super(output, DeepSlateGalactic.MODID);
    }

    @Override
    protected void start() {
        
    }
}
