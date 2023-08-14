package net.ubt.rentalsystem.dto.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class CarOfferDto extends CarBaseDto {
    private BigDecimal price;
}
