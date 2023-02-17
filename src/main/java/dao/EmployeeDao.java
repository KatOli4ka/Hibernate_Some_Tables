package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee add(Employee employee);
    Employee readById(long id);
    List<Employee> findAll();
    void updateEmployeeById(Employee employee);
    void deleteById(Employee employee);
}
