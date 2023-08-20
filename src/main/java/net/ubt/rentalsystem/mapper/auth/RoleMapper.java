package net.ubt.rentalsystem.mapper.auth;

import net.ubt.rentalsystem.dto.auth.CreateRoleDto;
import net.ubt.rentalsystem.entity.user.CustomRole;
import net.ubt.rentalsystem.entity.user.Permission;
import net.ubt.rentalsystem.entity.user.User;
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
public interface RoleMapper {

    @Mapping(target = "permissions", source = "permissions", qualifiedByName = "idToPermissions")
    @Mapping(target = "user", source = "userId", qualifiedByName = "idToUser")
    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "lastUpdate", expression = "java(OffsetDateTime.now())")
    CustomRole toRoleDto(CreateRoleDto createRoleDto);

    @Named("idToPermissions")
    static Permission idToPermissions(UUID id) {
        Permission p = new Permission();
        p.setId(id);
        return p;
    }

    @Named("idToUser")
    static User idToUser(UUID id) {
        User u = new User();
        u.setId(id);
        return u;
    }
}
