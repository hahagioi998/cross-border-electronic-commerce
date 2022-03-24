package io.github.vo.orderevent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:08
 */
@NoArgsConstructor
@Data
public class LineItems {
    @JsonProperty("id")
    private String id;
    @JsonProperty("offer")
    private Offer offer;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("originalPrice")
    private OriginalPrice originalPrice;
    @JsonProperty("price")
    private OriginalPrice price;
    @JsonProperty("boughtAt")
    private String boughtAt;
}
