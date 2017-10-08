package pl.luxoft.codingtest.product;

import org.springframework.stereotype.Component;
import pl.luxoft.codingtest.rule.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class VanillaOptionProduct implements Product {
    @Override
    public String getType() {
        return "VanillaOption";
    }

    public List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new CounterpartyIsSupportedRule());
        rules.add(new ISOCodeRule());
        rules.add(new StyleRule());
        rules.add(new ExcerciseStartDateRule());
        rules.add(new ExpiryDateRule());
        return rules;
    }

}
