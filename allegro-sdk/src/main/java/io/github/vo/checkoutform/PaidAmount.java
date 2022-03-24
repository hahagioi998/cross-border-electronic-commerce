package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class PaidAmount {
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;
}
