package io.github.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/21 13:40
 */
@NoArgsConstructor
@Data
public class RefundDTO {

    @JsonProperty("orderRefund")
    private OrderRefund orderRefund;

    @NoArgsConstructor
    @Data
    public static class OrderRefund {
        @JsonProperty("purchaseOrderId")
        private String purchaseOrderId;
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
                @JsonProperty("refunds")
                private Refunds refunds;

                @NoArgsConstructor
                @Data
                public static class Refunds {
                    @JsonProperty("refund")
                    private List<Refund> refund;

                    @NoArgsConstructor
                    @Data
                    public static class Refund {
                        @JsonProperty("refundComments")
                        private String refundComments;
                        @JsonProperty("refundCharges")
                        private RefundCharges refundCharges;

                        @NoArgsConstructor
                        @Data
                        public static class RefundCharges {
                            @JsonProperty("refundCharge")
                            private List<RefundCharge> refundCharge;

                            @NoArgsConstructor
                            @Data
                            public static class RefundCharge {
                                @JsonProperty("refundReason")
                                private String refundReason;
                                @JsonProperty("charge")
                                private Charge charge;

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
                                        private Double amount;
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
                                            private Double amount;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
