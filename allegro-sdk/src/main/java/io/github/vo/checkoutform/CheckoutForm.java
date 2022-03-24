package io.github.vo.checkoutform;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/24 14:39
 */
@NoArgsConstructor
@Data
public class CheckoutForm {

    @JsonProperty("id")
    private String id;
    @JsonProperty("messageToSeller")
    private String messageToSeller;
    @JsonProperty("buyer")
    private Buyer buyer;
    @JsonProperty("payment")
    private Payment payment;
    @JsonProperty("status")
    private String status;
    @JsonProperty("fulfillment")
    private Fulfillment fulfillment;
    @JsonProperty("delivery")
    private Delivery delivery;
    @JsonProperty("invoice")
    private Invoice invoice;
    @JsonProperty("lineItems")
    private List<LineItems> lineItems;
    @JsonProperty("surcharges")
    private List<Surcharges> surcharges;
    @JsonProperty("discounts")
    private List<Payment> discounts;
    @JsonProperty("summary")
    private Summary summary;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("revision")
    private String revision;
}
