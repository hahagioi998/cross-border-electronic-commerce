package io.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/16 10:48
 */
@NoArgsConstructor
@Data
public class ShipmentDTO {


    @JsonProperty("carrierId")
    private String carrierId;
    @JsonProperty("waybill")
    private String waybill;
    @JsonProperty("carrierName")
    private String carrierName;
    @JsonProperty("lineItems")
    private List<LineItems> lineItems;

    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    public static class LineItems {
        @JsonProperty("id")
        private String id;
    }
}
