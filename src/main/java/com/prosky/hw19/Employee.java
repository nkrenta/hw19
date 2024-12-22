package com.prosky.hw19;

public class Employee {

    private String firstName;

    private String lastName;

    private int salary;

    private String department;

    public Employee(String firstName, String lastName, int salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
