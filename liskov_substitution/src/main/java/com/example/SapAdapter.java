package com.example;

import com.sap.model.Employee;
import com.sap.SapApi;

import java.util.ArrayList;
import java.util.List;

public class SapAdapter {

    SapApi api;
    List<Employee> employees = new ArrayList<>();

    public SapAdapter(SapApi api) {
        this.api = api;
    }

    public void addEmployee(Employee employee) {
        // First we store the employee in our "database" (just a list)
        employees.add(employee);

        // Then we make a call to SAP to store the employee
        api.addEmployee(employee);
    }

    public void fireEveryone() {
        employees.clear();
        api.fireEveryone();
    }

    public ImmutableEmployeeList<Employee> getEmployeesAsUser() {
        return new ImmutableEmployeeList(employees);
    }

    public ImmutableEmployeeList<Employee> getEmployeesAsCeo() {
        return new MutableEmployeeList(this);
    }
}
