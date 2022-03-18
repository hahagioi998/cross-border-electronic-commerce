package io.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/22 17:49
 */
@NoArgsConstructor
@Data
public class ShipmentDTO {


    @JsonProperty("marketplaceId")
    private String marketplaceId;
    @JsonProperty("shipmentStatus")
    private String shipmentStatus;
    @JsonProperty("orderItems")
    private List<OrderItem> orderItems;

    @NoArgsConstructor
    @Data
    public static class OrderItem {
        @JsonProperty("orderItemId")
        private String orderItemId;
        @JsonProperty("quantity")
        private Integer quantity;
    }
}
