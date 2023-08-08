package net.ubt.rentalsystem.mapper.car;

import net.ubt.rentalsystem.dto.car.CarBaseDto;
import net.ubt.rentalsystem.dto.car.CarOfferDto;
import net.ubt.rentalsystem.entity.car.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.WARN,
        imports = Collectors.class
)
public interface CarMapper {

    @Mapping(expression = "java(car.getUtilities().stream().map(u -> u.getName()).collect(Collectors.toSet()))", target = "utilities")
    @Mapping(source = "model.brand.name", target = "model.brand")
    CarBaseDto toBaseDto(Car car);

    @Mapping(expression = "java(car.getUtilities().stream().map(u -> u.getName()).collect(Collectors.toSet()))", target = "utilities")
    @Mapping(source = "model.brand.name", target = "model.brand")
    CarOfferDto toOfferDto(Car car);
}
