package pl.luxoft.codingtest.product;

import pl.luxoft.codingtest.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public interface Product {

    String getType();
    default List<Rule> getRules() {
        return new ArrayList<>();
    }

}
