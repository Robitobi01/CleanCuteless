package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.Configuration;
import net.dugged.cleancuteless.MapDisplay;
import net.dugged.cleancuteless.ShulkerBoxDisplay;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {GuiScreen.class, GuiContainerCreative.class})
public abstract class MixinShulkerBoxDisplayRenderer extends Gui {
	@Inject(method = "renderToolTip", at = @At("RETURN"))
	private void postRenderToolTip(final ItemStack stack, final int x, final int y, final CallbackInfo ci) {
		if (Configuration.visuals.showShulkerContents) {
			ShulkerBoxDisplay.handleShulkerBoxDisplayRenderer(stack, x, y, this);
			MapDisplay.handleMapDisplayRenderer(stack, x, y, this);
		}
	}
}