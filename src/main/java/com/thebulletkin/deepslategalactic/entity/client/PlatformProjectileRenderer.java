package com.thebulletkin.deepslategalactic.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class PlatformProjectileRenderer extends ThrownItemRenderer {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DeepSlateGalactic.MODID, "textures/entity/projectile/platform_projectile.png");

    public PlatformProjectileRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return TEXTURE;
    }
}
