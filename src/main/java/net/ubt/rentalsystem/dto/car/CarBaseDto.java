package net.ubt.rentalsystem.dto.car;

import lombok.Data;
import net.ubt.rentalsystem.entity.car.Category;

import java.util.Set;
import java.util.UUID;

@Data
public class CarBaseDto {
    private UUID id;
    private Short seats;
    private Short doors;
    private Short productionYear;
    private Category category;
    private ModelDto model;
    private ColorDto color;
    private String fuelType;
    private Set<String> utilities;
    private Set<InsuranceDto> insurances;
}
