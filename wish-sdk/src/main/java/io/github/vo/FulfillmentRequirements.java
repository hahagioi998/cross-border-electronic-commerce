package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class FulfillmentRequirements {
    @JsonProperty("expected_ship_time")
    private String expectedShipTime;
    @JsonProperty("expected_delivery_time")
    private String expectedDeliveryTime;
}
