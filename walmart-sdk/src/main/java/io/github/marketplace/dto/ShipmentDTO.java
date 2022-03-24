package io.github.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.marketplace.vo.OrderShipment;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by EalenXie on 2022/3/21 14:01
 */
@NoArgsConstructor
@Data
public class ShipmentDTO {
    @JsonProperty("orderShipment")
    private OrderShipment orderShipment;
}
