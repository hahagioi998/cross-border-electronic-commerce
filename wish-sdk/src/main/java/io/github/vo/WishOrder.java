package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/23 13:38
 */
@NoArgsConstructor
@Data
public class WishOrder {
    @JsonProperty("tracking_information")
    private List<TrackingInformation> trackingInformation;
    @JsonProperty("warehouse_information")
    private WarehouseInformation warehouseInformation;
    @JsonProperty("order_payment")
    private OrderPayment orderPayment;
    @JsonProperty("fulfillment_records")
    private List<FulfillmentRecords> fulfillmentRecords;
    @JsonProperty("released_at")
    private String releasedAt;
    @JsonProperty("product_information")
    private ProductInformation productInformation;
    @JsonProperty("penalties")
    private List<String> penalties;
    @JsonProperty("processing_status")
    private String processingStatus;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("full_address")
    private FullAddress fullAddress;
    @JsonProperty("processing_source")
    private String processingSource;
    @JsonProperty("fulfillment_requirements")
    private FulfillmentRequirements fulfillmentRequirements;
    @JsonProperty("state")
    private String state;
    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("tax_information")
    private TaxInformation taxInformation;
    @JsonProperty("refunds")
    private List<Refunds> refunds;
    @JsonProperty("id")
    private String id;
    @JsonProperty("fulfillment_order_types")
    private List<String> fulfillmentOrderTypes;
}
