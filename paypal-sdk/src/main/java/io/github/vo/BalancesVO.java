package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BalancesVO {

    /**
     * 加密余额
     */
    @JsonProperty("crypto_balances")
    private List<CryptoBalances> cryptoBalances;

    /**
     * 余额
     */
    @JsonProperty("balances")
    private List<Balances> balances;

    /**
     * 账户 ID
     */
    @JsonProperty("account_id")
    private String accountId;

    /**
     * 截止时间
     */
    @JsonProperty("as_of_time")
    private String asOfTime;

    /**
     * 上次刷新时间
     */
    @JsonProperty("last_refresh_time")
    private String lastRefreshTime;
}
