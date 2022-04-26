package io.github.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalancesDTO {

    /**
     * PayPal 交易 ID
     * 有效的交易 ID 长度为 17 个字符，除了订单编号，长度为 19 个字符。
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * PayPal 交易类型
     * 请参阅事务事件代码
     * https://developer.paypal.com/docs/transaction-search/transaction-event-codes/
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("transaction_type")
    private String transactionType;
}
