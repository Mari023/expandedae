package lu.kolja.expandedae;

import com.mojang.logging.LogUtils;
import lu.kolja.expandedae.definition.*;
import lu.kolja.expandedae.xmod.XMod;
import lu.kolja.expandedae.xmod.ae2wtlib.WTLibIntegration;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(Expandedae.MODID)
public class Expandedae {

    public static final String MODID = "expandedae";
    public static final Logger LOGGER = LogUtils.getLogger();

    //getActionableNode().getGrid().getStorageService().getInventory().insert() TODO IMPLEMENT TO STICKY CARD

    public Expandedae(ModContainer container, IEventBus modEventBus) {
        ExpItems.DR.register(modEventBus);
        ExpBlocks.DR.register(modEventBus);
        ExpBlockEntities.DR.register(modEventBus);
        ExpMenus.DR.register(modEventBus);
        ExpCreativeTab.DR.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        if (ModList.get().isLoaded("ae2wtlib")) {
            modEventBus.addListener(WTLibIntegration::registerMenu);
        }
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