package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class Refunds {
    @JsonProperty("refund_reason_note")
    private String refundReasonNote;
    @JsonProperty("refund_source")
    private String refundSource;
    @JsonProperty("refund_amount")
    private RefundAmount refundAmount;
    @JsonProperty("merchant_responsible_amount")
    private MerchantResponsibleAmount merchantResponsibleAmount;
    @JsonProperty("refund_time")
    private String refundTime;
    @JsonProperty("refund_reason")
    private String refundReason;
}
