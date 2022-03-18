package io.github.vo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/22 15:16
 */
@NoArgsConstructor
@Data
public class AmazonOrderItems {

    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;
    @JsonProperty("NextToken")
    private String nextToken;
    @JsonProperty("OrderItems")
    private List<AmazonOrderItem> orderItems;
    /**
     * Created by EalenXie on 2022/2/22 15:18
     */
    @NoArgsConstructor
    @Data
    public static class AmazonOrderItem {

        @JsonProperty("ASIN")
        private String asin;
        @JsonProperty("OrderItemId")
        private String orderItemId;
        @JsonProperty("QuantityOrdered")
        private Integer quantityOrdered;
        @JsonProperty("SellerSKU")
        private String sellerSKU;
        @JsonProperty("Title")
        private String title;
        @JsonProperty("QuantityShipped")
        private Integer quantityShipped;
        @JsonProperty("ProductInfo")
        private ProductInfo productInfo;
        @JsonProperty("PointsGranted")
        private PointsGranted pointsGranted;
        @JsonProperty("ItemPrice")
        private ItemPrice itemPrice;
        @JsonProperty("ShippingPrice")
        private ShippingPrice shippingPrice;
        @JsonProperty("ItemTax")
        private ItemTax itemTax;
        @JsonProperty("ShippingTax")
        private ShippingTax shippingTax;
        @JsonProperty("ShippingDiscount")
        private ShippingDiscount shippingDiscount;
        @JsonProperty("ShippingDiscountTax")
        private ShippingDiscountTax shippingDiscountTax;
        @JsonProperty("PromotionDiscount")
        private PromotionDiscount promotionDiscount;
        @JsonProperty("PromotionDiscountTax")
        private PromotionDiscountTax promotionDiscountTax;
        @JsonProperty("PromotionIds")
        private List<String> promotionIds;
        @JsonProperty("CODFee")
        private CODFee cODFee;
        @JsonProperty("CODFeeDiscount")
        private CODFeeDiscount cODFeeDiscount;
        @JsonProperty("IsGift")
        private Boolean isGift;
        @JsonProperty("ConditionNote")
        private String conditionNote;
        @JsonProperty("ConditionId")
        private String conditionId;
        @JsonProperty("ConditionSubtypeId")
        private String conditionSubtypeId;
        @JsonProperty("ScheduledDeliveryStartDate")
        private String scheduledDeliveryStartDate;
        @JsonProperty("ScheduledDeliveryEndDate")
        private String scheduledDeliveryEndDate;
        @JsonProperty("PriceDesignation")
        private String priceDesignation;
        @JsonProperty("TaxCollection")
        private TaxCollection taxCollection;
        @JsonProperty("SerialNumberRequired")
        private Boolean serialNumberRequired;
        @JsonProperty("IsTransparency")
        private Boolean isTransparency;
        @JsonProperty("IossNumber")
        private String iossNumber;
        @JsonProperty("StoreChainStoreId")
        private String storeChainStoreId;
        @JsonProperty("DeemedResellerCategory")
        private String deemedResellerCategory;
        @JsonProperty("BuyerInfo")
        private BuyerInfo buyerInfo;

        @NoArgsConstructor
        @Data
        public static class ProductInfo {
            @JsonProperty("NumberOfItems")
            private Integer numberOfItems;
        }

        @NoArgsConstructor
        @Data
        public static class PointsGranted {
            @JsonProperty("PointsNumber")
            private Integer pointsNumber;
            @JsonProperty("PointsMonetaryValue")
            private PointsGranted.PointsMonetaryValue pointsMonetaryValue;

            @NoArgsConstructor
            @Data
            public static class PointsMonetaryValue {
                @JsonProperty("CurrencyCode")
                private String currencyCode;
                @JsonProperty("Amount")
                private String amount;
            }
        }

        @NoArgsConstructor
        @Data
        public static class ItemPrice {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class ShippingPrice {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class ItemTax {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class ShippingTax {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class ShippingDiscount {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class ShippingDiscountTax {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class PromotionDiscount {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class PromotionDiscountTax {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class CODFee {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class CODFeeDiscount {
            @JsonProperty("CurrencyCode")
            private String currencyCode;
            @JsonProperty("Amount")
            private String amount;
        }

        @NoArgsConstructor
        @Data
        public static class TaxCollection {
            @JsonProperty("Model")
            private String model;
            @JsonProperty("ResponsibleParty")
            private String responsibleParty;
        }

        @NoArgsConstructor
        @Data
        public static class BuyerInfo {
            @JsonProperty("BuyerCustomizedInfo")
            private BuyerInfo.BuyerCustomizedInfo buyerCustomizedInfo;
            @JsonProperty("GiftWrapPrice")
            private BuyerInfo.GiftWrapPrice giftWrapPrice;
            @JsonProperty("GiftWrapTax")
            private BuyerInfo.GiftWrapTax giftWrapTax;
            @JsonProperty("GiftMessageText")
            private String giftMessageText;
            @JsonProperty("GiftWrapLevel")
            private String giftWrapLevel;

            @NoArgsConstructor
            @Data
            public static class BuyerCustomizedInfo {
                @JsonProperty("value")
                private String value;
            }

            @NoArgsConstructor
            @Data
            public static class GiftWrapPrice {
                @JsonProperty("CurrencyCode")
                private String currencyCode;
                @JsonProperty("Amount")
                private String amount;
            }

            @NoArgsConstructor
            @Data
            public static class GiftWrapTax {
                @JsonProperty("CurrencyCode")
                private String currencyCode;
                @JsonProperty("Amount")
                private String amount;
            }
        }
    }

}
