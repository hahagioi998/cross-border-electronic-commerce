package io.github;

import io.github.vo.WishToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


/**
 * Created by EalenXie on 2022/2/23 9:51
 */
public abstract class WishClient {


    private final RestOperations restOperations;
    /**
     * Wish Host 地址 https://merchant.wish.co
     */
    public static final String HOST = "https://merchant.wish.com";

    protected WishClient() {
        this(new RestTemplate());
    }

    protected WishClient(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    public RestOperations getRestOperations() {
        return restOperations;
    }

    /**
     * 获取授权地址   文档: https://china-merchant.wish.com/documentation/api/v3/reference#section/Authentication
     *
     * @param state 应用程序生成的状态值。
     */
    public String authorize(String clientId, String state) {
        return String.format("%s/v3/oauth/authorize?client_id=%s&state=%s", HOST, clientId, state);
    }

    /**
     * 获取包含认证的 Bearer 标准请求头
     *
     * @param accessToken 令牌
     */
    public HttpHeaders getBearerHeaders(String accessToken) {
        HttpHeaders bearTokenHeader = new HttpHeaders();
        bearTokenHeader.setBearerAuth(accessToken);
        return bearTokenHeader;
    }

    /**
     * 获取包含认证的 Basic 标准请求头
     *
     * @param clientId     客户端Id
     * @param clientSecret 客户端密钥
     */
    public HttpHeaders getBasicHeaders(String clientId, String clientSecret) {
        HttpHeaders basicHeader = new HttpHeaders();
        basicHeader.setBasicAuth(clientId, clientSecret);
        return basicHeader;
    }

    /**
     * 授权码模式获取accessToken  文档: https://china-merchant.wish.com/documentation/api/v3/reference#operation/oauthAccessToken
     *
     * @param clientId     客户端Id
     * @param clientSecret 客户端密钥
     * @param code         授权码
     * @param redirectUri  重定向地址
     */
    public ResponseEntity<WishToken> accessToken(String clientId, String clientSecret, String code, String redirectUri) {
        HttpHeaders headers = getBasicHeaders(clientId, clientSecret);
        return restOperations.exchange(URI.create(String.format("%s/api/v3/oauth/access_token?grant_type=authorization_code&code=%s&redirect_uri=%s", HOST, code, redirectUri)), HttpMethod.POST, new HttpEntity<>(null, headers), WishToken.class);
    }


}
