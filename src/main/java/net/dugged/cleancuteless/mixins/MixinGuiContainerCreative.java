package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.settings.HotbarSnapshot;
import net.minecraft.init.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiContainerCreative.class)
public abstract class MixinGuiContainerCreative {
	@Redirect(method = "handleHotbarSnapshots", remap = false, at = @At(value = "INVOKE", remap = false, target = "Lnet/minecraft/client/settings/HotbarSnapshot;get(I)Ljava/lang/Object;"))
	private static Object ignoreAirInSnapshot(HotbarSnapshot snapshot, int i) {
		if (Configuration.building.ignoreAirHotbarSnapshots && snapshot.get(i).getItem().equals(Items.AIR)) {
			return Minecraft.getMinecraft().player.inventory.getStackInSlot(i).copy();
		}
		return snapshot.get(i);
	}
}
