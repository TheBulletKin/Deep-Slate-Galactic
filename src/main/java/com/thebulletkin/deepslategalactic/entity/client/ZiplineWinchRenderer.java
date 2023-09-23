package com.thebulletkin.deepslategalactic.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thebulletkin.deepslategalactic.DeepSlateGalactic;
import com.thebulletkin.deepslategalactic.entity.layers.DSGModelLayers;
import com.thebulletkin.deepslategalactic.entity.nonliving.ZiplineWinchEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class ZiplineWinchRenderer extends EntityRenderer<ZiplineWinchEntity>{
    private static final ResourceLocation ZIPLINE_WINCH_TEXTURE = new ResourceLocation(DeepSlateGalactic.MODID, "textures/entity/nonliving/zipline_winch.png");
    protected final EntityModel<ZiplineWinchEntity> model;
    public ZiplineWinchRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new ZiplineWinchModel<>(pContext.bakeLayer(DSGModelLayers.ZIPLINE_WINCH_LAYER));
    }


    @Override
    public ResourceLocation getTextureLocation(ZiplineWinchEntity pEntity) {
        return ZIPLINE_WINCH_TEXTURE;
    }

    @Override
    public void render(ZiplineWinchEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.pushPose();
        pPoseStack.scale(-1.0F, -1.0F, 1.0F);
        pPoseStack.translate(0, -1.8,0);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
    }
}
