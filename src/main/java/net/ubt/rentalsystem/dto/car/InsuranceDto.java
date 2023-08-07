package net.ubt.rentalsystem.dto.car;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InsuranceDto {
    private String name;
    private Integer coverValue;
    private Boolean isFixed;
    private BigDecimal price;
}
