package com.thebulletkin.deepslategalactic.event;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.entity.DSGEntities;
import com.thebulletkin.deepslategalactic.entity.client.ZiplineWinchModel;
import com.thebulletkin.deepslategalactic.entity.layers.DSGModelLayers;
import com.thebulletkin.deepslategalactic.entity.nonliving.ZiplineWinchEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeepSlateGalactic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DSGEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(DSGModelLayers.ZIPLINE_WINCH_LAYER, ZiplineWinchModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){

    }
}
