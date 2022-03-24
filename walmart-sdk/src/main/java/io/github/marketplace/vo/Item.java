package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class Item {
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("sku")
    private String sku;

}
