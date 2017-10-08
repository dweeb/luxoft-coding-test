package pl.luxoft.codingtest.rule;

import pl.luxoft.codingtest.dto.trade.VanillaOptionRecord;

/**
 * Created by iussov on 08.10.2017.
 */
public class ExpiryDateRule implements Rule<VanillaOptionRecord> {
    @Override
    public boolean isValid(VanillaOptionRecord t) {
        if (t.getDeliveryDate() == null || t.getExpiryDate() == null)
            return false;
        if (t.getExpiryDate().isBefore(t.getDeliveryDate()) && t.getDeliveryDate().isBefore(t.getDeliveryDate()))
            return true;
        return false;
    }

    @Override
    public String getErrorMessage() {
        return "expiry date and premium date shall be before delivery date";
    }
}
