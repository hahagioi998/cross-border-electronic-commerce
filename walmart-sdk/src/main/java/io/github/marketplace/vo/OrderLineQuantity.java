package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class OrderLineQuantity {
    @JsonProperty("unitOfMeasurement")
    private String unitOfMeasurement;
    @JsonProperty("amount")
    private String amount;
}
