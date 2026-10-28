package net.dugged.cleancuteless.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.BlockStructureVoid;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({BlockBarrier.class, BlockDragonEgg.class, BlockMobSpawner.class, BlockStructure.class, BlockStructureVoid.class})
public abstract class MixinExtraBlocksInCreativeMenu extends Block {
	protected MixinExtraBlocksInCreativeMenu(final Material material) {
		super(material);
	}

	@Inject(method = "<init>()V", at = @At("RETURN"))
	private void onInit(final CallbackInfo ci) {
		this.setCreativeTab(CreativeTabs.REDSTONE);
	}
}
