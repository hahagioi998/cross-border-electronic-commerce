package io.github.marketplace;

import io.github.marketplace.vo.WalmartToken;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.UUID;

/**
 * Created by EalenXie on 2022/3/16 14:02
 */
public abstract class WalmartClient {

    private final RestOperations restOperations;
    /**
     * Walmart Marketplace API Host地址 https://marketplace.walmartapis.com
     */
    public static final String HOST = "https://marketplace.walmartapis.com";
    /**
     * Walmart Marketplace API 沙箱环境地址
     */
    public static final String SANDBOX_HOST = "https://sandbox.walmartapis.com/v3/orders/released";
    /**
     * 沙箱模式
     */
    private boolean sandBoxMode = false;

    @SuppressWarnings("all")
    public static final String WM_SVC_NAME = "WM_SVC.NAME";
    @SuppressWarnings("all")
    public static final String WM_QOS_CORRELATION_ID = "WM_QOS.CORRELATION_ID";
    @SuppressWarnings("all")
    public static final String WM_SEC_ACCESS_TOKEN = "WM_SEC.ACCESS_TOKEN";

    private final String clientId;

    private final String clientSecret;

    protected WalmartClient(String clientId, String clientSecret) {
        this(clientId, clientSecret, new RestTemplate());
    }

    protected WalmartClient(String clientId, String clientSecret, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public RestOperations getRestOperations() {
        return restOperations;
    }

    public boolean isSandBoxMode() {
        return sandBoxMode;
    }

    public void setSandBoxMode(boolean sandBoxMode) {
        this.sandBoxMode = sandBoxMode;
    }

    /**
     * 获取accessToken
     * https://developer.walmart.com/api/us/mp/auth#operation/tokenAPI
     *
     * @return 访问令牌
     */
    public ResponseEntity<WalmartToken> accessToken() {
        HttpHeaders headers = getCommonHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return getRestOperations().exchange(URI.create(String.format("%s/v3/token?grant_type=client_credentials", isSandBoxMode() ? SANDBOX_HOST : HOST)), HttpMethod.POST, new HttpEntity<>(null, headers), WalmartToken.class);
    }

    /**
     * 获取公共的请求头
     */
    public HttpHeaders getCommonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(getClientId(), getClientSecret());
        headers.set(WM_SVC_NAME, "Walmart Marketplace");
        headers.set(WM_QOS_CORRELATION_ID, UUID.randomUUID().toString());
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

}
