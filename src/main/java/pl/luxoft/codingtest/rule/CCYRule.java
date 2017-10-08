package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.RiskRecord;

/**
 * Created by iussov on 08.10.2017.
 */
public class CCYRule implements Rule<RiskRecord> {
    @Override
    public boolean isValid(RiskRecord t) {
        return t.getCCY() != null && t.getCCY().length() > 0;
    }

    @Override
    public String getErrorMessage() {
        return "validate currency (contains in trade ccy pair)";
    }
}
