package io.github.marketplace.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/21 11:30
 */
@NoArgsConstructor
@Data
public class WalmartReleasedOrders {


    @JsonProperty("list")
    private ListDTO list;

    @NoArgsConstructor
    @Data
    public static class ListDTO {
        @JsonProperty("meta")
        private MetaDTO meta;
        @JsonProperty("elements")
        private ElementsDTO elements;

        @NoArgsConstructor
        @Data
        public static class MetaDTO {
            @JsonProperty("totalCount")
            private Integer totalCount;
            @JsonProperty("limit")
            private Integer limit;
            @JsonProperty("nextCursor")
            private String nextCursor;
        }

        @NoArgsConstructor
        @Data
        public static class ElementsDTO {
            @JsonProperty("order")
            private List<OrderDTO> order;

            @NoArgsConstructor
            @Data
            public static class OrderDTO {
                @JsonProperty("purchaseOrderId")
                private String purchaseOrderId;
                @JsonProperty("customerOrderId")
                private String customerOrderId;
                @JsonProperty("customerEmailId")
                private String customerEmailId;
                @JsonProperty("orderType")
                private String orderType;
                @JsonProperty("originalCustomerOrderID")
                private String originalCustomerOrderID;
                @JsonProperty("orderDate")
                private Long orderDate;
                @JsonProperty("shippingInfo")
                private ShippingInfoDTO shippingInfo;
                @JsonProperty("orderLines")
                private OrderLinesDTO orderLines;
                @JsonProperty("shipNode")
                private ShipNode shipNode;

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
                        private Fulfillment fulfillment;

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
                        public static class Fulfillment {
                            @JsonProperty("fulfillmentOption")
                            private String fulfillmentOption;
                            @JsonProperty("shipMethod")
                            private String shipMethod;
                            @JsonProperty("pickUpDateTime")
                            private Long pickUpDateTime;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class ShipNode {
                    @JsonProperty("type")
                    private String type;
                }
            }
        }
    }
}
