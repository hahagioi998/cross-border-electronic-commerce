package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StatusQuantity {
    @JsonProperty("unitOfMeasurement")
    private String unitOfMeasurement;
    @JsonProperty("amount")
    private String amount;
}