package com.thebulletkin.deepslategalactic.item;

import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.item.custom.PlatformGun;
import com.thebulletkin.deepslategalactic.item.custom.ZiplineLauncher;
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


        public static final RegistryObject<Item> ZIPLINE_LAUNCHER = ITEMS.register("zipline_launcher",
            () -> new ZiplineLauncher(new Item.Properties()));
        public static final RegistryObject<Item> PLATFORM_GUN = ITEMS.register("platform_gun",
            () -> new PlatformGun(new Item.Properties()));


        public static void register(IEventBus eventbus){
            ITEMS.register(eventbus);
        }

    
}
