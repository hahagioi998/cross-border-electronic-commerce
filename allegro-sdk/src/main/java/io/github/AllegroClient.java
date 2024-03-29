package io.github;

import io.github.vo.AllegroToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import java.net.URI;

/**
 * Created by EalenXie on 2022/3/18 12:57
 * https://developer.allegro.pl/documentation/#section/Authentication
 *
 */
public abstract class AllegroClient {


    private final RestOperations restOperations;
    /**
     * Allegro 认证服务器的域名 https://api.allegro.pl
     */
    public static final String AUTH_HOST = "https://allegro.pl";
    /**
     * Allegro 认证服务器的域名(沙箱环境) https://allegro.pl.allegrosandbox.pl
     * https://developer.allegro.pl/about/#%c5%9brodowisko-testowe
     */
    public static final String AUTH_SANDBOX_HOST = "https://allegro.pl.allegrosandbox.pl";
    /**
     * Allegro 资源服务器的域名 https://api.allegro.pl
     */
    public static final String API_HOST = "https://api.allegro.pl";
    /**
     * Allegro 资源服务器的域名(沙箱环境) https://api.allegro.pl.allegrosandbox.pl
     */
    public static final String API_SANDBOX_HOST = "https://api.allegro.pl.allegrosandbox.pl";

    /**
     * 是否沙箱环境
     */
    private boolean sandBox = false;

    public boolean isSandBox() {
        return sandBox;
    }

    public void setSandBox(boolean sandBox) {
        this.sandBox = sandBox;
    }

    protected AllegroClient(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    public RestOperations getRestOperations() {
        return restOperations;
    }

    /**
     * 获取包含认证的Allegro Bearer 标准请求头
     *
     * @param accessToken 令牌
     */
    public HttpHeaders getBearerHeaders(String accessToken) {
        HttpHeaders bearTokenHeader = new HttpHeaders();
        bearTokenHeader.setBearerAuth(accessToken);
        bearTokenHeader.set("Content-Type", "application/vnd.allegro.public.v1+json");
        bearTokenHeader.set("Accept", "application/vnd.allegro.public.v1+json");
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
     * 获取授权地址   文档: https://developer.allegro.pl/auth/#autoryzacja-u%c5%bcytkownika
     *
     * @param clientId    客户端Id
     * @param redirectUri 重定向URL
     * @return 获取授权地址, 用户在此生成的地址上进行授权, 获取到code
     */
    public String authorize(String clientId, String redirectUri) {
        return String.format("%s/auth/oauth/authorize?response_type=code&client_id=%s&redirect_uri=%s", isSandBox() ? AUTH_SANDBOX_HOST : AUTH_HOST, clientId, redirectUri);
    }

    /**
     * 授权码模式获取accessToken  文档: https://developer.allegro.pl/auth/#autoryzacja-u%c5%bcytkownika
     *
     * @param clientId     客户端Id
     * @param clientSecret 客户端密钥
     * @param code         授权码
     * @param redirectUri  重定向地址
     */
    public ResponseEntity<AllegroToken> accessToken(String clientId, String clientSecret, String code, String redirectUri) {
        HttpHeaders headers = getBasicHeaders(clientId, clientSecret);
        return restOperations.exchange(URI.create(String.format("%s/auth/oauth/token?grant_type=authorization_code&code=%s&redirect_uri=%s", isSandBox() ? AUTH_SANDBOX_HOST : AUTH_HOST, code, redirectUri)), HttpMethod.POST, new HttpEntity<>(null, headers), AllegroToken.class);
    }

    /**
     * 刷新令牌   文档:https://developer.allegro.pl/auth/#przed%c5%82u%c5%bcenie-wa%c5%bcno%c5%9bci-tokena
     *
     * @param clientId     客户端Id
     * @param clientSecret 客户端密钥
     * @param refreshToken 刷新令牌
     * @param redirectUri  重定向地址
     */
    public ResponseEntity<AllegroToken> refreshToken(String clientId, String clientSecret, String refreshToken, String redirectUri) {
        HttpHeaders headers = getBasicHeaders(clientId, clientSecret);
        return restOperations.exchange(URI.create(String.format("%s/auth/oauth/token?grant_type=refresh_token&refresh_token=%s&redirect_uri=%s", isSandBox() ? AUTH_SANDBOX_HOST : AUTH_HOST, refreshToken, redirectUri)), HttpMethod.POST, new HttpEntity<>(null, headers), AllegroToken.class);
    }


}
