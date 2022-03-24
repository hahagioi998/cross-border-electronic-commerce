package io.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dto.*;
import io.github.vo.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EalenXie on 2022/2/23 9:51
 * https://china-merchant.wish.com/documentation/api/v3/reference#tag/Orders
 */
public class WishOrderClient extends WishClient {

    private final ObjectMapper mapper;

    public WishOrderClient() {
        this(new RestTemplate());
    }

    public WishOrderClient(RestOperations restOperations) {
        this(new ObjectMapper(), restOperations);
    }

    public WishOrderClient(ObjectMapper objectMapper, RestOperations restOperations) {
        super(restOperations);
        this.mapper = objectMapper;
    }

    /**
     * 获取订单详情
     * 接口文档  https://china-merchant.wish.com/documentation/api/v3/reference#operation/GetOrder
     *
     * @param orderId     订单Id
     * @param accessToken 令牌
     * @return {@link WishOrder} 订单详情
     */
    public ResponseEntity<WishOrder> getOrder(String orderId, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        return getRestOperations().exchange(URI.create(String.format("%s/api/v3/orders/%s", isSandbox() ? SANDBOX_HOST : HOST, orderId)), HttpMethod.GET, new HttpEntity<>(null, headers), WishOrder.class);
    }

    /**
     * 获取订单列表
     * 接口文档  https://china-merchant.wish.com/documentation/api/v3/reference#operation/GetMultipleOrders
     *
     * @param dto         订单请求参数
     * @param accessToken 令牌
     * @return {@link WishOrder} 订单详情
     */
    public ResponseEntity<List<WishOrder>> getOrders(OrdersDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        @SuppressWarnings("unchecked") Map<String, ?> args = mapper.convertValue(dto, Map.class);
        return getRestOperations().exchange(String.format("%s/api/v3/orders", isSandbox() ? SANDBOX_HOST : HOST), HttpMethod.GET, new HttpEntity<>(null, headers), new ParameterizedTypeReference<List<WishOrder>>() {
        }, args != null ? args : new LinkedHashMap<>());
    }


    /**
     * 获取货运公司
     * 接口文档  https://china-merchant.wish.com/documentation/api/v3/reference#operation/GetShippingCarriers
     *
     * @param dto         请求参数
     * @param accessToken 令牌
     * @return {@link NameVO} 物流公司
     */
    public ResponseEntity<List<NameVO>> shippingCarriers(ShippingCarriersDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        @SuppressWarnings("unchecked") Map<String, ?> args = mapper.convertValue(dto, Map.class);
        return getRestOperations().exchange(String.format("%s/api/v3/shipping_carriers", isSandbox() ? SANDBOX_HOST : HOST), HttpMethod.GET, new HttpEntity<>(null, headers), new ParameterizedTypeReference<List<NameVO>>() {
        }, args != null ? args : new LinkedHashMap<>());
    }


    /**
     * 批量获取订单下载
     * 接口文档  https://china-merchant.wish.com/documentation/api/v3/reference#operation/downloadOrders
     *
     * @param dto         请求参数
     * @param accessToken 令牌
     * @return {@link WishDownloadJob} 订单下载信息
     */
    public ResponseEntity<WishDownloadJob> batchDownloadOrders(OrdersDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        @SuppressWarnings("unchecked") Map<String, ?> args = mapper.convertValue(dto, Map.class);
        return getRestOperations().exchange(String.format("%s/api/v3/bulk_get", isSandbox() ? SANDBOX_HOST : HOST), HttpMethod.POST, new HttpEntity<>(null, headers), WishDownloadJob.class, args != null ? args : new LinkedHashMap<>());
    }


    /**
     * 获取订单下载
     * 接口文档 https://china-merchant.wish.com/documentation/api/v3/reference#operation/getOrderDownloadJob
     *
     * @param accessToken 令牌
     * @return {@link WishDownloadJob} 订单下载信息
     */
    public ResponseEntity<WishDownloadJob> batchDownloadJobStatus(String jobId, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        return getRestOperations().exchange(String.format("%s/api/v3/bulk_get/%s", isSandbox() ? SANDBOX_HOST : HOST, jobId), HttpMethod.GET, new HttpEntity<>(null, headers), WishDownloadJob.class);
    }

    /**
     * 发货或更新跟踪订单。 此操作为异步操作。
     * 接口文档  https://china-merchant.wish.com/documentation/api/v3/reference#operation/ShipOrder
     *
     * @param orderId     订单id
     * @param dto         请求参数
     * @param accessToken 令牌
     * @return {@link WishOrder} 发货返回信息
     */
    public ResponseEntity<WishOrder> shipOrUpdateTracking(String orderId, TrackingDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TrackingDTO> httpEntity = new HttpEntity<>(dto, headers);
        return getRestOperations().exchange(String.format("%s/api/v3/orders/%s/tracking", isSandbox() ? SANDBOX_HOST : HOST, orderId), HttpMethod.PUT, httpEntity, WishOrder.class);
    }

    /**
     * 获取退货原因
     * 接口文档 https://china-merchant.wish.com/documentation/api/v3/reference#operation/GetValidRefundReasons
     *
     * @param orderId     订单id
     * @param accessToken 令牌
     */
    public ResponseEntity<List<String>> refundReasons(String orderId, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        return getRestOperations().exchange(String.format("%s/api/v3/orders/%s/refund_reasons", isSandbox() ? SANDBOX_HOST : HOST, orderId), HttpMethod.GET, new HttpEntity<>(null, headers), new ParameterizedTypeReference<List<String>>() {
        });
    }

    /**
     * 取消订单
     * 接口文档  https://china-merchant.wish.com/documentation/api/v3/reference#operation/RefundOrder
     *
     * @param orderId     订单id
     * @param dto         请求参数
     * @param accessToken 令牌
     * @return {@link WishOrder} 取消订单返回结果
     */
    public ResponseEntity<WishOrder> refund(String orderId, RefundDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return getRestOperations().exchange(String.format("%s/api/v3/orders/%s/refund", isSandbox() ? SANDBOX_HOST : HOST, orderId), HttpMethod.PUT, new HttpEntity<>(dto, headers), WishOrder.class);
    }


    /**
     * 更新订单
     * 接口文档 https://china-merchant.wish.com/documentation/api/v3/reference#operation/UpdateOrder
     *
     * @param orderId     订单Id
     * @param accessToken 令牌
     * @return {@link WishOrder} 订单返回信息
     */
    public ResponseEntity<WishOrder> updateLTLOrder(String orderId, UpdateLtlDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        return getRestOperations().exchange(URI.create(String.format("%s/api/v3/orders/%s", isSandbox() ? SANDBOX_HOST : HOST, orderId)), HttpMethod.PUT, new HttpEntity<>(dto, headers), WishOrder.class);
    }

    /**
     * 修改物流地址
     * 接口文档 https://china-merchant.wish.com/documentation/api/v3/reference#operation/ModifyAddress
     *
     * @param orderId     订单Id
     * @param accessToken 令牌
     * @return {@link WishOrder} 订单返回信息
     */
    public ResponseEntity<WishOrder> modifyAddress(String orderId, ModifyAddressDTO dto, String accessToken) {
        HttpHeaders headers = getBearerHeaders(accessToken);
        return getRestOperations().exchange(URI.create(String.format("%s/api/v3/orders/%s/address", isSandbox() ? SANDBOX_HOST : HOST, orderId)), HttpMethod.PUT, new HttpEntity<>(dto, headers), WishOrder.class);
    }

}
