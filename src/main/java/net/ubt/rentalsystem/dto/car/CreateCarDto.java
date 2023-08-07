package net.ubt.rentalsystem.dto.car;

import lombok.Data;
import net.ubt.rentalsystem.dto.IdDto;
import net.ubt.rentalsystem.entity.car.Category;
import net.ubt.rentalsystem.entity.car.FuelType;
import net.ubt.rentalsystem.entity.car.Status;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class CreateCarDto {
    private Short doors;
    private Short seats;
    private BigDecimal rentalRate;
    private Short productionYear;
    private String plateNumber;
    private Category category;
    private Status status;
    private FuelType fuelType;
    private UUID companyId;
    private UUID modelId;
    private UUID colorId;
    private UUID groupId;
    private Set<IdDto> utilities;
    private Set<IdDto> insurances;
}
