package io.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/18 14:57
 */
@NoArgsConstructor
@Data
public class FulfillmentDTO {


    @JsonProperty("status")
    private String status;
    @JsonProperty("shipmentSummary")
    private ShipmentSummary shipmentSummary;

    @NoArgsConstructor
    @Data
    public static class ShipmentSummary {
        @JsonProperty("lineItemsSent")
        private String lineItemsSent;
    }
}
