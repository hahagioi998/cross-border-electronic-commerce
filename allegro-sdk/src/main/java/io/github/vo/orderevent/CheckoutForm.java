package io.github.vo.orderevent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:08
 */
@NoArgsConstructor
@Data
public class CheckoutForm {
    @JsonProperty("id")
    private String id;
    @JsonProperty("revision")
    private String revision;
}
