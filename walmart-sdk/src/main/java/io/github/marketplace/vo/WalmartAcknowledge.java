package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/21 14:05
 */
@NoArgsConstructor
@Data
public class WalmartAcknowledge {

    @JsonProperty("order")
    private OrderDTO order;

    @NoArgsConstructor
    @Data
    public static class OrderDTO {
        @JsonProperty("purchaseOrderId")
        private String purchaseOrderId;
        @JsonProperty("customerOrderId")
        private String customerOrderId;
        @JsonProperty("customerEmailId")
        private String customerEmailId;
        @JsonProperty("orderDate")
        private Long orderDate;
        @JsonProperty("shippingInfo")
        private ShippingInfoDTO shippingInfo;
        @JsonProperty("orderLines")
        private OrderLinesDTO orderLines;

        @NoArgsConstructor
        @Data
        public static class ShippingInfoDTO {
            @JsonProperty("phone")
            private String phone;
            @JsonProperty("estimatedDeliveryDate")
            private Long estimatedDeliveryDate;
            @JsonProperty("estimatedShipDate")
            private Long estimatedShipDate;
            @JsonProperty("methodCode")
            private String methodCode;
            @JsonProperty("postalAddress")
            private PostalAddressDTO postalAddress;

            @NoArgsConstructor
            @Data
            public static class PostalAddressDTO {
                @JsonProperty("name")
                private String name;
                @JsonProperty("address1")
                private String address1;
                @JsonProperty("address2")
                private String address2;
                @JsonProperty("city")
                private String city;
                @JsonProperty("state")
                private String state;
                @JsonProperty("postalCode")
                private String postalCode;
                @JsonProperty("country")
                private String country;
                @JsonProperty("addressType")
                private String addressType;
            }
        }

        @NoArgsConstructor
        @Data
        public static class OrderLinesDTO {
            @JsonProperty("orderLine")
            private List<OrderLineDTO> orderLine;

            @NoArgsConstructor
            @Data
            public static class OrderLineDTO {
                @JsonProperty("lineNumber")
                private String lineNumber;
                @JsonProperty("item")
                private ItemDTO item;
                @JsonProperty("charges")
                private ChargesDTO charges;
                @JsonProperty("orderLineQuantity")
                private OrderLineQuantityDTO orderLineQuantity;
                @JsonProperty("statusDate")
                private Long statusDate;
                @JsonProperty("orderLineStatuses")
                private OrderLineStatusesDTO orderLineStatuses;
                @JsonProperty("fulfillment")
                private FulfillmentDTO fulfillment;

                @NoArgsConstructor
                @Data
                public static class ItemDTO {
                    @JsonProperty("productName")
                    private String productName;
                    @JsonProperty("sku")
                    private String sku;
                }

                @NoArgsConstructor
                @Data
                public static class ChargesDTO {
                    @JsonProperty("charge")
                    private List<ChargeDTO> charge;

                    @NoArgsConstructor
                    @Data
                    public static class ChargeDTO {
                        @JsonProperty("chargeType")
                        private String chargeType;
                        @JsonProperty("chargeName")
                        private String chargeName;
                        @JsonProperty("chargeAmount")
                        private ChargeAmountDTO chargeAmount;
                        @JsonProperty("tax")
                        private TaxDTO tax;

                        @NoArgsConstructor
                        @Data
                        public static class ChargeAmountDTO {
                            @JsonProperty("currency")
                            private String currency;
                            @JsonProperty("amount")
                            private Integer amount;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class TaxDTO {
                            @JsonProperty("taxName")
                            private String taxName;
                            @JsonProperty("taxAmount")
                            private TaxAmountDTO taxAmount;

                            @NoArgsConstructor
                            @Data
                            public static class TaxAmountDTO {
                                @JsonProperty("currency")
                                private String currency;
                                @JsonProperty("amount")
                                private Double amount;
                            }
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class OrderLineQuantityDTO {
                    @JsonProperty("unitOfMeasurement")
                    private String unitOfMeasurement;
                    @JsonProperty("amount")
                    private String amount;
                }

                @NoArgsConstructor
                @Data
                public static class OrderLineStatusesDTO {
                    @JsonProperty("orderLineStatus")
                    private List<OrderLineStatusDTO> orderLineStatus;

                    @NoArgsConstructor
                    @Data
                    public static class OrderLineStatusDTO {
                        @JsonProperty("status")
                        private String status;
                        @JsonProperty("statusQuantity")
                        private StatusQuantityDTO statusQuantity;

                        @NoArgsConstructor
                        @Data
                        public static class StatusQuantityDTO {
                            @JsonProperty("unitOfMeasurement")
                            private String unitOfMeasurement;
                            @JsonProperty("amount")
                            private String amount;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class FulfillmentDTO {
                    @JsonProperty("fulfillmentOption")
                    private String fulfillmentOption;
                    @JsonProperty("shipMethod")
                    private String shipMethod;
                    @JsonProperty("pickUpDateTime")
                    private Long pickUpDateTime;
                }
            }
        }
    }
}
