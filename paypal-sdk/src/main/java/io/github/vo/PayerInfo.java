package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PayerInfo {

    /**
     * PayPal 付款人 ID
     */
    @JsonProperty("account_id")
    private String accountId;

    /**
     * 国际化的电子邮件地址。
     */
    @JsonProperty("email_address")
    private String emailAddress;

    /**
     * 付款人的地址状态。值是：
     * Y. 已验证。
     * N. 未经审核的。
     */
    @JsonProperty("address_status")
    private String addressStatus;

    /**
     * 付款人的状态。值为Y或N。
     */
    @JsonProperty("payer_status")
    private String payerStatus;

    /**
     * 付款人姓名。
     */
    @JsonProperty("payer_name")
    private PayerName payerName;

    /**
     * 标识付款人所在国家或地区的两字符 ISO 3166-1 代码。
     * https://developer.paypal.com/reference/country-codes/
     */
    @JsonProperty("country_code")
    private String countryCode;
}
