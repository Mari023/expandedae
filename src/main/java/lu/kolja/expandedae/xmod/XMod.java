package lu.kolja.expandedae.xmod;

import lu.kolja.expandedae.xmod.extendedae.ExtendedAE;
import lu.kolja.expandedae.xmod.megacells.MegaCells;
import net.neoforged.fml.ModList;

public class XMod {
    private final String[] mods = {"extendedae", "megacells"};

    public XMod() {
        for (var mod : mods) {
            if (!ModList.get().isLoaded(mod)) continue;
            switch (mod) {
                case "extendedae" -> new ExtendedAE();
                case "megacells" -> new MegaCells();
            }
        }
    }
}
