package pl.luxoft.codingtest.dto.trade;

import java.util.Arrays;
import java.util.List;

/**
 * Created by iussov on 08.10.2017.
 */
public interface ITrade {

    List<String> counterparty = Arrays.asList("PLUTO1", "PLUTO2");

    String getCustomer();
    String getCcyPair();
}
