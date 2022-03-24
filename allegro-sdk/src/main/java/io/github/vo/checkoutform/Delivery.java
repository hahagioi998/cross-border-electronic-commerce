package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class Delivery {
    @JsonProperty("address")
    private DeliveryAddress address;
    @JsonProperty("method")
    private Method method;
    @JsonProperty("pickupPoint")
    private PickupPoint pickupPoint;
    @JsonProperty("cost")
    private PaidAmount cost;
    @JsonProperty("time")
    private Time time;
    @JsonProperty("smart")
    private Boolean smart;
    @JsonProperty("calculatedNumberOfPackages")
    private Integer calculatedNumberOfPackages;
}
