package lu.kolja.expandedae.item.part;

import appeng.items.parts.PartItem;
import lu.kolja.expandedae.terminal.ExpEncodingTerminalPart;

public class ExpEncodingTerminalPartItem extends PartItem<ExpEncodingTerminalPart> {
    public ExpEncodingTerminalPartItem(Properties properties) {
        super(properties, ExpEncodingTerminalPart.class, ExpEncodingTerminalPart::new);
    }
}
