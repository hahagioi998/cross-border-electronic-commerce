package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class ShippingInfo {
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("estimatedDeliveryDate")
    private Long estimatedDeliveryDate;
    @JsonProperty("estimatedShipDate")
    private Long estimatedShipDate;
    @JsonProperty("methodCode")
    private String methodCode;
    @JsonProperty("postalAddress")
    private PostalAddress postalAddress;
}
