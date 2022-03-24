package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class Order {
    @JsonProperty("purchaseOrderId")
    private String purchaseOrderId;
    @JsonProperty("customerOrderId")
    private String customerOrderId;
    @JsonProperty("customerEmailId")
    private String customerEmailId;
    @JsonProperty("orderType")
    private String orderType;
    @JsonProperty("originalCustomerOrderID")
    private String originalCustomerOrderID;
    @JsonProperty("orderDate")
    private Long orderDate;
    @JsonProperty("shippingInfo")
    private ShippingInfo shippingInfo;
    @JsonProperty("orderLines")
    private OrderLines orderLines;
    @JsonProperty("shipNode")
    private ShipNode shipNode;
}
