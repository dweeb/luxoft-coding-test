package pl.luxoft.codingtest.product;

import org.springframework.stereotype.Component;
import pl.luxoft.codingtest.rule.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpotProduct implements Product {
    @Override
    public String getType() {
        return "Spot";
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new ValueDateNotBeforeTradeDateRule());
        rules.add(new ValueDateNotWeekendOrNonWorkingDayRule());
        rules.add(new CounterpartyIsSupportedRule());
        rules.add(new ISOCodeRule());
        return rules;
    }

}
