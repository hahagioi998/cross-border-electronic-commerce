package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class VatInformation {
    @JsonProperty("eu_vat_customs_declaration")
    private EuVatCustomsDeclaration euVatCustomsDeclaration;
    @JsonProperty("vat_amount")
    private VatAmount vatAmount;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("required_vat_numbers")
    private RequiredVatNumbers requiredVatNumbers;
    @JsonProperty("vat_instructions")
    private String vatInstructions;
    @JsonProperty("additional_materials")
    private List<String> additionalMaterials;
}
