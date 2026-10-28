package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public abstract class MixinWorld {
	@Shadow
	@Final
	public boolean isRemote;
	@Unique
	private final GameSettings cleancleancuteless$settings = Minecraft.getMinecraft().gameSettings;

	@Inject(method = "checkLightFor", at = @At("HEAD"), cancellable = true)
	private void cleancleancuteless$onLight(final CallbackInfoReturnable<Boolean> cir) {
		if (!Configuration.lightUpdates && this.isRemote) {
			cir.setReturnValue(false);
		}
	}

	@Inject(method = "getCombinedLight", at = @At("HEAD"), cancellable = true)
	private void cleancleancuteless$fullbright(final BlockPos pos, final int lightValue, final CallbackInfoReturnable<Integer> cir) {
		if (this.cleancleancuteless$settings.gammaSetting > 1F) {
			cir.setReturnValue(15 << 20 | 15 << 4);
		}
	}
}
