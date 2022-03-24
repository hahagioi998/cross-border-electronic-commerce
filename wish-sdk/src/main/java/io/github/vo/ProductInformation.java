package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class ProductInformation {
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("name")
    private String name;
    @JsonProperty("color")
    private String color;
    @JsonProperty("manufactured_country")
    private String manufacturedCountry;
    @JsonProperty("variation_image_url")
    private String variationImageUrl;
    @JsonProperty("variation_id")
    private String variationId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("size")
    private String size;
}
