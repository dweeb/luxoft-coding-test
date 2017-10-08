package pl.luxoft.codingtest.dto.trade;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by iussov on 08.10.2017.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SpotRecord.class, name = "Spot"),
        @JsonSubTypes.Type(value = ForwardRecord.class, name = "Forward"),
        @JsonSubTypes.Type(value = VanillaOptionRecord.class, name = "VanillaOption"),
        @JsonSubTypes.Type(value = RiskRecord.class, name = "Risk")
})
public abstract class Record {

    private String TCN;
    private String type;

    public String getTCN() {
        return TCN;
    }

    public void setTCN(String TCN) {
        this.TCN = TCN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
