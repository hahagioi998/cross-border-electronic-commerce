package io.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/21 15:14
 */
@NoArgsConstructor
@Data
public class RefundDTO {

    @JsonProperty("refund_reason_note")
    private String refundReasonNote;
    @JsonProperty("refund_reason")
    private String refundReason;
}
