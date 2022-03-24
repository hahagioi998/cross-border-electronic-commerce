package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class InvoiceAddress {
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("naturalPerson")
    private Buyer naturalPerson;
}
