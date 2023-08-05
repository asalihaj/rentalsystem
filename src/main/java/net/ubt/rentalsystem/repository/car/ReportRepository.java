package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
    List<Report> findAllByCarId(UUID carId);
}