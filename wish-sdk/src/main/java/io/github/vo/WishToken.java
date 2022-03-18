package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/23 13:33
 */
@NoArgsConstructor
@Data
public class WishToken {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("scopes")
    private List<String> scopes;
    /**
     * 该令牌所链接的商家的ID
     */
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("expiry_time")
    private String expiryTime;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
