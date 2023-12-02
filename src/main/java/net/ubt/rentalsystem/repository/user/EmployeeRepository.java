package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.Employee;
import net.ubt.rentalsystem.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findEmployeeByAppUser(User user);
}
