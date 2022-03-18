package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/18 15:20
 */
@NoArgsConstructor
@Data
public class IdVO {

    @JsonProperty("id")
    private String id;
}
