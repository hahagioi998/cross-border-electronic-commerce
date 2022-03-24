package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class DeliveryAddress {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("companyName")
    private Object companyName;
    @JsonProperty("phoneNumber")
    private Object phoneNumber;
    @JsonProperty("modifiedAt")
    private Object modifiedAt;
}
