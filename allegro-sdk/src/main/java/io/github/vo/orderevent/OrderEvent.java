package io.github.vo.orderevent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/24 14:48
 */
@NoArgsConstructor
@Data
public class OrderEvent {

    @JsonProperty("events")
    private List<Events> events;
}
