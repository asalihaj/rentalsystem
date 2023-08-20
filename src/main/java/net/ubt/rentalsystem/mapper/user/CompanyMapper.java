package net.ubt.rentalsystem.mapper.user;

import net.ubt.rentalsystem.dto.auth.RegisterRequest;
import net.ubt.rentalsystem.dto.user.RegisterCompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.WARN
)
public interface CompanyMapper {

    RegisterRequest toUserRegister(RegisterCompanyDto registerCompanyDto);
}
