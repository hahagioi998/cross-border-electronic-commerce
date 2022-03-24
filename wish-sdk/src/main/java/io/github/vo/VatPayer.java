package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class VatPayer {
    @JsonProperty("ioss_number")
    private String iossNumber;
    @JsonProperty("tax_number")
    private String taxNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private ShippingDetail address;
}
