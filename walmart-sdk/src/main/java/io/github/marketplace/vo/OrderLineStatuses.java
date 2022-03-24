package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/24 15:12
 */
@NoArgsConstructor
@Data
public class OrderLineStatuses {
    @JsonProperty("orderLineStatus")
    private List<OrderLineStatus> orderLineStatus;
}
