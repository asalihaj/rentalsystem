package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    List<Equipment> findAllByCompanyId(UUID id);
}