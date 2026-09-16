package com.example.servicerequest.model;

public class Employee extends User{

    private final String department;

    public Employee(
            long id,
            String name,
            String email,
            String department
    ){
        super(id, name, email, UserRole.EMPLOYEE);
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department cannot be blank");
        }

        this.department = department;

    }

    public String getDepartment() {
        return department;
    }
}
