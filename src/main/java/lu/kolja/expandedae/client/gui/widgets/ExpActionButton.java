package lu.kolja.expandedae.client.gui.widgets;

import lu.kolja.expandedae.definition.ExpText;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public class ExpActionButton extends ExpIconButton {
    private static final Pattern PATTERN_NEW_LINE = Pattern.compile("\\n", 16);
    private final ExpIcon icon;

    public ExpActionButton(ExpActionItems action, Runnable onPress, int width, int height) {
        this(action, width, height, (Consumer)((a) -> onPress.run()));
    }

    public ExpActionButton(ExpActionItems action, int width, int height,Consumer<ExpActionItems> onPress) {
        super((btn) -> onPress.accept(action), width, height);
        ExpText displayName;
        ExpText displayValue;
        switch (action) {
            case MODIFY_PATTERNS -> {
                this.icon = ExpIcon.MODIFY_PATTERNS;
                displayName = ExpText.modifyPatterns;
                displayValue = ExpText.modifyPatternsHint;
            }
            case ADVANCED_PATTERN_MODE -> {
                this.icon = ExpIcon.DOUBLE_ARROW;
                displayName = ExpText.arrow;
                displayValue = ExpText.arrowHint;
            }
            default ->
                throw new IllegalArgumentException("Unknown ActionItem: " + action);
        }
        this.setMessage(this.buildMessage(displayName, displayValue));
    }

    protected ExpIcon getIcon() {
        return this.icon;
    }

    private Component buildMessage(ExpText displayName, @Nullable ExpText displayValue) {
        String name = displayName.text().getString();
        if (displayValue == null) {
            return Component.literal(name);
        } else {
            String value = displayValue.text().getString();
            value = PATTERN_NEW_LINE.matcher(value).replaceAll("\n");
            StringBuilder sb = new StringBuilder(value);
            int i = sb.lastIndexOf("\n");
            if (i <= 0) {
                i = 0;
            }
            /*
            while(i + 30 < sb.length() && (i = sb.lastIndexOf(" ", i + 30)) != -1) {
                sb.replace(i, i + 1, "");
            }*/

            return Component.literal(name + "\n" + sb);
        }
    }
}
