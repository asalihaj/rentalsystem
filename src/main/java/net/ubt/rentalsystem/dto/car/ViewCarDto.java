package net.ubt.rentalsystem.dto.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class ViewCarDto extends CarBaseDto {
    private BigDecimal rentalRate;
    private GroupDto group;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastUpdate;
    private String status;
}
