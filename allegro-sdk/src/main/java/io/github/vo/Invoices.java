package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/18 15:05
 */
@NoArgsConstructor
@Data
public class Invoices {


    @JsonProperty("invoices")
    private List<InvoicesDTO> invoicesList;

    @NoArgsConstructor
    @Data
    public static class InvoicesDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("invoiceNumber")
        private String invoiceNumber;
        @JsonProperty("createdAt")
        private String createdAt;
        @JsonProperty("file")
        private FileDTO file;
        @JsonProperty("eptVerification")
        private EptVerificationDTO eptVerification;

        @NoArgsConstructor
        @Data
        public static class FileDTO {
            @JsonProperty("name")
            private String name;
            @JsonProperty("uploadedAt")
            private String uploadedAt;
            @JsonProperty("securityVerification")
            private SecurityVerificationDTO securityVerification;

            @NoArgsConstructor
            @Data
            public static class SecurityVerificationDTO {
                @JsonProperty("status")
                private String status;
                @JsonProperty("verifiedAt")
                private String verifiedAt;
            }
        }

        @NoArgsConstructor
        @Data
        public static class EptVerificationDTO {
            @JsonProperty("status")
            private String status;
            @JsonProperty("verifiedAt")
            private String verifiedAt;
            @JsonProperty("reasons")
            private List<ReasonsDTO> reasons;

            @NoArgsConstructor
            @Data
            public static class ReasonsDTO {
                @JsonProperty("id")
                private String id;
                @JsonProperty("message")
                private String message;
            }
        }
    }
}
