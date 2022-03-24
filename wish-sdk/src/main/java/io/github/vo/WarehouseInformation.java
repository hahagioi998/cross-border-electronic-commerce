package io.github.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by EalenXie on 2022/3/24 15:47
 */
@NoArgsConstructor
@Data
public class WarehouseInformation {
    @JsonProperty("warehouse_type")
    private String warehouseType;
    @JsonProperty("warehouse_name")
    private String warehouseName;
    @JsonProperty("warehouse_id")
    private String warehouseId;
    @JsonProperty("fbw_information")
    private FbwInformation fbwInformation;
}
