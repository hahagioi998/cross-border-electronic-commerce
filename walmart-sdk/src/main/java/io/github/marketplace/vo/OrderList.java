package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:17
 */
@NoArgsConstructor
@Data
public class OrderList {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("elements")
    private Elements elements;
}
