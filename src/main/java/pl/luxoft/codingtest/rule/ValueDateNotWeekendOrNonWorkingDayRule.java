package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.IForwardAndSpot;

import java.time.DayOfWeek;

public class ValueDateNotWeekendOrNonWorkingDayRule implements Rule<IForwardAndSpot> {
    @Override
    public boolean isValid(IForwardAndSpot t) {
        if (t.getValueDate() == null)
            return true;
        if (t.getValueDate().getDayOfWeek() == DayOfWeek.SATURDAY)
            return false;
        if (t.getValueDate().getDayOfWeek() == DayOfWeek.SUNDAY)
            return false;
        String leftCurrency = t.getCcyPair().substring(0,3);
        String righnCurrency = t.getCcyPair().substring(3);
        if (isWorkingDay(leftCurrency))
            return true;
        if (isWorkingDay(righnCurrency))
            return true;
        return true;
    }

    @Override
    public String getErrorMessage() {
        return "value date cannot fall on weekend or non-working day for currency";
    }

    private boolean isWorkingDay(String currency) {
        return true;
    }
}
