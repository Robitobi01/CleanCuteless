package net.dugged.cleancuteless.mixins;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.ServerSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GuiMultiplayer.class)
public interface IGuiMultiplayer {
	@Accessor
	ServerSelectionList getServerListSelector();
}
