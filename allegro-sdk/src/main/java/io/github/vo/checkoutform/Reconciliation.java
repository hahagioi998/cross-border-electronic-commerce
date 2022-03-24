package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class Reconciliation {
    @JsonProperty("value")
    private PaidAmount value;
    @JsonProperty("type")
    private String type;
    @JsonProperty("quantity")
    private Integer quantity;
}
