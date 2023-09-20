package com.thebulletkin.deepslategalactic.event;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeepSlateGalactic.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DSGEvents {
    
    public class ModEvents {

        @SubscribeEvent
        public static void livingDamage(LivingDamageEvent event){
            if(event.getEntity() instanceof Sheep){
                if (event.getSource().getDirectEntity() instanceof Player player){
                    if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.STICK) {
                        DeepSlateGalactic.LOGGER.info("You just smacked a sheep");

                    }
                }
            }
        }
    }
}
