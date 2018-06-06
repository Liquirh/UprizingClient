package uprizing.test;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.Color;

public class TestGuiScreen extends GuiScreen {

	/**
	 * TODO:
	 * - guiButton à refaire
	 * 		- slider extends GuiButton
	 * - animation quand on est sur un boutton
	 */

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawGradientRect(0, 0, width, height, -1072689136, -804253680); // drawDefaultBackground()

		final int factor = 4, baissage = 50;

		int bottomBoxEdge = height - height / factor + baissage;
		int rightBoxEdge = width - width / factor - 2;

		// background
		drawRect(width / factor,
				height / factor + baissage,
				rightBoxEdge,
				bottomBoxEdge,
				new Color(150, 143, 145, 255).getRGB());

		// buttons here ou super
	}

	@Override
	protected void keyTyped(char p_73869_1_, int p_73869_2_) {
		super.keyTyped(p_73869_1_, p_73869_2_);
	}

	@Override
	protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
		super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
	}

	@Override
	protected void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
		super.mouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
	}

	@Override
	protected void mouseClickMove(int p_146273_1_, int p_146273_2_, int p_146273_3_, long p_146273_4_) {
		super.mouseClickMove(p_146273_1_, p_146273_2_, p_146273_3_, p_146273_4_);
	}

	@Override
	protected void actionPerformed(GuiButton p_146284_1_) {
		super.actionPerformed(p_146284_1_);
	}
}