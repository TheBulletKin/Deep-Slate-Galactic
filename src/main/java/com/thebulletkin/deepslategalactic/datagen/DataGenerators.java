package com.thebulletkin.deepslategalactic.datagen;


import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DeepSlateGalactic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new DSGBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new DSGItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), DSGLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new DSGGlobalLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), new DSGRecipeProvider(packOutput));

        BlockTagsProvider blockTagsProvider = new DSGBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new DSGItemTagGenerator(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        //generator.addProvider(event.includeServer(), new DSGWorldGenProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, lookupProvider, existingFileHelper, List.of(new DSGAdvancementProvider())));

    }
}
