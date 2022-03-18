package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/18 13:30
 */
@NoArgsConstructor
@Data
public class EventStats {


    @JsonProperty("latestEvent")
    private LatestEvent latestEvent;

    @NoArgsConstructor
    @Data
    public static class LatestEvent {
        @JsonProperty("id")
        private String id;
        @JsonProperty("occurredAt")
        private String occurredAt;
    }
}
