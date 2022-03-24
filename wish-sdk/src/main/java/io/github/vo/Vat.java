package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class Vat {
    @JsonProperty("number")
    private String number;
    @JsonProperty("name")
    private String name;
    @JsonProperty("entity")
    private String entity;
}
