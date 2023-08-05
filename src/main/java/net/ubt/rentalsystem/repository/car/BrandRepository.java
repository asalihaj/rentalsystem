package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> { }
