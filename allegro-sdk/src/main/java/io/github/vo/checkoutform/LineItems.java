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
public class LineItems {
    @JsonProperty("id")
    private String id;
    @JsonProperty("offer")
    private Offer offer;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("originalPrice")
    private PaidAmount originalPrice;
    @JsonProperty("price")
    private PaidAmount price;
    @JsonProperty("reconciliation")
    private Reconciliation reconciliation;
    @JsonProperty("selectedAdditionalServices")
    private List<SelectedAdditionalServices> selectedAdditionalServices;
    @JsonProperty("boughtAt")
    private String boughtAt;
}
