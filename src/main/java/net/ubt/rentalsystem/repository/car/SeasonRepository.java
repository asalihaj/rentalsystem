package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {
    List<Season> findAllByCompanyId(UUID companyId);
}
