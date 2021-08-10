package net.mcreator.mydrone.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class DroneentityRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DroneentityEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelDrone(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("my_drone:textures/drone.png");
					}
				};
			});

		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports

	public static class ModelDrone extends EntityModel<Entity> {
		private final ModelRenderer bone;

		public ModelDrone() {
			textureWidth = 16;
			textureHeight = 16;

			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(4, 6).addBox(-9.0F, -30.0F, 5.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(3, 10).addBox(-5.0F, -31.0F, 1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(3, 10).addBox(-13.0F, -31.0F, 9.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(3, 10).addBox(-13.0F, -31.0F, 1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(3, 10).addBox(-5.0F, -31.0F, 9.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
