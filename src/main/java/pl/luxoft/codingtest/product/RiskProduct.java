package pl.luxoft.codingtest.product;

import org.springframework.stereotype.Component;
import pl.luxoft.codingtest.rule.CCYRule;
import pl.luxoft.codingtest.rule.Rule;
import pl.luxoft.codingtest.rule.TradeLinkRule;

import java.util.ArrayList;
import java.util.List;

@Component
public class RiskProduct implements Product {
    @Override
    public String getType() {
        return "Risk";
    }

    public List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new TradeLinkRule());
        rules.add(new CCYRule());
        return rules;
    }

}
