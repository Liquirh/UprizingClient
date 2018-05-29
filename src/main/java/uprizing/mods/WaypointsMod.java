package uprizing.mods;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import uprizing.Stawlker;
import uprizing.TickType;
import uprizing.Uprizing;
import uprizing.gui.waypoint.GuiWaypoint;
import uprizing.gui.waypoint.GuiWaypointsMenu;
import uprizing.mod.IMod;
import uprizing.waypoint.MultiplayerWaypoint;
import uprizing.waypoint.SingleplayerWaypoint;
import uprizing.waypoint.Waypoint;
import uprizing.waypoint.WaypointsContainer;

import java.io.File;

@Getter
public class WaypointsMod extends WaypointsContainer implements IMod {

    private final transient Uprizing uprizing;
    private final transient Minecraft minecraft;
    private final String name = "Waypoints";
    public final KeyBinding keyBindAddWaypoint = Stawlker.keyBinding("Add Waypoint", Keyboard.KEY_B, "Uprizing Client"); // 48
    public final KeyBinding keyBindWaypointsMenu = Stawlker.keyBinding("Waypoints Menu", Keyboard.KEY_M, "Uprizing Client"); // 50

    public WaypointsMod(final Uprizing uprizing, final File mainDir) {
        super(mainDir);
        this.uprizing = uprizing;
        this.minecraft = uprizing.getMinecraft();
        this.loadWaypoints();
    }

    @Override
    public void runTick(TickType tickType) {
        if (minecraft.currentScreen == null) {
            if (keyBindAddWaypoint.isPressed()) {
                minecraft.displayGuiScreen(new GuiWaypoint(uprizing));
            } else if (keyBindWaypointsMenu.isPressed()) {
                minecraft.displayGuiScreen(new GuiWaypointsMenu(uprizing));
            }
        }
    }

    public final Waypoint createWaypoint(String name, double x, double y, double z, float red, float blue, float green, boolean enabled) {
        if (minecraft.isIntegratedServerRunning()) {
            return new SingleplayerWaypoint(minecraft.getIntegratedServer().getWorldName(), name, x, y, z, red, blue, green, enabled);
        } else {
            return new MultiplayerWaypoint(minecraft.sexy().getServerHostAddress(), name, x, y, z, red, blue, green, enabled);
        }
    }

    @Override
    public final KeyBinding[] getKeyBindings() {
        return new KeyBinding[] { keyBindAddWaypoint, keyBindWaypointsMenu };
    }

    @Override
    public final int getKeyBindingSize() {
        return 2;
    }

    @Override
    public String toString() {
        return name;
    }
}