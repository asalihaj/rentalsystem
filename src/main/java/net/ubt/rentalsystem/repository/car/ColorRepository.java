package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColorRepository extends JpaRepository<Color, UUID> {
}
