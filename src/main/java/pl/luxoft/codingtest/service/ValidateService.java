package pl.luxoft.codingtest.service;

import org.springframework.stereotype.Service;
import pl.luxoft.codingtest.dto.ValidationResult;
import pl.luxoft.codingtest.dto.trade.Record;
import pl.luxoft.codingtest.product.Product;
import pl.luxoft.codingtest.rule.Rule;

import java.util.List;

/**
 * Created by iussov on 08.10.2017.
 */
@Service
public class ValidateService {

    public ValidationResult doValidate(Record trade, Product product) {
        ValidationResult result = new ValidationResult();
        result.setTcn(trade.getTCN());
        result.setType(trade.getType());
        if (product == null) {
            result.getErrorMessage().add("not known product");
            return result;
        }
        for (Rule rule: product.getRules()) {
            if (!rule.isValid(trade)) {
                result.getErrorMessage().add(rule.getErrorMessage());
            }
        }
        return result;
    }

}
