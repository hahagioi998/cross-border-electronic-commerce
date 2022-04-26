package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author EalenXie
 */
@NoArgsConstructor
@Data
public class UserInfo {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("payer_id")
    private String payerId;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("verified_account")
    private String verifiedAccount;
    @JsonProperty("emails")
    private List<Email> emails;
}
