package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.IForwardAndSpot;

public class ValueDateNotBeforeTradeDateRule implements Rule<IForwardAndSpot> {

    @Override
    public boolean isValid(IForwardAndSpot t) {
        if (t.getValueDate() == null || t.getTradeDate() == null)
            return false;
        return !t.getValueDate().isBefore(t.getTradeDate());
    }

    @Override
    public String getErrorMessage() {
        return "value date cannot be before trade date";
    }
}
