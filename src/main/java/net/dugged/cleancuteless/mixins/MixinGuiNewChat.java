package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.CompactChat;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiNewChat.class)
public abstract class MixinGuiNewChat {
	@Unique
	private static final CompactChat cleancutelessCompactChat = new CompactChat();

	@Inject(method = "printChatMessage", at = @At("HEAD"), cancellable = true)
	private void onChat(final ITextComponent component, final CallbackInfo ci) {
		if (cleancutelessCompactChat.onChat(component)) {
			ci.cancel();
		}
	}
}
