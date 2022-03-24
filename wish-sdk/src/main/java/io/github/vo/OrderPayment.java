package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class OrderPayment {
    @JsonProperty("carrier_subsidies")
    private List<CarrierSubsidies> carrierSubsidies;
    @JsonProperty("shipping_reimbursements")
    private List<ShippingReimbursements> shippingReimbursements;
    @JsonProperty("rev_share")
    private RevShare revShare;
    @JsonProperty("general_payment_details")
    private GeneralPaymentDetails generalPaymentDetails;
}
