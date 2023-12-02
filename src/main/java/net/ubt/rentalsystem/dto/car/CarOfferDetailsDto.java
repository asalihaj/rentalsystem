package net.ubt.rentalsystem.dto.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
public class CarOfferDetailsDto extends CarOfferDto {
    private Set<String> utilities;
    private Set<InsuranceDto> insurances;
}
