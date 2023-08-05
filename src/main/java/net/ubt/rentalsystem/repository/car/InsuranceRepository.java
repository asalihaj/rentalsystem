package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
    List<Insurance> findAllByCompanyId(UUID companyId);
}