package io.github;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dto.OrdersDTO;
import io.github.dto.ShipmentDTO;
import io.github.vo.AllegroCheckoutForm;
import io.github.vo.AllegroCheckoutForms;
import io.github.vo.AllegroToken;
import io.github.vo.ShipmentVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by EalenXie on 2022/2/21 12:59
 * 接口文档地址 : https://developer.allegro.pl/documentation
 */
public class AllegroClient {

    private final ObjectMapper mapper;

    private final RestOperations restOperations;
    /**
     * Allegro 资源服务器的域名 https://api.allegro.pl
     */
    private static final String API_HOST = "https://api.allegro.pl";
    /**
     * Allegro 认证服务器的域名 https://api.allegro.pl
     */
    private static final String AUTH_HOST = "https://allegro.pl";

    public AllegroClient() {
        this(new ObjectMapper(), new RestTemplate());
    }

    public AllegroClient(ObjectMapper objectMapper, RestOperations restOperations) {
        this.mapper = objectMapper;
        this.restOperations = restOperations;
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
        return String.format("%s/auth/oauth/authorize?response_type=code&client_id=%s&redirect_uri=%s", AUTH_HOST, clientId, redirectUri);
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
        return restOperations.exchange(URI.create(String.format("%s/auth/oauth/token?grant_type=authorization_code&code=%s&redirect_uri=%s", AUTH_HOST, code, redirectUri)), HttpMethod.POST, new HttpEntity<>(null, headers), AllegroToken.class);
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
        return restOperations.exchange(URI.create(String.format("%s/auth/oauth/token?grant_type=refresh_token&refresh_token=%s&redirect_uri=%s", AUTH_HOST, refreshToken, redirectUri)), HttpMethod.POST, new HttpEntity<>(null, headers), AllegroToken.class);
    }

    /**
     * 获取用户订单
     * 接口文档  https://developer.allegro.pl/documentation/#operation/getListOfOrdersUsingGET
     *
     * @param dto         用户订单查询参数
     * @param accessToken 令牌
     * @return {@link AllegroCheckoutForms} 订单详情
     */
    public ResponseEntity<AllegroCheckoutForms> getListOfOrders(OrdersDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        @SuppressWarnings("unchecked") Map<String, ?> args = mapper.convertValue(dto, Map.class);
        return restOperations.exchange(String.format("%s/order/checkout-forms", API_HOST), HttpMethod.GET, new HttpEntity<>(null, headers), AllegroCheckoutForms.class, args != null ? args : new LinkedHashMap<>());
    }


    /**
     * 获取订单详情
     * 接口文档  https://developer.allegro.pl/documentation/#operation/getOrdersDetailsUsingGET
     *
     * @param orderId     订单Id
     * @param accessToken 令牌
     * @return {@link AllegroCheckoutForm} 订单详情
     */
    public ResponseEntity<AllegroCheckoutForm> getOrdersDetails(String orderId, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        return restOperations.exchange(URI.create(String.format("%s/order/checkout-forms/%s", API_HOST, orderId)), HttpMethod.GET, new HttpEntity<>(null, headers), AllegroCheckoutForm.class);
    }


    /**
     * 订单标记发货
     *
     * @param orderId     订单Id
     * @param dto         标记发货请求参数
     * @param accessToken 请求token
     * @return {@link ShipmentVO} 标记发货
     */
    public ResponseEntity<ShipmentVO> shipments(String orderId, ShipmentDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        HttpEntity<ShipmentDTO> mapHttpEntity = new HttpEntity<>(dto, headers);
        return restOperations.exchange(String.format("%s/order/checkout-forms/%s/shipments", API_HOST, orderId), HttpMethod.POST, mapHttpEntity, ShipmentVO.class);
    }


}
