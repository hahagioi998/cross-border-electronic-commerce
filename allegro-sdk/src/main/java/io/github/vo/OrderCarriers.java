package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/18 14:43
 */
@NoArgsConstructor
@Data
public class OrderCarriers {


    @JsonProperty("carriers")
    private List<Carriers> carriers;

    @NoArgsConstructor
    @Data
    public static class Carriers {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
    }
}
