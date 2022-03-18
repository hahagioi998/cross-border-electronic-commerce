package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/23 13:38
 */
@NoArgsConstructor
@Data
public class WishOrder {


    @JsonProperty("tracking_information")
    private List<TrackingInformation> trackingInformation;
    @JsonProperty("warehouse_information")
    private WarehouseInformation warehouseInformation;
    @JsonProperty("order_payment")
    private OrderPayment orderPayment;
    @JsonProperty("fulfillment_records")
    private List<FulfillmentRecords> fulfillmentRecords;
    @JsonProperty("released_at")
    private String releasedAt;
    @JsonProperty("product_information")
    private ProductInformation productInformation;
    @JsonProperty("penalties")
    private List<String> penalties;
    @JsonProperty("processing_status")
    private String processingStatus;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("full_address")
    private FullAddress fullAddress;
    @JsonProperty("processing_source")
    private String processingSource;
    @JsonProperty("fulfillment_requirements")
    private FulfillmentRequirements fulfillmentRequirements;
    @JsonProperty("state")
    private String state;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("tax_information")
    private TaxInformation taxInformation;
    @JsonProperty("refunds")
    private List<Refunds> refunds;
    @JsonProperty("id")
    private String id;
    @JsonProperty("fulfillment_order_types")
    private List<String> fulfillmentOrderTypes;

    @NoArgsConstructor
    @Data
    public static class WarehouseInformation {
        @JsonProperty("warehouse_type")
        private String warehouseType;
        @JsonProperty("warehouse_name")
        private String warehouseName;
        @JsonProperty("warehouse_id")
        private String warehouseId;
        @JsonProperty("fbw_information")
        private FbwInformation fbwInformation;

        @NoArgsConstructor
        @Data
        public static class FbwInformation {
            @JsonProperty("fbw_warehouse_code")
            private String fbwWarehouseCode;
            @JsonProperty("fbw_fees")
            private List<FbwFees> fbwFees;
            @JsonProperty("lot_information")
            private List<LotInformation> lotInformation;

            @NoArgsConstructor
            @Data
            public static class FbwFees {
                @JsonProperty("amount")
                private AmountVO amount;
                @JsonProperty("fee_name")
                private String feeName;
                @JsonProperty("fee_type")
                private String feeType;

                @NoArgsConstructor
                @Data
                public static class AmountVO {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }
            }

            @NoArgsConstructor
            @Data
            public static class LotInformation {
                @JsonProperty("lot_id")
                private String lotId;
                @JsonProperty("quantity")
                private Integer quantity;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class OrderPayment {
        @JsonProperty("carrier_subsidies")
        private List<CarrierSubsidies> carrierSubsidies;
        @JsonProperty("shipping_reimbursements")
        private List<ShippingReimbursements> shippingReimbursements;
        @JsonProperty("rev_share")
        private RevShareVO revShare;
        @JsonProperty("general_payment_details")
        private GeneralPaymentDetails generalPaymentDetails;

        @NoArgsConstructor
        @Data
        public static class RevShareVO {
            @JsonProperty("destination_region")
            private String destinationRegion;
            @JsonProperty("rev_share")
            private Integer revShare;
            @JsonProperty("product_category")
            private String productCategory;
            @JsonProperty("entity_region")
            private String entityRegion;
            @JsonProperty("source_region")
            private String sourceRegion;
            @JsonProperty("shipping_type")
            private String shippingType;
        }

        @NoArgsConstructor
        @Data
        public static class GeneralPaymentDetails {
            @JsonProperty("shipping_merchant_payment")
            private ShippingMerchantPayment shippingMerchantPayment;
            @JsonProperty("payment_total")
            private PaymentTotal paymentTotal;
            @JsonProperty("product_price")
            private ProductPrice productPrice;
            @JsonProperty("product_merchant_payment")
            private ProductMerchantPayment productMerchantPayment;
            @JsonProperty("product_shipping_price")
            private ProductShippingPrice productShippingPrice;
            @JsonProperty("product_quantity")
            private Integer productQuantity;
            @JsonProperty("customer_paid_prices_detail")
            private CustomerPaidPricesDetail customerPaidPricesDetail;

            @NoArgsConstructor
            @Data
            public static class ShippingMerchantPayment {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class PaymentTotal {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class ProductPrice {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class ProductMerchantPayment {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class ProductShippingPrice {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class CustomerPaidPricesDetail {
                @JsonProperty("total")
                private Total total;
                @JsonProperty("product_price")
                private ProductPrice productPrice;
                @JsonProperty("product_price_total")
                private ProductPriceTotal productPriceTotal;
                @JsonProperty("shipping_price")
                private ShippingPrice shippingPrice;
                @JsonProperty("shipping_price_total")
                private ShippingPriceTotal shippingPriceTotal;

                @NoArgsConstructor
                @Data
                public static class Total {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ProductPrice {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ProductPriceTotal {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingPrice {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingPriceTotal {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class CarrierSubsidies {
            @JsonProperty("subsidy")
            private Subsidy subsidy;
            @JsonProperty("carrier_name")
            private String carrierName;

            @NoArgsConstructor
            @Data
            public static class Subsidy {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ShippingReimbursements {
            @JsonProperty("status")
            private String status;
            @JsonProperty("amount")
            private AmountVO amount;

            @NoArgsConstructor
            @Data
            public static class AmountVO {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class ProductInformation {
        @JsonProperty("sku")
        private String sku;
        @JsonProperty("name")
        private String name;
        @JsonProperty("color")
        private String color;
        @JsonProperty("manufactured_country")
        private String manufacturedCountry;
        @JsonProperty("variation_image_url")
        private String variationImageUrl;
        @JsonProperty("variation_id")
        private String variationId;
        @JsonProperty("id")
        private String id;
        @JsonProperty("size")
        private String size;
    }

    @NoArgsConstructor
    @Data
    public static class FullAddress {
        @JsonProperty("shipping_detail")
        private ShippingDetail shippingDetail;

        @NoArgsConstructor
        @Data
        public static class ShippingDetail {
            @JsonProperty("city")
            private String city;
            @JsonProperty("country")
            private String country;
            @JsonProperty("street_address3")
            private String streetAddress3;
            @JsonProperty("street_address2")
            private String streetAddress2;
            @JsonProperty("street_address1")
            private String streetAddress1;
            @JsonProperty("zipcode")
            private String zipcode;
            @JsonProperty("state")
            private String state;
            @JsonProperty("country_code")
            private String countryCode;
            @JsonProperty("phone_number")
            private PhoneNumber phoneNumber;
            @JsonProperty("region")
            private String region;
            @JsonProperty("neighborhood")
            private String neighborhood;
            @JsonProperty("name")
            private String name;

            @NoArgsConstructor
            @Data
            public static class PhoneNumber {
                @JsonProperty("number")
                private String number;
                @JsonProperty("country_code")
                private String countryCode;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class FulfillmentRequirements {
        @JsonProperty("expected_ship_time")
        private String expectedShipTime;
        @JsonProperty("expected_delivery_time")
        private String expectedDeliveryTime;
    }

    @NoArgsConstructor
    @Data
    public static class TaxInformation {
        @JsonProperty("transaction_tax")
        private List<TransactionTax> transactionTax;
        @JsonProperty("customer_identity_number_type")
        private String customerIdentityNumberType;
        @JsonProperty("vat_information")
        private VatInformation vatInformation;
        @JsonProperty("customer_identity_number")
        private String customerIdentityNumber;

        @NoArgsConstructor
        @Data
        public static class VatInformation {
            @JsonProperty("eu_vat_customs_declaration")
            private EuVatCustomsDeclaration euVatCustomsDeclaration;
            @JsonProperty("vat_amount")
            private VatAmount vatAmount;
            @JsonProperty("country_code")
            private String countryCode;
            @JsonProperty("required_vat_numbers")
            private RequiredVatNumbers requiredVatNumbers;
            @JsonProperty("vat_instructions")
            private String vatInstructions;
            @JsonProperty("additional_materials")
            private List<String> additionalMaterials;

            @NoArgsConstructor
            @Data
            public static class EuVatCustomsDeclaration {
                @JsonProperty("product")
                private Product product;
                @JsonProperty("merchant_identity")
                private String merchantIdentity;
                @JsonProperty("vat_paid_in_authority_currency")
                private VatPaidInAuthorityCurrency vatPaidInAuthorityCurrency;
                @JsonProperty("vat_paid_in_customer_currency")
                private VatPaidInCustomerCurrency vatPaidInCustomerCurrency;
                @JsonProperty("shipping_cost_in_customer_currency")
                private ShippingCostInCustomerCurrency shippingCostInCustomerCurrency;
                @JsonProperty("customer_identity")
                private String customerIdentity;
                @JsonProperty("vat_payer")
                private VatPayer vatPayer;
                @JsonProperty("merchant_address")
                private MerchantAddress merchantAddress;
                @JsonProperty("invoice_amount_in_customer_currency")
                private InvoiceAmountInCustomerCurrency invoiceAmountInCustomerCurrency;
                @JsonProperty("shipping_cost_in_authority_currency")
                private ShippingCostInAuthorityCurrency shippingCostInAuthorityCurrency;
                @JsonProperty("invoice_amount_in_authority_currency")
                private InvoiceAmountInAuthorityCurrency invoiceAmountInAuthorityCurrency;
                @JsonProperty("customer_address")
                private CustomerAddress customerAddress;
                @JsonProperty("merchant_name")
                private String merchantName;
                @JsonProperty("platform_status")
                private String platformStatus;
                @JsonProperty("customer_name")
                private String customerName;

                @NoArgsConstructor
                @Data
                public static class Product {
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("weight")
                    private Weight weight;
                    @JsonProperty("image_url")
                    private String imageUrl;
                    @JsonProperty("hs_code")
                    private String hsCode;
                    @JsonProperty("condition")
                    private String condition;
                    @JsonProperty("quantity")
                    private Integer quantity;

                    @NoArgsConstructor
                    @Data
                    public static class Weight {
                        @JsonProperty("value")
                        private Integer value;
                        @JsonProperty("unit")
                        private String unit;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class VatPaidInAuthorityCurrency {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class VatPaidInCustomerCurrency {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingCostInCustomerCurrency {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class VatPayer {
                    @JsonProperty("ioss_number")
                    private String iossNumber;
                    @JsonProperty("tax_number")
                    private String taxNumber;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("address")
                    private Address address;

                    @NoArgsConstructor
                    @Data
                    public static class Address {
                        @JsonProperty("city")
                        private String city;
                        @JsonProperty("country")
                        private String country;
                        @JsonProperty("street_address3")
                        private String streetAddress3;
                        @JsonProperty("street_address2")
                        private String streetAddress2;
                        @JsonProperty("street_address1")
                        private String streetAddress1;
                        @JsonProperty("zipcode")
                        private String zipcode;
                        @JsonProperty("state")
                        private String state;
                        @JsonProperty("country_code")
                        private String countryCode;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class MerchantAddress {
                    @JsonProperty("city")
                    private String city;
                    @JsonProperty("country")
                    private String country;
                    @JsonProperty("street_address3")
                    private String streetAddress3;
                    @JsonProperty("street_address2")
                    private String streetAddress2;
                    @JsonProperty("street_address1")
                    private String streetAddress1;
                    @JsonProperty("zipcode")
                    private String zipcode;
                    @JsonProperty("state")
                    private String state;
                    @JsonProperty("country_code")
                    private String countryCode;
                }

                @NoArgsConstructor
                @Data
                public static class InvoiceAmountInCustomerCurrency {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingCostInAuthorityCurrency {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class InvoiceAmountInAuthorityCurrency {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class CustomerAddress {
                    @JsonProperty("city")
                    private String city;
                    @JsonProperty("country")
                    private String country;
                    @JsonProperty("street_address3")
                    private String streetAddress3;
                    @JsonProperty("street_address2")
                    private String streetAddress2;
                    @JsonProperty("street_address1")
                    private String streetAddress1;
                    @JsonProperty("zipcode")
                    private String zipcode;
                    @JsonProperty("state")
                    private String state;
                    @JsonProperty("country_code")
                    private String countryCode;
                }
            }

            @NoArgsConstructor
            @Data
            public static class VatAmount {
                @JsonProperty("shipping_level_vat")
                private ShippingLevelVat shippingLevelVat;
                @JsonProperty("final_vat")
                private FinalVat finalVat;
                @JsonProperty("product_level_vat")
                private ProductLevelVat productLevelVat;

                @NoArgsConstructor
                @Data
                public static class ShippingLevelVat {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class FinalVat {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ProductLevelVat {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }
            }

            @NoArgsConstructor
            @Data
            public static class RequiredVatNumbers {
                @JsonProperty("voec")
                private Voec voec;
                @JsonProperty("eori")
                private Eori eori;
                @JsonProperty("vat")
                private Vat vat;

                @NoArgsConstructor
                @Data
                public static class Voec {
                    @JsonProperty("number")
                    private String number;
                    @JsonProperty("entity")
                    private String entity;
                }

                @NoArgsConstructor
                @Data
                public static class Eori {
                    @JsonProperty("number")
                    private String number;
                    @JsonProperty("entity")
                    private String entity;
                }

                @NoArgsConstructor
                @Data
                public static class Vat {
                    @JsonProperty("number")
                    private String number;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("entity")
                    private String entity;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class TransactionTax {
            @JsonProperty("tax_amount_in_merchant_currency")
            private TaxAmountInMerchantCurrency taxAmountInMerchantCurrency;
            @JsonProperty("tax_amount_in_authority_currency")
            private TaxAmountInAuthorityCurrency taxAmountInAuthorityCurrency;
            @JsonProperty("tax_type")
            private String taxType;
            @JsonProperty("remit_type")
            private String remitType;

            @NoArgsConstructor
            @Data
            public static class TaxAmountInMerchantCurrency {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class TaxAmountInAuthorityCurrency {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class TrackingInformation {
        @JsonProperty("tracking_number")
        private String trackingNumber;
        @JsonProperty("origin_country")
        private String originCountry;
        @JsonProperty("ship_note")
        private String shipNote;
        @JsonProperty("shipping_provider")
        private ShippingProvider shippingProvider;

        @NoArgsConstructor
        @Data
        public static class ShippingProvider {
            @JsonProperty("name")
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class FulfillmentRecords {
        @JsonProperty("event_type")
        private String eventType;
        @JsonProperty("event_time")
        private String eventTime;
    }

    @NoArgsConstructor
    @Data
    public static class Refunds {
        @JsonProperty("refund_reason_note")
        private String refundReasonNote;
        @JsonProperty("refund_source")
        private String refundSource;
        @JsonProperty("refund_amount")
        private RefundAmount refundAmount;
        @JsonProperty("merchant_responsible_amount")
        private MerchantResponsibleAmount merchantResponsibleAmount;
        @JsonProperty("refund_time")
        private String refundTime;
        @JsonProperty("refund_reason")
        private String refundReason;

        @NoArgsConstructor
        @Data
        public static class RefundAmount {
            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("currency_code")
            private String currencyCode;
        }

        @NoArgsConstructor
        @Data
        public static class MerchantResponsibleAmount {
            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("currency_code")
            private String currencyCode;
        }
    }
}
