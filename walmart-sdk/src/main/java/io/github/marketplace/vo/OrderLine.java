package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class OrderLine {
    @JsonProperty("lineNumber")
    private String lineNumber;
    @JsonProperty("item")
    private Item item;
    @JsonProperty("charges")
    private Charges charges;
    @JsonProperty("orderLineQuantity")
    private OrderLineQuantity orderLineQuantity;
    @JsonProperty("statusDate")
    private Long statusDate;
    @JsonProperty("orderLineStatuses")
    private OrderLineStatuses orderLineStatuses;
    @JsonProperty("fulfillment")
    private Fulfillment fulfillment;
}
