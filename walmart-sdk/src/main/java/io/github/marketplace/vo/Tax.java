package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class Tax {
    @JsonProperty("taxName")
    private String taxName;
    @JsonProperty("taxAmount")
    private TaxAmount taxAmount;
}
