package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}
