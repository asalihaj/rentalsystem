package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.ReportCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportCategoryRepository extends JpaRepository<ReportCategory, UUID> {
}
