package lu.kolja.expandedae.terminal.wtlib;

import appeng.menu.locator.ItemMenuHostLocator;
import de.mari_023.ae2wtlib.api.terminal.ItemWT;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;

public class ExpItemWET extends ItemWT {
    public ExpItemWET(Properties properties) {}

    @Override
    public MenuType<?> getMenuType(ItemMenuHostLocator locator, Player player) {
        return ExpWETMenu.TYPE;
    }
}