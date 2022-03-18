package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/18 13:11
 */
@NoArgsConstructor
@Data
public class OrderEvent {

    @JsonProperty("events")
    private List<Events> events;

    @NoArgsConstructor
    @Data
    public static class Events {
        @JsonProperty("id")
        private String id;
        @JsonProperty("order")
        private Order order;
        @JsonProperty("type")
        private String type;
        @JsonProperty("occurredAt")
        private String occurredAt;

        @NoArgsConstructor
        @Data
        public static class Order {
            @JsonProperty("seller")
            private Seller seller;
            @JsonProperty("buyer")
            private Buyer buyer;
            @JsonProperty("lineItems")
            private List<LineItems> lineItems;
            @JsonProperty("checkoutForm")
            private CheckoutForm checkoutForm;

            @NoArgsConstructor
            @Data
            public static class Seller {
                @JsonProperty("id")
                private String id;
            }

            @NoArgsConstructor
            @Data
            public static class Buyer {
                @JsonProperty("id")
                private String id;
                @JsonProperty("email")
                private String email;
                @JsonProperty("login")
                private String login;
                @JsonProperty("guest")
                private Boolean guest;
            }

            @NoArgsConstructor
            @Data
            public static class CheckoutForm {
                @JsonProperty("id")
                private String id;
                @JsonProperty("revision")
                private String revision;
            }

            @NoArgsConstructor
            @Data
            public static class LineItems {
                @JsonProperty("id")
                private String id;
                @JsonProperty("offer")
                private Offer offer;
                @JsonProperty("quantity")
                private Integer quantity;
                @JsonProperty("originalPrice")
                private OriginalPrice originalPrice;
                @JsonProperty("price")
                private Price price;
                @JsonProperty("boughtAt")
                private String boughtAt;

                @NoArgsConstructor
                @Data
                public static class Offer {
                    @JsonProperty("id")
                    private String id;
                    @JsonProperty("name")
                    private String name;
                    @JsonProperty("external")
                    private External external;

                    @NoArgsConstructor
                    @Data
                    public static class External {
                        @JsonProperty("id")
                        private String id;
                    }
                }

                @NoArgsConstructor
                @Data
                public static class OriginalPrice {
                    @JsonProperty("amount")
                    private String amount;
                    @JsonProperty("currency")
                    private String currency;
                }

                @NoArgsConstructor
                @Data
                public static class Price {
                    @JsonProperty("amount")
                    private String amount;
                    @JsonProperty("currency")
                    private String currency;
                }
            }
        }
    }
}
