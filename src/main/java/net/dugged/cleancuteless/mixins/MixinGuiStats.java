package net.dugged.cleancuteless.mixins;

import net.dugged.cleancuteless.CleanCuteless;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GuiStats.class)
public abstract class MixinGuiStats extends GuiScreen {
	private GuiTextField textField;
	private long lastTick = 0;
	private int cooldown = 0;

	@Inject(method = "initGui", at = @At("HEAD"))
	public void initGui(CallbackInfo ci) {
		textField = new GuiTextField(0, this.fontRenderer, this.width / 2 - 4 - 150, this.height - 28, 150, 20);
		textField.setText(CleanCuteless.statPluginFilter);
		textField.setMaxStringLength(32500);
		textField.setFocused(true);
	}

	@Inject(method = "initButtons", at = @At("HEAD"))
	private void addButons(final CallbackInfo ci) {
		if (CleanCuteless.statPlugin.isConnected()) {
			this.buttonList.add(new GuiButton(5, this.width / 2 - 154 - 86, this.height - 28, 80, 20, I18n.format("text.cutelessmod.disconnect")));
		} else {
			this.buttonList.add(new GuiButton(5, this.width / 2 - 154 - 86, this.height - 28, 80, 20, I18n.format("text.cutelessmod.connect")));
		}
	}

	@Inject(method = "actionPerformed", at = @At("HEAD"), cancellable = true)
	private void handleButtons(GuiButton button, final CallbackInfo ci) {
		if (button.id == 5 && cooldown <= 0) {
			try {
				if (CleanCuteless.statPlugin.isConnected()) {
					CleanCuteless.statPlugin.disconnect();
					button.displayString = I18n.format("text.cutelessmod.connect");
				} else {
					CleanCuteless.statPlugin.connect();
					button.displayString = I18n.format("text.cutelessmod.disconnect");
				}
			} catch (Exception exception) {
				CleanCuteless.LOGGER.warn("Unable to execute StatPlugin: {}", exception.getMessage());
			}
			cooldown = 10;
			ci.cancel();
		}
		if (button.id == 0) {
			CleanCuteless.statPluginFilter = textField.getText();
		}
	}

	@Inject(method = "drawScreen", at = @At("RETURN"))
	private void drawScreen(int mouseX, int mouseY, float partialTicks, final CallbackInfo ci) {
		textField.drawTextBox();
		if (cooldown > 0 && CleanCuteless.tickCounter > lastTick) {
			lastTick = CleanCuteless.tickCounter;
			cooldown--;
		}
		for (GuiButton button : buttonList) {
			if (button.id == 5) {
				button.enabled = cooldown <= 0;
			}
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		textField.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		textField.textboxKeyTyped(typedChar, keyCode);
	}
}
