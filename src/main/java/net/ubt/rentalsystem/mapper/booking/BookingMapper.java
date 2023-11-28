package net.ubt.rentalsystem.mapper.booking;

import net.ubt.rentalsystem.dto.booking.ContractCreateDto;
import net.ubt.rentalsystem.dto.booking.ContractViewDto;
import net.ubt.rentalsystem.entity.booking.Contract;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.entity.user.Client;
import net.ubt.rentalsystem.mapper.car.CarMapper;
import net.ubt.rentalsystem.mapper.user.ClientMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.WARN,
        imports = {Collectors.class, OffsetDateTime.class},
        uses = {ClientMapper.class, CarMapper.class}
)
public interface BookingMapper {

    ContractViewDto contractToViewDto(Contract contract);

    @Mapping(target = "car", source = "carId", qualifiedByName = "idToCar")
    @Mapping(target = "client", source = "clientId", qualifiedByName = "idToClient")
    Contract createContractDtoToContract(ContractCreateDto contractCreateDto);

    @Named("idToCar")
    static Car idToCar(UUID id) {
        Car u = new Car();
        u.setId(id);
        return u;
    }

    @Named("idToClient")
    static Client idToClient(UUID id) {
        Client i = new Client();
        i.setId(id);
        return i;
    }
}
