package io.github.vo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/2/22 16:42
 */
@NoArgsConstructor
@Data
public class AmazonShippingAddress {

    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;
    @JsonProperty("ShippingAddress")
    private ShippingAddress shippingAddress;

    @NoArgsConstructor
    @Data
    public static class ShippingAddress {
        @JsonProperty("Name")
        private String name;
        @JsonProperty("AddressLine1")
        private String addressLine1;
        @JsonProperty("AddressLine2")
        private String addressLine2;
        @JsonProperty("AddressLine3")
        private String addressLine3;
        @JsonProperty("City")
        private String city;
        @JsonProperty("County")
        private String county;
        @JsonProperty("District")
        private String district;
        @JsonProperty("StateOrRegion")
        private String stateOrRegion;
        @JsonProperty("Municipality")
        private String municipality;
        @JsonProperty("PostalCode")
        private String postalCode;
        @JsonProperty("CountryCode")
        private String countryCode;
        @JsonProperty("Phone")
        private String phone;
        @JsonProperty("AddressType")
        private String addressType;
    }
}
