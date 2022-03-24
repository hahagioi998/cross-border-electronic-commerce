package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class FbwFees {
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("fee_name")
    private String feeName;
    @JsonProperty("fee_type")
    private String feeType;
}
