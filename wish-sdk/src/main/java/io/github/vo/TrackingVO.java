package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/18 16:58
 */
@NoArgsConstructor
@Data
public class TrackingVO {


    @JsonProperty("tracking_information")
    private List<TrackingInformationDTO> trackingInformation;
    @JsonProperty("warehouse_information")
    private WarehouseInformationDTO warehouseInformation;
    @JsonProperty("order_payment")
    private OrderPaymentDTO orderPayment;
    @JsonProperty("fulfillment_records")
    private List<FulfillmentRecordsDTO> fulfillmentRecords;
    @JsonProperty("released_at")
    private String releasedAt;
    @JsonProperty("product_information")
    private ProductInformationDTO productInformation;
    @JsonProperty("penalties")
    private List<String> penalties;
    @JsonProperty("processing_status")
    private String processingStatus;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("full_address")
    private FullAddressDTO fullAddress;
    @JsonProperty("processing_source")
    private String processingSource;
    @JsonProperty("fulfillment_requirements")
    private FulfillmentRequirementsDTO fulfillmentRequirements;
    @JsonProperty("state")
    private String state;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("tax_information")
    private TaxInformationDTO taxInformation;
    @JsonProperty("refunds")
    private List<RefundsDTO> refunds;
    @JsonProperty("id")
    private String id;
    @JsonProperty("fulfillment_order_types")
    private List<String> fulfillmentOrderTypes;

    @NoArgsConstructor
    @Data
    public static class WarehouseInformationDTO {
        @JsonProperty("warehouse_type")
        private String warehouseType;
        @JsonProperty("warehouse_name")
        private String warehouseName;
        @JsonProperty("warehouse_id")
        private String warehouseId;
        @JsonProperty("fbw_information")
        private FbwInformationDTO fbwInformation;

        @NoArgsConstructor
        @Data
        public static class FbwInformationDTO {
            @JsonProperty("fbw_warehouse_code")
            private String fbwWarehouseCode;
            @JsonProperty("fbw_fees")
            private List<FbwFeesDTO> fbwFees;
            @JsonProperty("lot_information")
            private List<LotInformationDTO> lotInformation;

            @NoArgsConstructor
            @Data
            public static class FbwFeesDTO {
                @JsonProperty("amount")
                private AmountDTO amount;
                @JsonProperty("fee_name")
                private String feeName;
                @JsonProperty("fee_type")
                private String feeType;

                @NoArgsConstructor
                @Data
                public static class AmountDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }
            }

            @NoArgsConstructor
            @Data
            public static class LotInformationDTO {
                @JsonProperty("lot_id")
                private String lotId;
                @JsonProperty("quantity")
                private Integer quantity;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class OrderPaymentDTO {
        @JsonProperty("carrier_subsidies")
        private List<CarrierSubsidiesDTO> carrierSubsidies;
        @JsonProperty("shipping_reimbursements")
        private List<ShippingReimbursementsDTO> shippingReimbursements;
        @JsonProperty("rev_share")
        private RevShareDTO revShare;
        @JsonProperty("general_payment_details")
        private GeneralPaymentDetailsDTO generalPaymentDetails;

        @NoArgsConstructor
        @Data
        public static class RevShareDTO {
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
        public static class GeneralPaymentDetailsDTO {
            @JsonProperty("shipping_merchant_payment")
            private ShippingMerchantPaymentDTO shippingMerchantPayment;
            @JsonProperty("payment_total")
            private PaymentTotalDTO paymentTotal;
            @JsonProperty("product_price")
            private ProductPriceDTO productPrice;
            @JsonProperty("product_merchant_payment")
            private ProductMerchantPaymentDTO productMerchantPayment;
            @JsonProperty("product_shipping_price")
            private ProductShippingPriceDTO productShippingPrice;
            @JsonProperty("product_quantity")
            private Integer productQuantity;
            @JsonProperty("customer_paid_prices_detail")
            private CustomerPaidPricesDetailDTO customerPaidPricesDetail;

            @NoArgsConstructor
            @Data
            public static class ShippingMerchantPaymentDTO {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class PaymentTotalDTO {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class ProductPriceDTO {
                @JsonProperty("amount")
                private Integer amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class ProductMerchantPaymentDTO {
                @JsonProperty("amount")
                private Integer amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class ProductShippingPriceDTO {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class CustomerPaidPricesDetailDTO {
                @JsonProperty("total")
                private TotalDTO total;
                @JsonProperty("product_price")
                private ProductPriceDTO productPrice;
                @JsonProperty("product_price_total")
                private ProductPriceTotalDTO productPriceTotal;
                @JsonProperty("shipping_price")
                private ShippingPriceDTO shippingPrice;
                @JsonProperty("shipping_price_total")
                private ShippingPriceTotalDTO shippingPriceTotal;

                @NoArgsConstructor
                @Data
                public static class TotalDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ProductPriceDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ProductPriceTotalDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingPriceDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingPriceTotalDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class CarrierSubsidiesDTO {
            @JsonProperty("subsidy")
            private SubsidyDTO subsidy;
            @JsonProperty("carrier_name")
            private String carrierName;

            @NoArgsConstructor
            @Data
            public static class SubsidyDTO {
                @JsonProperty("amount")
                private Integer amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ShippingReimbursementsDTO {
            @JsonProperty("status")
            private String status;
            @JsonProperty("amount")
            private AmountDTO amount;

            @NoArgsConstructor
            @Data
            public static class AmountDTO {
                @JsonProperty("amount")
                private Double amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class ProductInformationDTO {
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
    public static class FullAddressDTO {
        @JsonProperty("shipping_detail")
        private ShippingDetailDTO shippingDetail;

        @NoArgsConstructor
        @Data
        public static class ShippingDetailDTO {
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
            private PhoneNumberDTO phoneNumber;
            @JsonProperty("region")
            private String region;
            @JsonProperty("neighborhood")
            private String neighborhood;
            @JsonProperty("name")
            private String name;

            @NoArgsConstructor
            @Data
            public static class PhoneNumberDTO {
                @JsonProperty("number")
                private String number;
                @JsonProperty("country_code")
                private String countryCode;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class FulfillmentRequirementsDTO {
        @JsonProperty("expected_ship_time")
        private String expectedShipTime;
        @JsonProperty("expected_delivery_time")
        private String expectedDeliveryTime;
    }

    @NoArgsConstructor
    @Data
    public static class TaxInformationDTO {
        @JsonProperty("transaction_tax")
        private List<TransactionTaxDTO> transactionTax;
        @JsonProperty("customer_identity_number_type")
        private String customerIdentityNumberType;
        @JsonProperty("vat_information")
        private VatInformationDTO vatInformation;
        @JsonProperty("customer_identity_number")
        private String customerIdentityNumber;

        @NoArgsConstructor
        @Data
        public static class VatInformationDTO {
            @JsonProperty("eu_vat_customs_declaration")
            private EuVatCustomsDeclarationDTO euVatCustomsDeclaration;
            @JsonProperty("vat_amount")
            private VatAmountDTO vatAmount;
            @JsonProperty("country_code")
            private String countryCode;
            @JsonProperty("required_vat_numbers")
            private RequiredVatNumbersDTO requiredVatNumbers;
            @JsonProperty("vat_instructions")
            private String vatInstructions;
            @JsonProperty("additional_materials")
            private List<String> additionalMaterials;

            @NoArgsConstructor
            @Data
            public static class EuVatCustomsDeclarationDTO {
                @JsonProperty("product")
                private ProductDTO product;
                @JsonProperty("merchant_identity")
                private String merchantIdentity;
                @JsonProperty("vat_paid_in_authority_currency")
                private VatPaidInAuthorityCurrencyDTO vatPaidInAuthorityCurrency;
                @JsonProperty("vat_paid_in_customer_currency")
                private VatPaidInCustomerCurrencyDTO vatPaidInCustomerCurrency;
                @JsonProperty("shipping_cost_in_customer_currency")
                private ShippingCostInCustomerCurrencyDTO shippingCostInCustomerCurrency;
                @JsonProperty("customer_identity")
                private String customerIdentity;
                @JsonProperty("vat_payer")
                private VatPayerDTO vatPayer;
                @JsonProperty("merchant_address")
                private MerchantAddressDTO merchantAddress;
                @JsonProperty("invoice_amount_in_customer_currency")
                private InvoiceAmountInCustomerCurrencyDTO invoiceAmountInCustomerCurrency;
                @JsonProperty("shipping_cost_in_authority_currency")
                private ShippingCostInAuthorityCurrencyDTO shippingCostInAuthorityCurrency;
                @JsonProperty("invoice_amount_in_authority_currency")
                private InvoiceAmountInAuthorityCurrencyDTO invoiceAmountInAuthorityCurrency;
                @JsonProperty("customer_address")
                private CustomerAddressDTO customerAddress;
                @JsonProperty("merchant_name")
                private String merchantName;
                @JsonProperty("platform_status")
                private String platformStatus;
                @JsonProperty("customer_name")
                private String customerName;

                @NoArgsConstructor
                @Data
                public static class ProductDTO {
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("weight")
                    private WeightDTO weight;
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
                    public static class WeightDTO {
                        @JsonProperty("value")
                        private Integer value;
                        @JsonProperty("unit")
                        private String unit;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class VatPaidInAuthorityCurrencyDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class VatPaidInCustomerCurrencyDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingCostInCustomerCurrencyDTO {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class VatPayerDTO {
                    @JsonProperty("ioss_number")
                    private String iossNumber;
                    @JsonProperty("tax_number")
                    private String taxNumber;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("address")
                    private AddressDTO address;

                    @NoArgsConstructor
                    @Data
                    public static class AddressDTO {
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
                public static class MerchantAddressDTO {
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
                public static class InvoiceAmountInCustomerCurrencyDTO {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ShippingCostInAuthorityCurrencyDTO {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class InvoiceAmountInAuthorityCurrencyDTO {
                    @JsonProperty("amount")
                    private Double amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class CustomerAddressDTO {
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
            public static class VatAmountDTO {
                @JsonProperty("shipping_level_vat")
                private ShippingLevelVatDTO shippingLevelVat;
                @JsonProperty("final_vat")
                private FinalVatDTO finalVat;
                @JsonProperty("product_level_vat")
                private ProductLevelVatDTO productLevelVat;

                @NoArgsConstructor
                @Data
                public static class ShippingLevelVatDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class FinalVatDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }

                @NoArgsConstructor
                @Data
                public static class ProductLevelVatDTO {
                    @JsonProperty("amount")
                    private Integer amount;
                    @JsonProperty("currency_code")
                    private String currencyCode;
                }
            }

            @NoArgsConstructor
            @Data
            public static class RequiredVatNumbersDTO {
                @JsonProperty("voec")
                private VoecDTO voec;
                @JsonProperty("eori")
                private EoriDTO eori;
                @JsonProperty("vat")
                private VatDTO vat;

                @NoArgsConstructor
                @Data
                public static class VoecDTO {
                    @JsonProperty("number")
                    private String number;
                    @JsonProperty("entity")
                    private String entity;
                }

                @NoArgsConstructor
                @Data
                public static class EoriDTO {
                    @JsonProperty("number")
                    private String number;
                    @JsonProperty("entity")
                    private String entity;
                }

                @NoArgsConstructor
                @Data
                public static class VatDTO {
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
        public static class TransactionTaxDTO {
            @JsonProperty("tax_amount_in_merchant_currency")
            private TaxAmountInMerchantCurrencyDTO taxAmountInMerchantCurrency;
            @JsonProperty("tax_amount_in_authority_currency")
            private TaxAmountInAuthorityCurrencyDTO taxAmountInAuthorityCurrency;
            @JsonProperty("tax_type")
            private String taxType;
            @JsonProperty("remit_type")
            private String remitType;

            @NoArgsConstructor
            @Data
            public static class TaxAmountInMerchantCurrencyDTO {
                @JsonProperty("amount")
                private Integer amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }

            @NoArgsConstructor
            @Data
            public static class TaxAmountInAuthorityCurrencyDTO {
                @JsonProperty("amount")
                private Integer amount;
                @JsonProperty("currency_code")
                private String currencyCode;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class TrackingInformationDTO {
        @JsonProperty("tracking_number")
        private String trackingNumber;
        @JsonProperty("origin_country")
        private String originCountry;
        @JsonProperty("ship_note")
        private String shipNote;
        @JsonProperty("shipping_provider")
        private ShippingProviderDTO shippingProvider;

        @NoArgsConstructor
        @Data
        public static class ShippingProviderDTO {
            @JsonProperty("name")
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class FulfillmentRecordsDTO {
        @JsonProperty("event_type")
        private String eventType;
        @JsonProperty("event_time")
        private String eventTime;
    }

    @NoArgsConstructor
    @Data
    public static class RefundsDTO {
        @JsonProperty("refund_reason_note")
        private String refundReasonNote;
        @JsonProperty("refund_source")
        private String refundSource;
        @JsonProperty("refund_amount")
        private RefundAmountDTO refundAmount;
        @JsonProperty("merchant_responsible_amount")
        private MerchantResponsibleAmountDTO merchantResponsibleAmount;
        @JsonProperty("refund_time")
        private String refundTime;
        @JsonProperty("refund_reason")
        private String refundReason;

        @NoArgsConstructor
        @Data
        public static class RefundAmountDTO {
            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("currency_code")
            private String currencyCode;
        }

        @NoArgsConstructor
        @Data
        public static class MerchantResponsibleAmountDTO {
            @JsonProperty("amount")
            private Double amount;
            @JsonProperty("currency_code")
            private String currencyCode;
        }
    }
}
