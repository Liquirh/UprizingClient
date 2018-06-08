package uprizing.setting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public interface Setting {

	String getName();

	String getConfigKeyAndValue();

	String getConfigValue();

	String getConfigKey();

	void parseValue(String configValue);

	boolean getAsBoolean();

	String getAsString();

	boolean isHovered(int mouseX, int mouseY);

	void drawButton(FontRenderer fontRenderer, int mouseX, int mouseY);

	void pressButton(Minecraft minecraft);

	void updateButton(int buttonX, int buttonY, int buttonWidth);

	void resetButton();
}