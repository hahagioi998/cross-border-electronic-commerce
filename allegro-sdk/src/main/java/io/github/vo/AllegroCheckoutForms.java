package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/21 15:59
 */
@NoArgsConstructor
@Data
public class AllegroCheckoutForms {

    @JsonProperty("checkoutForms")
    private List<AllegroCheckoutForm> checkoutForms;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("totalCount")
    private Integer totalCount;

}
