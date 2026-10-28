package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.CleanCuteless;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CPacketChatMessage.class)
public abstract class MixinCPacketChatMessage {
	@Inject(method = "<init>(Ljava/lang/String;)V", at = @At("RETURN"))
	private void postChat(final String message, final CallbackInfo ci) {
		if (message.length() > 1 && message.startsWith("/")) {
			CleanCuteless.lastCommand = message;
		}
	}
}
