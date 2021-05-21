package trungfpt.practicaltest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trungfpt.practicaltest.jpa.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
