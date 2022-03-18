package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/16 10:51
 */
@NoArgsConstructor
@Data
public class Shipment {

    @JsonProperty("id")
    private String id;
    @JsonProperty("waybill")
    private String waybill;
    @JsonProperty("carrierId")
    private String carrierId;
    @JsonProperty("carrierName")
    private String carrierName;
    @JsonProperty("lineItems")
    private List<LineItems> lineItems;
    @JsonProperty("createdAt")
    private String createdAt;

    @NoArgsConstructor
    @Data
    public static class LineItems {
        @JsonProperty("id")
        private String id;
    }
}
