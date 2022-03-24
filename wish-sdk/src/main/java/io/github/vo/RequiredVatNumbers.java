package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class RequiredVatNumbers {
    @JsonProperty("voec")
    private Voec voec;
    @JsonProperty("eori")
    private Voec eori;
    @JsonProperty("vat")
    private Vat vat;
}
