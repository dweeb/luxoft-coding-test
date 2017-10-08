package pl.luxoft.codingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.luxoft.codingtest.dto.ValidationResult;
import pl.luxoft.codingtest.dto.trade.Record;
import pl.luxoft.codingtest.product.Product;
import pl.luxoft.codingtest.service.ValidateService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ValidateController {

    @Autowired
    private List<Product> products;
    @Autowired
    private ValidateService validateService;
    Map<String, Product> map;

    @PostConstruct
    private void init() {
        map = products.stream().collect(Collectors.toMap(Product::getType, product -> product));
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public List<ValidationResult> validate(@RequestBody final List<Record> trades) {

        List<ValidationResult> results = new ArrayList<>();
        for (Record trade: trades) {
            Product product = map.get(trade.getType());
            results.add(validateService.doValidate(trade, product));
        }

        return results;
    }

}
