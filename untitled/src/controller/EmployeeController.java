package controller;

import model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private List<Employee> employees;

    public EmployeeController() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(int id, String name) {
        Employee newEmployee = new Employee(id, name);
        employees.add(newEmployee);
    }

    public void removeEmployeeById(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
    public List<Employee> getAllEmployees() {
        return employees;
    }
}