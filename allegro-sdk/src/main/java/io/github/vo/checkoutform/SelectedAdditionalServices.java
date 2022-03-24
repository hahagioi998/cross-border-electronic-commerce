package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class SelectedAdditionalServices {
    @JsonProperty("definitionId")
    private String definitionId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private PaidAmount price;
    @JsonProperty("quantity")
    private Integer quantity;
}
