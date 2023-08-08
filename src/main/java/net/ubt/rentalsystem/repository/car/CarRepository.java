package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.entity.car.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findAllByCompanyId(UUID companyId);

    List<Car> findAllByStatus(Status status);
}
