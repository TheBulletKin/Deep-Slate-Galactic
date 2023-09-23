package com.thebulletkin.deepslategalactic.entity.client;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ZiplineWinchModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart root;

	public ZiplineWinchModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(16, 11).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -3.0F, -2.0F, 16.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rightSlope_r1 = root.addOrReplaceChild("rightSlope_r1", CubeListBuilder.create().texOffs(1, 7).addBox(-2.75F, -2.0F, -1.75F, 5.5F, 4.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4017F, -3.409F, 0.0F, -3.1416F, 0.0F, 2.3562F));

		PartDefinition leftSlope_r1 = root.addOrReplaceChild("leftSlope_r1", CubeListBuilder.create().texOffs(1, 15).addBox(-3.5F, 1.0F, -1.75F, 5.5F, 4.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}