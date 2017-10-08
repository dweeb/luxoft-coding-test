package pl.luxoft.codingtest.dto.trade;

import java.time.LocalDate;

/**
 * Created by iussov on 08.10.2017.
 */
public interface IForwardAndSpot {

    LocalDate getValueDate();
    LocalDate getTradeDate();
    String getCcyPair();
}
