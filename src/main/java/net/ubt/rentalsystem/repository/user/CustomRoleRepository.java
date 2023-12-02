package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.CustomRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomRoleRepository extends JpaRepository<CustomRole, UUID> {
    List<CustomRole> findAllByUserId(UUID userId);
}
