package com.thebulletkin.deepslategalactic.item;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DSGItems {
   

        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, DeepSlateGalactic.MODID);

        public static final RegistryObject<Item> JUNK = ITEMS.register("junk",
                () -> new Item(new Item.Properties()));


        public static void register(IEventBus eventbus){
            ITEMS.register(eventbus);
        }

    
}
