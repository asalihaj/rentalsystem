package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {
}
