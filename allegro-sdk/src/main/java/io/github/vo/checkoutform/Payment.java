package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class Payment {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("finishedAt")
    private String finishedAt;
    @JsonProperty("paidAmount")
    private PaidAmount paidAmount;
    @JsonProperty("reconciliation")
    private PaidAmount reconciliation;
}
