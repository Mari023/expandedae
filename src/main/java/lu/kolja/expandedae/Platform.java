package lu.kolja.expandedae;

import appeng.core.AppEng;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Platform {
    Logger log = LoggerFactory.getLogger(Platform.class);
    public static void registerMenuType(String id, MenuType<?> menuType) {
        Registry.register(BuiltInRegistries.MENU, AppEng.makeId(id), menuType);
    }
}
