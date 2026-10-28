package net.dugged.cleancuteless.xray.mixins;

import net.dugged.cleancuteless.CleanCuteless;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer {
	@Redirect(method = "updateLightmap", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;gammaSetting:F", opcode = Opcodes.GETFIELD))
	private float cleancleancuteless$xray$fullbright(final GameSettings instance) {
		return CleanCuteless.xray.enabled ? 1000F : instance.gammaSetting;
	}
}
