package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class TrackingInformation {
    @JsonProperty("tracking_number")
    private String trackingNumber;
    @JsonProperty("origin_country")
    private String originCountry;
    @JsonProperty("ship_note")
    private String shipNote;
    @JsonProperty("shipping_provider")
    private ProductInformation shippingProvider;
}
