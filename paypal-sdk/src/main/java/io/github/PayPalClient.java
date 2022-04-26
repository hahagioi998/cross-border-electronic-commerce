package io.github;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.dto.TransactionsDTO;
import io.github.vo.BalancesVO;
import io.github.vo.PayPalAccessToken;
import io.github.vo.TransactionDetailsVO;
import io.github.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.SortedMap;

/**
 * Created by EalenXie on 2022/3/29 11:36
 * https://developer.paypal.com/
 */
@Slf4j
@SuppressWarnings("all")
public class PayPalClient {

    private final RestOperations restOperations;

    private final ObjectMapper mapper = new ObjectMapper();
    /**
     * 是否沙箱环境
     */
    private boolean sandBox = true;
    /**
     * 沙箱环境认证接口地址
     */
    private static final String HOST_SANDBOX = "https://api-m.sandbox.paypal.com/v1";
    /**
     * 正式环境接口地址
     */
    private static final String HOST = "https://api-m.paypal.com";


    public PayPalClient() {
        this(new RestTemplate());
    }

    public PayPalClient(RestOperations restOperations) {
        this.restOperations = restOperations;
    }


    public boolean isSandBox() {
        return sandBox;
    }

    public void setSandBox(boolean sandBox) {
        this.sandBox = sandBox;
    }

    public HttpHeaders getBearerHeader(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        return headers;
    }

    public HttpHeaders getBasicHeader(String clientId, String clientSecret) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(clientId, clientSecret);
        return headers;
    }


    /**
     * 客户端模式获取访问令牌
     * https://developer.paypal.com/api/rest/authentication/
     *
     * @param accessToken 访问令牌
     * @param accountId   账号id
     * @param dto         请求参数
     */
    public ResponseEntity<PayPalAccessToken> clientCredentialsAcessToken(String clientId, String clientSecret) {
        HttpHeaders headers = getBasicHeader(clientId, clientSecret);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Accept-Language", "en_US");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/oauth2/token", sandBox ? HOST_SANDBOX : HOST));
        builder.queryParam("grant_type", "client_credentials");
        URI uri = builder.build().encode().toUri();
        return restOperations.exchange(uri, HttpMethod.POST, new HttpEntity<>(null, headers), PayPalAccessToken.class);
    }

    /**
     * 显示付款项目的详细信息
     * <p>
     * <p>
     * https://developer.paypal.com/docs/api/referenced-payouts/v1/#referenced-payouts_get_batch_details
     *
     * @param payoutsItemId
     * @return
     */
    public ResponseEntity<?> clientReferencedPayoutsItems(String payoutsItemId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.setBearerAuth(token);
        headers.set("PayPal-Partner-Attribution-Id", "bn1234");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/payments/referenced-payouts-items/%s", sandBox ? HOST_SANDBOX : HOST, payoutsItemId));
        URI uri = builder.build().encode().toUri();
        return restOperations.exchange(uri, HttpMethod.GET, new HttpEntity<>(null, headers), Object.class);
    }

    /**
     * 显示付款项目的详细信息
     * <p>
     * <p>
     * https://developer.paypal.com/docs/api/referenced-payouts/v1/#referenced-payouts_get_batch_details
     *
     * @param payoutsItemId
     * @return
     */
    public ResponseEntity<UserInfo> getUserInfo(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/identity/oauth2/userinfo?schema=paypalv1.1", sandBox ? HOST_SANDBOX : HOST));
        return restOperations.exchange(builder.build().toUri(), HttpMethod.GET, new HttpEntity<>(null, headers), UserInfo.class);
    }


    /**
     * 列出交易
     * https://developer.paypal.com/docs/api/transaction-search/v1/#transactions_get
     *
     * @param token 访问令牌
     * @param dto   请求参数封装的对象TransactionsDTO
     * @return
     */
    public ResponseEntity<TransactionDetailsVO> transactions(String token, TransactionsDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        //访问路径
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/reporting/transactions", sandBox ? HOST_SANDBOX : HOST));
        //判断dto不能为空
        if (dto != null) {
            @SuppressWarnings("unchecked") SortedMap<String, String> sortedMap = mapper.convertValue(dto, SortedMap.class);
            LinkedMultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            if (!sortedMap.isEmpty()) {
                queryParams.setAll(sortedMap);
                builder.queryParams(queryParams);
            }
        }
        return restOperations.exchange(builder.build().toUri(), HttpMethod.GET, new HttpEntity<>(null, headers), TransactionDetailsVO.class);
    }

    /**
     * 列出所有余额
     * https://developer.paypal.com/docs/api/transaction-search/v1/#transactions_get
     *
     * @param token                   访问令牌
     * @param currencCode             通过PayPal 交易货币的三字符 ISO-4217 货币代码过滤响应中的交易。
     * @param dasOfTimeto             在提供的日期时间在响应中列出余额，如果未提供，将返回系统中最后刷新的余额
     * @param includeCryptoCurrencies 是否包括加密货币：false   或   true
     * @return
     */
    public ResponseEntity<BalancesVO> balances(String token, String currencCode, String asOfTime, String includeCryptoCurrencies) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        //访问路径
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/reporting/balances", sandBox ? HOST_SANDBOX : HOST));
        //判断入参不能为空
        if (asOfTime != null && currencCode != null) {
            //将请求参数按指定排序生成url参数
            LinkedMultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
            queryParams.put("currency_code", Collections.singletonList(currencCode));
            queryParams.put("as_of_time", Collections.singletonList(asOfTime));
            queryParams.put("include_crypto_currencies", Collections.singletonList(includeCryptoCurrencies));
            builder.queryParams(queryParams);
        }
        return restOperations.exchange(builder.build().toUri(), HttpMethod.GET, new HttpEntity<>(null, headers), BalancesVO.class);
    }


    /**
     * 列出参考批次付款中的项目
     * <p>
     * https://developer.paypal.com/docs/api/referenced-payouts/v1/#referenced-payouts_get_batch_details
     *
     * @param payoutsBatchId
     * @param token
     * @return
     */
    public ResponseEntity<?> clientReferencedPayouts(String payoutsBatchId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/payments/referenced-payouts/%s", sandBox ? HOST_SANDBOX : HOST, payoutsBatchId));
        return restOperations.exchange(builder.encode().build().toUri(), HttpMethod.GET, new HttpEntity<>(null, headers), Object.class);
    }
}
