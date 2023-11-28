package net.ubt.rentalsystem.repository.booking;

import net.ubt.rentalsystem.entity.booking.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Contract, UUID> {
}
