package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class VatAmount {
    @JsonProperty("shipping_level_vat")
    private Amount shippingLevelVat;
    @JsonProperty("final_vat")
    private Amount finalVat;
    @JsonProperty("product_level_vat")
    private Amount productLevelVat;
}
