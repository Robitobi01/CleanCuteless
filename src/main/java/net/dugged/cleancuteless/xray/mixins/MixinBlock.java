package net.dugged.cleancuteless.xray.mixins;

import net.dugged.cleancuteless.CleanCuteless;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class MixinBlock {
	@Redirect(method = "shouldSideBeRendered", at = @At(value = "INVOKE", remap = false, target = "Lnet/minecraft/block/state/IBlockState;doesSideBlockRendering(Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)Z"))
	private boolean cleancleancuteless$xray(final IBlockState instance, final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
		return !CleanCuteless.xray.isHiddenByXray(instance) && instance.doesSideBlockRendering(world, pos, face);
	}

	@Inject(method = "getAmbientOcclusionLightValue", at = @At("HEAD"), cancellable = true)
	private void cleancleancuteless$xray$makeHiddenBlocksBrighter(final IBlockState state, final CallbackInfoReturnable<Float> cir) {
		if (CleanCuteless.xray.enabled) {
			cir.setReturnValue(1F);
		}
	}
}
