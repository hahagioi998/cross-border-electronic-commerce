package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class Product {
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private Weight weight;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("hs_code")
    private String hsCode;
    @JsonProperty("condition")
    private String condition;
    @JsonProperty("quantity")
    private Integer quantity;
}
