package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TotalBalance {

    /**
     * 标识货币的三字符 ISO-4217 货币代码。
     * https://developer.paypal.com/api/rest/reference/currency-codes/
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * 值，可能是：
     * 像这样的货币的整数JPY通常不是小数。
     * 像这样的货币的小数部分TND被细分为千分之一。
     * 有关货币代码所需的小数位数，请参阅货币代码。
     * https://developer.paypal.com/reference/currency-codes/
     */
    @JsonProperty("value")
    private String value;
}
