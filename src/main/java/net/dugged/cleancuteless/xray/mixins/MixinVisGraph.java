package net.dugged.cleancuteless.xray.mixins;

import net.dugged.cleancuteless.CleanCuteless;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VisGraph.class)
public abstract class MixinVisGraph {
	@Inject(method = "setOpaqueCube", at = @At("HEAD"), cancellable = true)
	private void cleancleancuteless$xray$fixWeirdHoles(final BlockPos pos, final CallbackInfo ci) {
		if (CleanCuteless.xray.enabled) {
			ci.cancel();
		}
	}
}
