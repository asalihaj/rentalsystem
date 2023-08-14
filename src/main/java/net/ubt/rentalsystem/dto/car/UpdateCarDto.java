package net.ubt.rentalsystem.dto.car;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UpdateCarDto {
    private BigDecimal rentalRate;
    private UUID colorId;
    private String plateNumber;
}
