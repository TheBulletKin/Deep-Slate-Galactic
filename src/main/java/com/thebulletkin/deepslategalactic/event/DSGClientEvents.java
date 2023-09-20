package com.thebulletkin.deepslategalactic.event;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DeepSlateGalactic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DSGClientEvents {



        @SubscribeEvent
        public static void doSetup(FMLClientSetupEvent event) {
            //EntityRenderers.register(ModEntities.MAKESHIFT_FLARE.get(), MakeshiftFlareRenderer::new);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event){
            //event.registerSpriteSet(ModParticles.STRANGE_PARTICLES.get(), StrangeParticles.Provider::new);
        }

        @SubscribeEvent
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
           // event.registerBlockEntityRenderer(ModBlockEntities.GEM_EMPOWERING_STATION_BE.get(),
                    //GemEmpoweringBlockEntityRenderer::new);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            //event.enqueueWork(() -> {
                //ModItemProperties.addCustomItemProperties();

                //MenuScreens.register(ModMenuTypes.GEM_EMPOWERING_MENU.get(), GemEmpoweringStationScreen::new);
            //});
        }


}
