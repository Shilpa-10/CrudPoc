package org.abn.crudpoc.repository;

import org.abn.crudpoc.model.Employee;
import org.springframework.data.jpa.repository .JpaRepository ;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
