package io.github.vo.orderevent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:08
 */
@NoArgsConstructor
@Data
public class Seller {
    @JsonProperty("id")
    private String id;
}
