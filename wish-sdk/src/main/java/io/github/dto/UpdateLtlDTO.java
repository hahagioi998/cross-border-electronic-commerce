package io.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/21 15:19
 */
@NoArgsConstructor
@Data
public class UpdateLtlDTO {

    @JsonProperty("delivery_receipt_file_url")
    private String deliveryReceiptFileUrl;
    @JsonProperty("delivered_at")
    private String deliveredAt;
    @JsonProperty("tracking_url")
    private String trackingUrl;
}
