package io.github;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.dto.OrdersDTO;
import io.github.dto.ShipmentDTO;
import io.github.vo.AmazonResponse;
import io.github.vo.AmazonToken;
import io.github.vo.order.AmazonBuyerInfo;
import io.github.vo.order.AmazonOrderItems;
import io.github.vo.order.AmazonShippingAddress;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;

import io.github.vo.order.AmazonOrder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by EalenXie on 2022/2/22 10:13
 * 亚马逊订单api https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference
 */
public class AmazonClient   {

    private final ObjectMapper mapper;


    private final RestOperations restOperations;
    /**
     * Amazon 授权地址 https://sellercentral.amazon.com/apps/authorize/consent
     */
    private static final String AUTHORIZE_URL = "https://sellercentral.amazon.com/apps/authorize/consent";
    /**
     * Amazon 认证接口地址 https://api.amazon.com/auth/o2/token
     */
    private static final String TOKEN_URL = "https://api.amazon.com/auth/o2/token";
    /**
     * Amazon selling partner(SP) Host地址 https://sellingpartnerapi-na.amazon.com
     */
    private static final String SELLING_PARTNER_HOST = "https://sellingpartnerapi-na.amazon.com";


    public AmazonClient() {
        this(new RestTemplate());
    }

    public AmazonClient(RestOperations restOperations) {
        this(new ObjectMapper(), restOperations);
    }

    public AmazonClient(ObjectMapper objectMapper, RestOperations restOperations) {
        this.mapper = objectMapper;
        this.restOperations = restOperations;
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
     * 获取授权地址   文档: https://developer-docs.amazon.com/sp-api/docs/website-authorization-workflow
     *
     * @param applicationId 应用Id
     * @param state         应用程序生成的状态值。
     * @param version       如果您包含该参数version=beta，则工作流会授权处于草稿状态的应用程序。如果您不包含该参数，则工作流程会授权在 Amazon Seller Central Partner Network 上发布的应用程序。
     */
    public String authorize(String applicationId, String state, String version) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s?application_id=%s&state=%s", AUTHORIZE_URL, applicationId, state));
        if (version != null && version.length() > 0) {
            sb.append(String.format("&version=%s", version));
        }
        return sb.toString();
    }


    /**
     * 授权码模式获取accessToken  文档: https://developer-docs.amazon.com/sp-api/docs/website-authorization-workflow
     *
     * @param clientId     客户端Id
     * @param clientSecret 客户端密钥
     * @param code         授权码
     * @param redirectUri  重定向地址
     */
    public ResponseEntity<AmazonToken> accessToken(String clientId, String clientSecret, String code, String redirectUri) {
        HttpHeaders headers = getBasicHeaders(clientId, clientSecret);
        return restOperations.exchange(URI.create(String.format("%s?grant_type=authorization_code&code=%s&redirect_uri=%s", TOKEN_URL, code, redirectUri)), HttpMethod.POST, new HttpEntity<>(null, headers), AmazonToken.class);
    }


    /**
     * 获取订单
     * https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference#get-ordersv0ordersorderid
     *
     * @param orderId 亚马逊订单ID
     */
    public ResponseEntity<AmazonResponse<AmazonOrder>> getOrder(String orderId, String nextToken) {
        return restOperations.exchange(URI.create(String.format("%s/orders/v0/orders/%s?nextToken=%s", SELLING_PARTNER_HOST, orderId, nextToken)), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), new ParameterizedTypeReference<AmazonResponse<AmazonOrder>>() {
        });
    }

    /**
     * 获取订单列表
     * https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference#get-ordersv0orders
     */
    public ResponseEntity<AmazonResponse<AmazonOrder>> getOrders(OrdersDTO dto) {
        @SuppressWarnings("unchecked") Map<String, ?> args = mapper.convertValue(dto, Map.class);
        return restOperations.exchange(String.format("%s/orders/v0/orders", SELLING_PARTNER_HOST), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), new ParameterizedTypeReference<AmazonResponse<AmazonOrder>>() {
        }, args != null ? args : new LinkedHashMap<>());
    }

    /**
     * 获取订单购买信息
     * https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference#get-ordersv0ordersorderidbuyerinfo
     *
     * @param orderId 亚马逊订单ID
     */
    public ResponseEntity<AmazonResponse<AmazonBuyerInfo>> orderBuyerInfo(String orderId, String nextToken) {
        return restOperations.exchange(URI.create(String.format("%s/orders/v0/orders/%s/buyerInfo?nextToken=%s", SELLING_PARTNER_HOST, orderId, nextToken)), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), new ParameterizedTypeReference<AmazonResponse<AmazonBuyerInfo>>() {
        });
    }

    /**
     * 获取订单地址信息
     * https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference#get-ordersv0ordersorderidaddress
     *
     * @param orderId 亚马逊订单ID
     */
    public ResponseEntity<AmazonResponse<AmazonShippingAddress>> orderAddress(String orderId, String nextToken) {
        return restOperations.exchange(URI.create(String.format("%s/orders/v0/orders/%s/address?nextToken=%s", SELLING_PARTNER_HOST, orderId, nextToken)), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), new ParameterizedTypeReference<AmazonResponse<AmazonShippingAddress>>() {
        });
    }

    /**
     * 获取订单Item列表
     * https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference#get-ordersv0ordersorderidorderitems
     */
    public ResponseEntity<AmazonResponse<AmazonOrderItems>> getOrderItems(String orderId, String nextToken) {
        return restOperations.exchange(URI.create(String.format("%s/orders/v0/orders/%s/orderItems?nextToken=%s", SELLING_PARTNER_HOST, orderId, nextToken)), HttpMethod.GET, new HttpEntity<>(null, new HttpHeaders()), new ParameterizedTypeReference<AmazonResponse<AmazonOrderItems>>() {
        });
    }


    /**
     * 更新发货状态
     * https://developer-docs.amazon.com/sp-api/docs/orders-api-v0-reference#post-ordersv0ordersorderidshipment
     */
    public ResponseEntity<Void> shipment(String orderId, String nextToken, ShipmentDTO dto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ShipmentDTO> httpEntity = new HttpEntity<>(dto, headers);
        return restOperations.exchange(URI.create(String.format("%s/orders/v0/orders/%s/shipment?nextToken=%s", SELLING_PARTNER_HOST, orderId, nextToken)), HttpMethod.POST, httpEntity, Void.class);
    }

}
