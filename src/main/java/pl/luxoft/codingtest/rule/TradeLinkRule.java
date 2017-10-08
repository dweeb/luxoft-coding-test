package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.RiskRecord;

/**
 * Created by iussov on 08.10.2017.
 */
public class TradeLinkRule implements Rule<RiskRecord> {
    @Override
    public boolean isValid(RiskRecord t) {
        return t.getTCN() != null && t.getTCN().length() > 0;
    }

    @Override
    public String getErrorMessage() {
        return "contains trade link";
    }
}
