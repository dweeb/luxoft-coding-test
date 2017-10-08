package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.ITrade;

/**
 * Created by iussov on 08.10.2017.
 */
public class CounterpartyIsSupportedRule implements Rule<ITrade> {
    @Override
    public boolean isValid(ITrade t) {
        if (!ITrade.counterparty.contains(t.getCustomer()))
            return false;
        return true;
    }

    @Override
    public String getErrorMessage() {
        return "counterparty is one of the supported ones";
    }
}
