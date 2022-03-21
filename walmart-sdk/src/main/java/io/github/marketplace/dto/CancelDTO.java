package io.github.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/21 14:11
 */
@NoArgsConstructor
@Data
public class CancelDTO {

    @JsonProperty("orderCancellation")
    private OrderCancellation orderCancellation;

    @NoArgsConstructor
    @Data
    public static class OrderCancellation {
        @JsonProperty("orderLines")
        private OrderLines orderLines;

        @NoArgsConstructor
        @Data
        public static class OrderLines {
            @JsonProperty("orderLine")
            private List<OrderLine> orderLine;

            @NoArgsConstructor
            @Data
            public static class OrderLine {
                @JsonProperty("lineNumber")
                private String lineNumber;
                @JsonProperty("orderLineStatuses")
                private OrderLineStatuses orderLineStatuses;

                @NoArgsConstructor
                @Data
                public static class OrderLineStatuses {
                    @JsonProperty("orderLineStatus")
                    private List<OrderLineStatus> orderLineStatus;

                    @NoArgsConstructor
                    @Data
                    public static class OrderLineStatus {
                        @JsonProperty("status")
                        private String status;
                        @JsonProperty("cancellationReason")
                        private String cancellationReason;
                        @JsonProperty("statusQuantity")
                        private StatusQuantity statusQuantity;

                        @NoArgsConstructor
                        @Data
                        public static class StatusQuantity {
                            @JsonProperty("unitOfMeasurement")
                            private String unitOfMeasurement;
                            @JsonProperty("amount")
                            private String amount;
                        }
                    }
                }
            }
        }
    }
}
