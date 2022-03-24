package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class Buyer {
    @JsonProperty("id")
    private String id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("login")
    private String login;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("companyName")
    private Object companyName;
    @JsonProperty("guest")
    private Boolean guest;
    @JsonProperty("personalIdentity")
    private String personalIdentity;
    @JsonProperty("phoneNumber")
    private Object phoneNumber;
    @JsonProperty("address")
    private BuyerAddress address;
}
