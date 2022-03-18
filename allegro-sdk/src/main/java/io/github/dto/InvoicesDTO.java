package io.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/18 15:17
 */
@NoArgsConstructor
@Data
public class InvoicesDTO {


    @JsonProperty("file")
    private File file;
    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    @NoArgsConstructor
    @Data
    public static class File {
        @JsonProperty("name")
        private String name;
    }
}
