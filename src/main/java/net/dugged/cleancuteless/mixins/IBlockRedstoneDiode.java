package net.dugged.cleancuteless.mixins;

import net.minecraft.block.BlockRedstoneDiode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockRedstoneDiode.class)
public interface IBlockRedstoneDiode {
	@Mutable
	@Accessor
	boolean getIsRepeaterPowered();
}
