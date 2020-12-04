package miu.edu.lab10.repository;


import miu.edu.lab10.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.id= :id")
    public Employee findByEmployeeNumber(@Param("id") Long employeeNumber);
}

