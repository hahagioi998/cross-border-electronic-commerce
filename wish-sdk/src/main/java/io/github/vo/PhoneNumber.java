package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class PhoneNumber {
    @JsonProperty("number")
    private String number;
    @JsonProperty("country_code")
    private String countryCode;
}
