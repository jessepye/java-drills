package com.sap;

import com.sap.model.Employee;

import java.util.ArrayList;
import java.util.List;

// This is SAP's code, and we can't touch it. It's written by SAP and is not in our namespace
public class SapApi {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void fireEveryone() {
        employees.clear();
    }

}
