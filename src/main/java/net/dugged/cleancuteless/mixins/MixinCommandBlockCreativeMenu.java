package net.dugged.cleancuteless.mixins;

import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockCommandBlock.class)
public abstract class MixinCommandBlockCreativeMenu {
	@Inject(method = "<init>(Lnet/minecraft/block/material/MapColor;)V", at = @At("RETURN"))
	private void onInit(final MapColor color, final CallbackInfo ci) {
		((BlockCommandBlock) (Object) this).setCreativeTab(CreativeTabs.REDSTONE);
	}
}
