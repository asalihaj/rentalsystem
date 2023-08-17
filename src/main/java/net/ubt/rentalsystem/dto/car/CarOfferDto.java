package net.ubt.rentalsystem.dto.car;

import lombok.Data;
import net.ubt.rentalsystem.entity.car.Category;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CarOfferDto {
    private UUID id;
    private Short seats;
    private Short doors;
    private Short productionYear;
    private Category category;
    private ModelDto model;
    private ColorDto color;
    private String fuelType;
    private BigDecimal price;
}
