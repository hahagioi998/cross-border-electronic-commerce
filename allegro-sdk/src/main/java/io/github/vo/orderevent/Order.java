package io.github.vo.orderevent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/24 15:08
 */
@NoArgsConstructor
@Data
public class Order {
    @JsonProperty("seller")
    private Seller seller;
    @JsonProperty("buyer")
    private Buyer buyer;
    @JsonProperty("lineItems")
    private List<LineItems> lineItems;
    @JsonProperty("checkoutForm")
    private CheckoutForm checkoutForm;
}
