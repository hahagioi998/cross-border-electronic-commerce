package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class GeneralPaymentDetails {
    @JsonProperty("shipping_merchant_payment")
    private ShippingMerchantPayment shippingMerchantPayment;
    @JsonProperty("payment_total")
    private PaymentTotal paymentTotal;
    @JsonProperty("product_price")
    private Amount productPrice;
    @JsonProperty("product_merchant_payment")
    private Amount productMerchantPayment;
    @JsonProperty("product_shipping_price")
    private ProductShippingPrice productShippingPrice;
    @JsonProperty("product_quantity")
    private Integer productQuantity;
    @JsonProperty("customer_paid_prices_detail")
    private CustomerPaidPricesDetail customerPaidPricesDetail;
}
