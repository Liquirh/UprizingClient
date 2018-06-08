package uprizing.setting;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import uprizing.Merguez;
import uprizing.Stawlker;

@Getter
abstract class AbstractSetting extends Gui implements Setting {

	private final String name, configKey;
	private int buttonX, buttonY, buttonWidth, buttonHeight;
	private static final int DEFAULT_BUTTON_HEIGHT = 10;

	AbstractSetting(final String name) {
		this.name = name;
		this.configKey = Stawlker.configKey(name);
	}

	@Override
	public final String getConfigKeyAndValue() {
		return configKey + ":" + getConfigValue();
	}

	@Override
	public boolean getAsBoolean() {
		return false;
	}

	@Override
	public String getAsString() {
		return null;
	}

	@Override
	public final boolean isHovered(int mouseX, int mouseY) { // TODO: enabled
		return mouseX >= buttonX && mouseY >= buttonY && mouseX < buttonX + buttonWidth && mouseY < buttonY + buttonHeight;
	}

	public void drawButton(FontRenderer fontRenderer, int mouseX, int mouseY) { // TODO: retirer le extends Gui, mettre Drawer ou autre
		if (isHovered(mouseX, mouseY)) {
			test(buttonX, buttonY, buttonWidth, buttonHeight, Merguez.C); // TODO: retirer
		}

		drawString(fontRenderer, name + ": " + getAsString(), buttonX + 1 + 4 + 4, buttonY + 1, Merguez.D);
		//drawCenteredString(minecraft.fontRenderer, setting.getDisplayName(), x + width / 2, y + (height - 8) / 2, 14737632);

		// TODO: slider, etc.. en orange
	}

	@Override
	public void pressButton(Minecraft minecraft) {
		System.out.println("clicked button: " + name);
		//minecraft.getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
	}

	@Override
	public final void updateButton(int buttonX, int buttonY, int buttonWidth) {
		this.buttonX = buttonX;
		this.buttonY = buttonY;
		this.buttonWidth = buttonWidth;
		this.buttonHeight = DEFAULT_BUTTON_HEIGHT;
	}

	@Override
	public final void resetButton() {
		buttonX = buttonY = buttonWidth = buttonHeight = 0;
	}
}