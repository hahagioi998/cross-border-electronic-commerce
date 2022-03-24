package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:39
 */
@NoArgsConstructor
@Data
public class OrderShipment {
    @JsonProperty("orderLines")
    private OrderLines orderLines;
}
