package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.Configuration;
import net.minecraft.client.renderer.block.model.WeightedBakedModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

public abstract class CMixinNoRandomTextures {
	@Mixin(WeightedBakedModel.class)
	public abstract static class MixinWeightedBakedModel {
		@ModifyVariable(method = "getQuads", at = @At("HEAD"), argsOnly = true)
		private long cleancleancuteless$noRandomTextures(final long value) {
			return Configuration.showRandomTextures ? value : 0L;
		}
	}
}
