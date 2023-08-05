package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserClientRepository extends JpaRepository<UserClient, UUID> {
}
