package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class TrackingInfo {
    @JsonProperty("shipDateTime")
    private Long shipDateTime;
    @JsonProperty("carrierName")
    private CarrierName carrierName;
    @JsonProperty("methodCode")
    private String methodCode;
    @JsonProperty("trackingNumber")
    private String trackingNumber;
    @JsonProperty("trackingURL")
    private String trackingURL;
}
