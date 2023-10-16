package com.thebulletkin.deepslategalactic;

import com.thebulletkin.deepslategalactic.block.DSGBlocks;
import com.thebulletkin.deepslategalactic.item.DSGItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DSGCreativeModeTab {

        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
                DeepSlateGalactic.MODID);
        public static RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("training_tab",
                () ->  CreativeModeTab.builder().icon(() -> new ItemStack(DSGItems.ZIPLINE_LAUNCHER.get()))
                        .title(Component.translatable("creativemodetab.test_tab"))
                        .displayItems((displayParameters, output) -> {

                            output.accept(DSGItems.ZIPLINE_LAUNCHER.get());
                            output.accept(DSGItems.PLATFORM_GUN.get());

                            output.accept(DSGBlocks.ZIPLINE_PILLAR.get());
                        })
                        .build());

        public static void register(IEventBus eventBus){
            CREATIVE_MODE_TABS.register((eventBus));
        }


}
