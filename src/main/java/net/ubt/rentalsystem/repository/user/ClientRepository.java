package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}

