package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.VanillaOptionRecord;

/**
 * Created by iussov on 08.10.2017.
 */
public class StyleRule implements Rule<VanillaOptionRecord> {
    @Override
    public boolean isValid(VanillaOptionRecord t) {
        return t.getStyle().equals("EUROPEAN") || t.getStyle().equals("AMERICAN");
    }

    @Override
    public String getErrorMessage() {
        return "style can be either American or European";
    }
}
