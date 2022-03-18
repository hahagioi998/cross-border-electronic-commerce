package io.github.vo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/2/22 15:39
 */
@NoArgsConstructor
@Data
public class AmazonBuyerInfo {


    @JsonProperty("AmazonOrderId")
    private String amazonOrderId;
    @JsonProperty("BuyerEmail")
    private String buyerEmail;
    @JsonProperty("BuyerName")
    private String buyerName;
    @JsonProperty("BuyerCounty")
    private String buyerCounty;
    @JsonProperty("BuyerTaxInfo")
    private BuyerTaxInfo buyerTaxInfo;
    @JsonProperty("PurchaseOrderNumber")
    private String purchaseOrderNumber;

    @NoArgsConstructor
    @Data
    public static class BuyerTaxInfo {
        @JsonProperty("CompanyLegalName")
        private String companyLegalName;
        @JsonProperty("TaxingRegion")
        private String taxingRegion;
        @JsonProperty("TaxClassifications")
        private List<TaxClassification> taxClassifications;

        @NoArgsConstructor
        @Data
        public static class TaxClassification {
            @JsonProperty("Name")
            private String name;
            @JsonProperty("Value")
            private String value;
        }
    }
}
