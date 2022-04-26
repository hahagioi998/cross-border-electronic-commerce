package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CryptoBalances {

    /**
     * 资产符号
     */
    @JsonProperty("asset_symbol")
    private String assetSymbol;

    /**
     * 数量
     */
    @JsonProperty("quantity")
    private String quantity;
}
