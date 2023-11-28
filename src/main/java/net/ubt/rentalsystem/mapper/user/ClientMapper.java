package net.ubt.rentalsystem.mapper.user;

import net.ubt.rentalsystem.dto.user.ClientCreateDto;
import net.ubt.rentalsystem.dto.user.ClientDto;
import net.ubt.rentalsystem.entity.user.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.WARN
)
public interface ClientMapper {

    @Mapping(source = "gender", target = "gender")
    ClientDto clientToClientDto(Client client);

    Client clientCreateDtoToClient(ClientCreateDto clientCreateDto);
}
