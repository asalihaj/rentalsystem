package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
    List<Model> findAllByBrandId(UUID brandId);
}
