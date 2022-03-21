package io.github.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/21 14:01
 */
@NoArgsConstructor
@Data
public class ShipmentDTO {

    @JsonProperty("orderShipment")
    private OrderShipment orderShipment;

    @NoArgsConstructor
    @Data
    public static class OrderShipment {
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
                @JsonProperty("sellerOrderId")
                private String sellerOrderId;
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
                        @JsonProperty("statusQuantity")
                        private StatusQuantity statusQuantity;
                        @JsonProperty("trackingInfo")
                        private TrackingInfo trackingInfo;
                        @JsonProperty("returnCenterAddress")
                        private ReturnCenterAddress returnCenterAddress;

                        @NoArgsConstructor
                        @Data
                        public static class StatusQuantity {
                            @JsonProperty("unitOfMeasurement")
                            private String unitOfMeasurement;
                            @JsonProperty("amount")
                            private String amount;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class TrackingInfo {
                            @JsonProperty("shipDateTime")
                            private Long shipDateTime;
                            @JsonProperty("carrierName")
                            private CarrierName carrierName;
                            @JsonProperty("methodCode")
                            private String methodCode;
                            @JsonProperty("trackingNumber")
                            private String trackingNumber;
                            @JsonProperty("trackingURL")
                            private String trackingURL;

                            @NoArgsConstructor
                            @Data
                            public static class CarrierName {
                                @JsonProperty("carrier")
                                private String carrier;
                            }
                        }

                        @NoArgsConstructor
                        @Data
                        public static class ReturnCenterAddress {
                            @JsonProperty("name")
                            private String name;
                            @JsonProperty("address1")
                            private String address1;
                            @JsonProperty("city")
                            private String city;
                            @JsonProperty("state")
                            private String state;
                            @JsonProperty("postalCode")
                            private String postalCode;
                            @JsonProperty("country")
                            private String country;
                            @JsonProperty("dayPhone")
                            private String dayPhone;
                            @JsonProperty("emailId")
                            private String emailId;
                        }
                    }
                }
            }
        }
    }
}
