package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/21 13:10
 */
@NoArgsConstructor
@Data
public class AllegroCheckoutForm {

    @JsonProperty("id")
    private String id;
    /**
     * 买家给卖家的消息
     */
    @JsonProperty("messageToSeller")
    private String messageToSeller;
    /**
     * 买家信息
     */
    @JsonProperty("buyer")
    private Buyer buyer;
    /**
     * 支付信息
     */
    @JsonProperty("payment")
    private Payment payment;
    /**
     * 根据付款和购买状态描述表单交付和购买选项的状态。
     * BOUGHT -购买没有填写结帐表格*
     * FILLED_IN -结帐表格填写但付款尚未完成，因此数据仍然可以更改
     * READY_FOR_PROCESSING -付款已完成。
     * CANCELLED-购买由买家取消。
     */
    @JsonProperty("status")
    private String status;
    /**
     * 商家信息
     */
    @JsonProperty("fulfillment")
    private Fulfillment fulfillment;
    /**
     * 送货信息  物流信息
     */
    @JsonProperty("delivery")
    private Delivery delivery;
    /**
     * 发票信息
     */
    @JsonProperty("invoice")
    private Invoice invoice;
    /**
     * 订单项
     */
    @JsonProperty("lineItems")
    private List<LineItems> lineItems;
    /**
     * 附加费用
     */
    @JsonProperty("surcharges")
    private List<Surcharges> surcharges;
    /**
     * 折扣信息
     */
    @JsonProperty("discounts")
    private List<Discounts> discounts;
    /**
     * 概况信息
     */
    @JsonProperty("summary")
    private Summary summary;
    /**
     * 更新时间
     */
    @JsonProperty("updatedAt")
    private String updatedAt;
    /**
     * 修订
     */
    @JsonProperty("revision")
    private String revision;

    @NoArgsConstructor
    @Data
    public static class Buyer {
        @JsonProperty("id")
        private String id;
        /**
         * 邮箱
         */
        @JsonProperty("email")
        private String email;
        @JsonProperty("login")
        private String login;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("companyName")
        private String companyName;
        /**
         * 是否游客账户
         */
        @JsonProperty("guest")
        private Boolean guest;
        /**
         * 买方的个人身份号码(PESEL)
         */
        @JsonProperty("personalIdentity")
        private String personalIdentity;
        /**
         * 用户手机号
         */
        @JsonProperty("phoneNumber")
        private String phoneNumber;
        @JsonProperty("address")
        private Address address;

        @NoArgsConstructor
        @Data
        public static class Address {
            /**
             * 街道名称
             */
            @JsonProperty("street")
            private String street;
            /**
             * 城市名
             */
            @JsonProperty("city")
            private String city;
            /**
             * 邮政编码
             */
            @JsonProperty("postCode")
            private String postCode;
            /**
             * 国家代码
             */
            @JsonProperty("countryCode")
            private String countryCode;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Payment {
        @JsonProperty("id")
        private String id;
        /**
         * 支付类型
         * "CASH_ON_DELIVERY"  货到付现
         * "WIRE_TRANSFER"  电子转帐
         * "ONLINE" 线上支付
         * "SPLIT_PAYMENT" 分批付款
         * "EXTENDED_TERM" 延期付款
         */
        @JsonProperty("type")
        private String type;
        /**
         * 枚举： “P24” “PAYU” “OFFLINE” “EPT”
         * 支付提供商
         */
        @JsonProperty("provider")
        private String provider;
        /**
         * 支付完成时间
         */
        @JsonProperty("finishedAt")
        private String finishedAt;
        /**
         * 支付金额
         */
        @JsonProperty("paidAmount")
        private PaidAmount paidAmount;
        /**
         * 订单金额
         */
        @JsonProperty("reconciliation")
        private Reconciliation reconciliation;

        @NoArgsConstructor
        @Data
        public static class PaidAmount {
            /**
             * 金额
             */
            @JsonProperty("amount")
            private String amount;
            /**
             * 货币类型
             */
            @JsonProperty("currency")
            private String currency;
        }

        @NoArgsConstructor
        @Data
        public static class Reconciliation {
            /**
             * 金额
             */
            @JsonProperty("amount")
            private String amount;
            /**
             * 货币类型
             */
            @JsonProperty("currency")
            private String currency;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Fulfillment {
        /**
         * "NEW" 确认
         * "PROCESSING" 处理中
         * "READY_FOR_SHIPMENT" 准备装运
         * "READY_FOR_PICKUP" 准备收货
         * "SENT" 寄送中
         * "PICKED_UP" 已收货
         * "CANCELLED" 商家取消
         * 卖家状态.
         *
         * ready for pickup
         */
        @JsonProperty("status")
        private String status;
        @JsonProperty("shipmentSummary")
        private ShipmentSummary shipmentSummary;

        @NoArgsConstructor
        @Data
        public static class ShipmentSummary {
            /**
             * 指示指定跟踪号的行项的数量 "NONE" "SOME" "ALL"
             */
            @JsonProperty("lineItemsSent")
            private String lineItemsSent;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Delivery {
        /**
         * 物流地址
         */
        @JsonProperty("address")
        private Address address;
        @JsonProperty("method")
        private Method method;
        @JsonProperty("pickupPoint")
        private PickupPoint pickupPoint;
        @JsonProperty("cost")
        private Cost cost;
        @JsonProperty("time")
        private Time time;
        @JsonProperty("smart")
        private Boolean smart;
        @JsonProperty("calculatedNumberOfPackages")
        private Integer calculatedNumberOfPackages;

        @NoArgsConstructor
        @Data
        public static class Address {
            @JsonProperty("firstName")
            private String firstName;
            @JsonProperty("lastName")
            private String lastName;
            @JsonProperty("street")
            private String street;
            @JsonProperty("city")
            private String city;
            @JsonProperty("zipCode")
            private String zipCode;
            /**
             * 国家代码
             */
            @JsonProperty("countryCode")
            private String countryCode;
            /**
             * 公司名称
             */
            @JsonProperty("companyName")
            private String companyName;
            /**
             * 电话信息
             */
            @JsonProperty("phoneNumber")
            private String phoneNumber;
            /**
             * 地址修改时间
             */
            @JsonProperty("modifiedAt")
            private String modifiedAt;
        }

        @NoArgsConstructor
        @Data
        public static class Method {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
        }

        @NoArgsConstructor
        @Data
        public static class PickupPoint {
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
            @JsonProperty("description")
            private String description;
            @JsonProperty("address")
            private Address address;

            @NoArgsConstructor
            @Data
            public static class Address {
                @JsonProperty("street")
                private String street;
                @JsonProperty("zipCode")
                private String zipCode;
                @JsonProperty("city")
                private String city;
            }
        }

        @NoArgsConstructor
        @Data
        public static class Cost {
            @JsonProperty("amount")
            private String amount;
            @JsonProperty("currency")
            private String currency;
        }

        @NoArgsConstructor
        @Data
        public static class Time {
            @JsonProperty("guaranteed")
            private Guaranteed guaranteed;

            @NoArgsConstructor
            @Data
            public static class Guaranteed {
                @JsonProperty("from")
                private String from;
                @JsonProperty("to")
                private String to;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class Invoice {
        /**
         * 买方是否需要发票
         */
        @JsonProperty("required")
        private Boolean required;
        /**
         * 地址
         */
        @JsonProperty("address")
        private Address address;
        /**
         * 截止日期
         */
        @JsonProperty("dueDate")
        private String dueDate;

        @NoArgsConstructor
        @Data
        public static class Address {
            @JsonProperty("street")
            private String street;
            @JsonProperty("city")
            private String city;
            @JsonProperty("zipCode")
            private String zipCode;
            @JsonProperty("countryCode")
            private String countryCode;
            @JsonProperty("company")
            private Company company;
            @JsonProperty("naturalPerson")
            private NaturalPerson naturalPerson;

            @NoArgsConstructor
            @Data
            public static class Company {
                @JsonProperty("name")
                private String name;
                @JsonProperty("taxId")
                private Object taxId;
            }

            @NoArgsConstructor
            @Data
            public static class NaturalPerson {
                @JsonProperty("firstName")
                private String firstName;
                @JsonProperty("lastName")
                private String lastName;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class Summary {
        /**
         * 总金额
         */
        @JsonProperty("totalToPay")
        private TotalToPay totalToPay;

        @NoArgsConstructor
        @Data
        public static class TotalToPay {
            /**
             * 金额
             */
            @JsonProperty("amount")
            private String amount;
            /**
             * 货币类型
             */
            @JsonProperty("currency")
            private String currency;
        }
    }

    @NoArgsConstructor
    @Data
    public static class LineItems {
        @JsonProperty("id")
        private String id;
        /**
         * 优惠信息
         */
        @JsonProperty("offer")
        private Offer offer;
        @JsonProperty("quantity")
        private Integer quantity;
        @JsonProperty("originalPrice")
        private OriginalPrice originalPrice;
        @JsonProperty("price")
        private Price price;
        @JsonProperty("reconciliation")
        private Reconciliation reconciliation;
        @JsonProperty("selectedAdditionalServices")
        private List<SelectedAdditionalServices> selectedAdditionalServices;
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

        @NoArgsConstructor
        @Data
        public static class Reconciliation {
            @JsonProperty("value")
            private Value value;
            @JsonProperty("type")
            private String type;
            @JsonProperty("quantity")
            private Integer quantity;

            @NoArgsConstructor
            @Data
            public static class Value {
                @JsonProperty("amount")
                private String amount;
                @JsonProperty("currency")
                private String currency;
            }
        }

        @NoArgsConstructor
        @Data
        public static class SelectedAdditionalServices {
            @JsonProperty("definitionId")
            private String definitionId;
            @JsonProperty("name")
            private String name;
            @JsonProperty("price")
            private Price price;
            @JsonProperty("quantity")
            private Integer quantity;

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

    @NoArgsConstructor
    @Data
    public static class Surcharges {
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("provider")
        private String provider;
        @JsonProperty("finishedAt")
        private String finishedAt;
        @JsonProperty("paidAmount")
        private PaidAmount paidAmount;
        @JsonProperty("reconciliation")
        private Reconciliation reconciliation;

        @NoArgsConstructor
        @Data
        public static class PaidAmount {
            @JsonProperty("amount")
            private String amount;
            @JsonProperty("currency")
            private String currency;
        }

        @NoArgsConstructor
        @Data
        public static class Reconciliation {
            @JsonProperty("amount")
            private String amount;
            @JsonProperty("currency")
            private String currency;
        }
    }

    @NoArgsConstructor
    @Data
    public static class Discounts {
        @JsonProperty("type")
        private String type;
    }
}
