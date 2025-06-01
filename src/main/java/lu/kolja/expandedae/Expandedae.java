package lu.kolja.expandedae;

import appeng.api.features.GridLinkables;
import appeng.items.tools.powered.WirelessTerminalItem;
import com.mojang.logging.LogUtils;
import de.mari_023.ae2wtlib.api.gui.Icon;
import de.mari_023.ae2wtlib.api.registration.AddTerminalEvent;
import lu.kolja.expandedae.definition.*;
import lu.kolja.expandedae.terminal.wtlib.ExpWETMenu;
import lu.kolja.expandedae.terminal.wtlib.ExpWETMenuHost;
import lu.kolja.expandedae.xmod.XMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import static lu.kolja.expandedae.client.gui.widgets.ExpIcon.EXP_PATTERN_ENCODING;
import static lu.kolja.expandedae.client.gui.widgets.ExpIcon.TEXTURE;

@Mod(Expandedae.MODID)
public class Expandedae {

    public static final String MODID = "expandedae";
    public static final Logger LOGGER = LogUtils.getLogger();
    private boolean terminalsRegistered = false;

    //getActionableNode().getGrid().getStorageService().getInventory().insert() TODO IMPLEMENT TO STICKY CARD

    public Expandedae(ModContainer container, IEventBus modEventBus) {
        ExpItems.DR.register(modEventBus);
        ExpBlocks.DR.register(modEventBus);
        ExpBlockEntities.DR.register(modEventBus);
        ExpMenus.DR.register(modEventBus);
        ExpCreativeTab.DR.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener((RegisterEvent e) -> {

            if (e.getRegistryKey().equals(Registries.MENU)) {
                Registry.register(BuiltInRegistries.MENU, ExpWETMenu.ID, ExpWETMenu.TYPE);
                return;
            }
            if (!e.getRegistryKey().equals(Registries.ITEM)) return;
            if (terminalsRegistered) return;
            terminalsRegistered = true;
            //ExpItems.orderInit();
            //Registry.register(BuiltInRegistries.ITEM, makeId("exp_wireless_encoding_terminal"), ExpItems.EXP_WIRELESS_ENCODING_TERMINAL.get());
            AddTerminalEvent.register(event -> event.builder(
                    "exp_encoding",
                    ExpWETMenuHost::new,
                    ExpWETMenu.TYPE,
                    ExpItems.EXP_WIRELESS_ENCODING_TERMINAL.get(),
                    new Icon(EXP_PATTERN_ENCODING.x, EXP_PATTERN_ENCODING.y, 16, 16, TEXTURE)
            ).addTerminal());
            GridLinkables.register(ExpItems.EXP_WIRELESS_ENCODING_TERMINAL, WirelessTerminalItem.LINKABLE_HANDLER);
        });
    }

    @Contract("_ -> new")
    public static @NotNull ResourceLocation makeId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        new XMod();
        new ExpUpgrades(event);
    }
}