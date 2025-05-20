package lu.kolja.expandedae.terminal;

import appeng.helpers.IPatternTerminalMenuHost;
import appeng.menu.me.items.PatternEncodingTermMenu;
import lu.kolja.expandedae.definition.ExpMenus;
import net.minecraft.world.entity.player.Inventory;

public class ExpEncodingTerminalMenu extends PatternEncodingTermMenu {
    public ExpEncodingTerminalMenu(int id, Inventory ip, IPatternTerminalMenuHost host) {
        super(ExpMenus.EXP_ENCODING_TERMINAL.get(), id, ip, host, true);
    }
}
