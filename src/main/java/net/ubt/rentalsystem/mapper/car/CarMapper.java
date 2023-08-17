package net.ubt.rentalsystem.mapper.car;

import net.ubt.rentalsystem.dto.car.CarBaseDto;
import net.ubt.rentalsystem.dto.car.CarOfferDetailsDto;
import net.ubt.rentalsystem.dto.car.CarOfferDto;
import net.ubt.rentalsystem.dto.car.CreateCarDto;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.entity.car.Insurance;
import net.ubt.rentalsystem.entity.car.Utility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.WARN,
        imports = {Collectors.class, OffsetDateTime.class}
)
public interface CarMapper {

    @Mapping(expression = "java(car.getUtilities().stream().map(u -> u.getName()).collect(Collectors.toSet()))", target = "utilities")
    @Mapping(source = "model.brand.name", target = "model.brand")
    CarBaseDto toBaseDto(Car car);

    @Mapping(source = "model.brand.name", target = "model.brand")
    CarOfferDto toOfferDto(Car car);

    @Mapping(expression = "java(car.getUtilities().stream().map(u -> u.getName()).collect(Collectors.toSet()))", target = "utilities")
    @Mapping(source = "model.brand.name", target = "model.brand")
    CarOfferDetailsDto toOfferDetailsDto(Car car);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "lastUpdate", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "model.id", source = "modelId")
    @Mapping(target = "color.id", source = "colorId")
    @Mapping(target = "group.id", source = "groupId")
    @Mapping(target = "utilities", source = "utilities", qualifiedByName = "idToUtility")
    @Mapping(target = "insurances", source = "insurances", qualifiedByName = "idToInsurance")
    Car createCarDtoToCar(CreateCarDto createCarDto);

    @Named("idToUtility")
    static Utility idToUtility(UUID id) {
        Utility u = new Utility();
        u.setId(id);
        return u;
    }

    @Named("idToInsurance")
    static Insurance idToInsurance(UUID id) {
        Insurance i = new Insurance();
        i.setId(id);
        return i;
    }
}
