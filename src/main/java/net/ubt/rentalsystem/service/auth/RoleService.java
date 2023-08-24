package net.ubt.rentalsystem.service.auth;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.auth.CreateRoleDto;
import net.ubt.rentalsystem.entity.user.CustomRole;
import net.ubt.rentalsystem.entity.user.User;
import net.ubt.rentalsystem.mapper.auth.RoleMapper;
import net.ubt.rentalsystem.repository.user.CustomRoleRepository;
import net.ubt.rentalsystem.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final CustomRoleRepository roleRepository;
    private final UserRepository userRepository;
    private final RoleMapper roleMapper;

    public void createRole(CreateRoleDto createRoleDto) {
        CustomRole role = roleMapper.toRoleDto(createRoleDto);

        roleRepository.save(role);
    }

    public void addUserToRole(UUID roleId, UUID userId) {
        CustomRole role = roleRepository.findById(roleId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        user.getCustomRoles().add(role);

        userRepository.save(user);
    }

    public void removeUserFromRole(UUID roleId, UUID userId) {
        CustomRole role = roleRepository.findById(roleId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        user.getCustomRoles().remove(role);

        userRepository.save(user);
    }

    public List<CustomRole> getRolesByUserId(UUID userId) {
        return roleRepository.findAllByUserId(userId);
    }
}
