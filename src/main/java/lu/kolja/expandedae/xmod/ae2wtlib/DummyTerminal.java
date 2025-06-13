package lu.kolja.expandedae.xmod.ae2wtlib;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class DummyTerminal extends Item {

    public DummyTerminal(Properties properties) {
        super(properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        lines.add(Component.literal("AE2WTLIB is not installed!").withStyle(ChatFormatting.GRAY));
    }
}
