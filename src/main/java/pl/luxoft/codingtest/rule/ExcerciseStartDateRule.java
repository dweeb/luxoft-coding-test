package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.VanillaOptionRecord;

/**
 * Created by iussov on 08.10.2017.
 */
public class ExcerciseStartDateRule implements Rule<VanillaOptionRecord> {
    @Override
    public boolean isValid(VanillaOptionRecord t) {
        if (t.getStyle().equals("EUROPEAN") && t.getExcerciseStartDate() == null)
            return true;
        if (t.getStyle().equals("AMERICAN") && t.getExcerciseStartDate().isAfter(t.getTradeDate())
                && t.getExcerciseStartDate().isBefore(t.getExpiryDate()))
            return true;
        return false;
    }

    @Override
    public String getErrorMessage() {
        return "American option style will have in addition the excerciseStartDate," +
                " which has to be after the trade date but before the expiry date";
    }
}
