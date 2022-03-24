package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class LotInformation {
    @JsonProperty("lot_id")
    private String lotId;
    @JsonProperty("quantity")
    private Integer quantity;
}
