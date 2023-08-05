package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
