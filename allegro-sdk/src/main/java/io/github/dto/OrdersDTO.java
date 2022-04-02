package io.github.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by EalenXie on 2022/2/21 16:05
 */
@Getter
@Setter
public class OrdersDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String offset;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String limit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fulfillment.status")
    private String fulfillmentStatus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("fulfillment.shipmentSummary.lineItemsSent")
    private String lineItemsSent;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("lineItems.boughtAt.lte")
    private String boughtAtLte;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("lineItems.boughtAt.gte")
    private String boughtAtGte;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("payment.id")
    private String paymentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("surcharges.id")
    private String surchargesId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("delivery.method.id")
    private String deliveryMethodId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("buyer.login")
    private String buyerLogin;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("updatedAt.lte")
    private String updatedAtLte;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("updatedAt.gte")
    private String updatedAtGte;
    /**
     * "lineItems.boughtAt" "-lineItems.boughtAt" "updatedAt" "-updatedAt"
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sort;

}
