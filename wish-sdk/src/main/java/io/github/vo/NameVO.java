package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/18 16:35
 */
@NoArgsConstructor
@Data
public class NameVO {

    @JsonProperty("name")
    private String name;
}
