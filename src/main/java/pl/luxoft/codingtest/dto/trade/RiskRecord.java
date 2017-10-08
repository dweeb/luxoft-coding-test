package pl.luxoft.codingtest.dto.trade;

import java.math.BigDecimal;

/**
 * Created by iussov on 08.10.2017.
 */
public class RiskRecord extends Record {

    private String CCY;
    private BigDecimal PV;

    public String getCCY() {
        return CCY;
    }

    public void setCCY(String CCY) {
        this.CCY = CCY;
    }

    public BigDecimal getPV() {
        return PV;
    }

    public void setPV(BigDecimal PV) {
        this.PV = PV;
    }
}
