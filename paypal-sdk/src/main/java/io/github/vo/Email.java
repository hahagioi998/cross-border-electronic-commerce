package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EalenXie
 */
@NoArgsConstructor
@Data
public class Email {
    @JsonProperty("value")
    private String value;
    @JsonProperty("primary")
    private Boolean primary;
}
