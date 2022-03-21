package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/21 14:13
 */
@NoArgsConstructor
@Data
public class WalmartCancel {

    @JsonProperty("order")
    private Order order;

    @NoArgsConstructor
    @Data
    public static class Order {
        @JsonProperty("purchaseOrderId")
        private String purchaseOrderId;
        @JsonProperty("customerOrderId")
        private String customerOrderId;
        @JsonProperty("customerEmailId")
        private String customerEmailId;
        @JsonProperty("orderDate")
        private Long orderDate;
        @JsonProperty("shippingInfo")
        private ShippingInfo shippingInfo;
        @JsonProperty("orderLines")
        private OrderLines orderLines;

        @NoArgsConstructor
        @Data
        public static class ShippingInfo {
            @JsonProperty("phone")
            private String phone;
            @JsonProperty("estimatedDeliveryDate")
            private Long estimatedDeliveryDate;
            @JsonProperty("estimatedShipDate")
            private Long estimatedShipDate;
            @JsonProperty("methodCode")
            private String methodCode;
            @JsonProperty("postalAddress")
            private PostalAddress postalAddress;

            @NoArgsConstructor
            @Data
            public static class PostalAddress {
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
        public static class OrderLines {
            @JsonProperty("orderLine")
            private List<OrderLine> orderLine;

            @NoArgsConstructor
            @Data
            public static class OrderLine {
                @JsonProperty("lineNumber")
                private String lineNumber;
                @JsonProperty("item")
                private Item item;
                @JsonProperty("charges")
                private Charges charges;
                @JsonProperty("orderLineQuantity")
                private OrderLineQuantity orderLineQuantity;
                @JsonProperty("statusDate")
                private Long statusDate;
                @JsonProperty("orderLineStatuses")
                private OrderLineStatuses orderLineStatuses;

                @NoArgsConstructor
                @Data
                public static class Item {
                    @JsonProperty("productName")
                    private String productName;
                    @JsonProperty("sku")
                    private String sku;
                }

                @NoArgsConstructor
                @Data
                public static class Charges {
                    @JsonProperty("charge")
                    private List<Charge> charge;

                    @NoArgsConstructor
                    @Data
                    public static class Charge {
                        @JsonProperty("chargeType")
                        private String chargeType;
                        @JsonProperty("chargeName")
                        private String chargeName;
                        @JsonProperty("chargeAmount")
                        private ChargeAmount chargeAmount;
                        @JsonProperty("tax")
                        private Tax tax;

                        @NoArgsConstructor
                        @Data
                        public static class ChargeAmount {
                            @JsonProperty("currency")
                            private String currency;
                            @JsonProperty("amount")
                            private Integer amount;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class Tax {
                            @JsonProperty("taxName")
                            private String taxName;
                            @JsonProperty("taxAmount")
                            private TaxAmount taxAmount;

                            @NoArgsConstructor
                            @Data
                            public static class TaxAmount {
                                @JsonProperty("currency")
                                private String currency;
                                @JsonProperty("amount")
                                private Integer amount;
                            }
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class OrderLineQuantity {
                    @JsonProperty("unitOfMeasurement")
                    private String unitOfMeasurement;
                    @JsonProperty("amount")
                    private String amount;
                }

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
