package lu.kolja.expandedae.xmod.ae2wtlib;

import appeng.api.config.Actionable;
import appeng.api.features.GridLinkables;
import appeng.items.tools.powered.WirelessTerminalItem;
import de.mari_023.ae2wtlib.api.gui.Icon;
import de.mari_023.ae2wtlib.api.registration.AddTerminalEvent;
import lu.kolja.expandedae.terminal.wtlib.ExpItemWET;
import lu.kolja.expandedae.terminal.wtlib.ExpWETMenu;
import lu.kolja.expandedae.terminal.wtlib.ExpWETMenuHost;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.RegisterEvent;

import static lu.kolja.expandedae.client.gui.widgets.ExpIcon.EXP_PATTERN_ENCODING;
import static lu.kolja.expandedae.client.gui.widgets.ExpIcon.TEXTURE;

public class WTLibIntegration {
    public static final Item TERMINAL = new ExpItemWET();

    static {
        var icon = new Icon(EXP_PATTERN_ENCODING.x, EXP_PATTERN_ENCODING.y, 16, 16, TEXTURE);
        AddTerminalEvent.register(
                event -> event.builder(
                        "exp_encoding",
                        ExpWETMenuHost::new,
                        ExpWETMenu.TYPE,
                        (ExpItemWET) TERMINAL,
                        icon
                ).addTerminal()
        );
        GridLinkables.register(TERMINAL, WirelessTerminalItem.LINKABLE_HANDLER);
    }

    public static ItemStack getChargedTerminal() {
        var stack = new ItemStack(TERMINAL);
        var terminal = (ExpItemWET) TERMINAL;
        terminal.injectAEPower(stack, terminal.getAEMaxPower(stack), Actionable.MODULATE);
        return stack;
    }

    public static void registerMenu(RegisterEvent e) {
        if (e.getRegistryKey().equals(Registries.MENU)) {
            e.register(Registries.MENU, ExpWETMenu.ID, () -> ExpWETMenu.TYPE);
        }
    }
}
