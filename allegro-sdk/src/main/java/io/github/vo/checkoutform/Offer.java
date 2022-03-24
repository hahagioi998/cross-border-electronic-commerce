package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class Offer {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("external")
    private Buyer external;
}
