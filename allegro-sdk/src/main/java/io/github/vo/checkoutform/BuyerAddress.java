package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class BuyerAddress {
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("countryCode")
    private String countryCode;
}
