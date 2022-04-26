package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ShippingInfo {

    /**
     * 收件人的姓名。
     */
    @JsonProperty("name")
    private String name;


    /**
     * 与此订单关联的送货地址。
     */
    @JsonProperty("address")
    private ShopInfoAddress address;
}
