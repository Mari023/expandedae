package lu.kolja.expandedae.terminal;

import appeng.client.gui.AEBaseScreen;
import appeng.client.gui.style.ScreenStyle;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ExpEncodingTerminalScreen<T extends ExpEncodingTerminalMenu> extends AEBaseScreen<T> {
    public ExpEncodingTerminalScreen(T menu, Inventory playerInventory, Component title, ScreenStyle style) {
        super(menu, playerInventory, title, style);
    }
}
