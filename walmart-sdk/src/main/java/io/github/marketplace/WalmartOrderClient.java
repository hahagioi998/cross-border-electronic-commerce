package io.github.marketplace;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.marketplace.dto.CancelDTO;
import io.github.marketplace.dto.OrdersDTO;
import io.github.marketplace.dto.RefundDTO;
import io.github.marketplace.dto.ShipmentDTO;
import io.github.marketplace.vo.*;
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
 * Created by EalenXie on 2022/3/16 14:02
 * https://developer.walmart.com/api/us/mp/orders
 */
public class WalmartOrderClient extends WalmartClient {

    private final ObjectMapper mapper;

    public WalmartOrderClient(String clientId, String clientSecret) {
        this(clientId, clientSecret, new RestTemplate());
    }

    public WalmartOrderClient(String clientId, String clientSecret, RestOperations restOperations) {
        this(clientId, clientSecret, restOperations, new ObjectMapper());
    }

    public WalmartOrderClient(String clientId, String clientSecret, RestOperations restOperations, ObjectMapper objectMapper) {
        super(clientId, clientSecret, restOperations);
        this.mapper = objectMapper;
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/getAllReleasedOrders
     */
    public ResponseEntity<WalmartOrders> orders(String accessToken, OrdersDTO dto) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        @SuppressWarnings("unchecked") Map<String, ?> args = mapper.convertValue(dto, Map.class);
        return getRestOperations().exchange(String.format("%s/v3/orders", isSandBoxMode() ? SANDBOX_HOST : HOST), HttpMethod.GET, new HttpEntity<>(null, headers), WalmartOrders.class, args != null ? args : new LinkedHashMap<>());
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/getAnOrder
     */
    public ResponseEntity<WalmartOrder> order(String accessToken, String orderId) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        return getRestOperations().exchange(URI.create(String.format("%s/v3/orders/%s", isSandBoxMode() ? SANDBOX_HOST : HOST, orderId)), HttpMethod.GET, new HttpEntity<>(null, headers), WalmartOrder.class);
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/getAllReleasedOrders
     */
    public ResponseEntity<WalmartReleasedOrders> releasedOrders(String accessToken) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        return getRestOperations().exchange(URI.create(String.format("%s/v3/orders/released", isSandBoxMode() ? SANDBOX_HOST : HOST)), HttpMethod.GET, new HttpEntity<>(null, headers), WalmartReleasedOrders.class);
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/refundOrderLines
     */
    public ResponseEntity<WalmartRefund> refund(String purchaseOrderId, String accessToken, RefundDTO dto) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        return getRestOperations().exchange(String.format("%s/v3/orders/%s/refund", isSandBoxMode() ? SANDBOX_HOST : HOST, purchaseOrderId), HttpMethod.POST, new HttpEntity<>(dto, headers), WalmartRefund.class);
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/shippingUpdates
     */
    public ResponseEntity<WalmartRefund> shipment(String purchaseOrderId, String accessToken, ShipmentDTO dto) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        return getRestOperations().exchange(String.format("%s/v3/orders/%s/shipping", isSandBoxMode() ? SANDBOX_HOST : HOST, purchaseOrderId), HttpMethod.POST, new HttpEntity<>(dto, headers), WalmartRefund.class);
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/acknowledgeOrders
     */
    public ResponseEntity<WalmartAcknowledge> acknowledge(String purchaseOrderId, String accessToken) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        return getRestOperations().exchange(String.format("%s/v3/orders/%s/acknowledge", isSandBoxMode() ? SANDBOX_HOST : HOST, purchaseOrderId), HttpMethod.POST, new HttpEntity<>(null, headers), WalmartAcknowledge.class);
    }

    /**
     * https://developer.walmart.com/api/us/mp/orders#operation/cancelOrderLines
     */
    public ResponseEntity<WalmartCancel> cancel(String purchaseOrderId, String accessToken, CancelDTO dto) {
        HttpHeaders headers = getCommonHeaders();
        headers.set(WM_SEC_ACCESS_TOKEN, accessToken);
        return getRestOperations().exchange(String.format("%s/v3/orders/%s/cancel", isSandBoxMode() ? SANDBOX_HOST : HOST, purchaseOrderId), HttpMethod.POST, new HttpEntity<>(dto, headers), WalmartCancel.class);
    }

}
