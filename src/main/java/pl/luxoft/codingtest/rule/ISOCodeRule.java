package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.ITrade;

/**
 * Created by iussov on 08.10.2017.
 */
public class ISOCodeRule implements Rule<ITrade> {
    @Override
    public boolean isValid(ITrade t) {
        if (t.getCcyPair() == null || t.getCcyPair().length() != 6)
            return false;
        String leftCurrency = t.getCcyPair().substring(0,3);
        String righnCurrency = t.getCcyPair().substring(3);
        return isISOCode(leftCurrency) && isISOCode(righnCurrency);
    }

    private boolean isISOCode(String currency) {
        if (currency.equals("EUR"))
            return true;
        if (currency.equals("USD"))
            return true;
        return false;
    }

    @Override
    public String getErrorMessage() {
        return "valid ISO codes (ISO 4217)";
    }
}
