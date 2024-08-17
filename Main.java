package org.example;

import java.util.ArrayList;

/*
This project used an abstract class Employee, polymorphism (defining an abstract class and defining its body in the two classes
(FullTimeEmployee and PartTimeEmployee)) that extend the abstract class Employee.

This is an employee payroll system that defines a PayrollSystem object, FullTimeEmployee, PartTimeEmployee, and methods to
add and remove an employee, as well as display information of the employees that are currently in the payroll system.
 */

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) { //Constructor for Employee object
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public abstract double calculateAnnualSalary();

    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateAnnualSalary()+"]";
    }
}

class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, int id, double annualSalary) {
        super(name, id);
        this.annualSalary = annualSalary;
    }
    @Override
    public double calculateAnnualSalary () {
        return annualSalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateAnnualSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;
    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        for(Employee employee : employeeList) {
            if(employee.getId() == id) {
                employeeList.remove(employee);
                break;
            }
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main ( String[] args ) {
        // Create a payroll system
        PayrollSystem payroll = new PayrollSystem();

        // Create a full-time employee
        FullTimeEmployee empFullTime = new FullTimeEmployee("Anna", 0, 80000);
        PartTimeEmployee empPartTime = new PartTimeEmployee("Joe", 1, 2000, 30);

        // Adding the employees to the payroll system
        payroll.addEmployee(empFullTime);
        payroll.addEmployee(empPartTime);

        payroll.displayEmployees();

        // Removing an employee from the payroll system
        payroll.removeEmployee(0);
        System.out.println("Removing an employee:");
        payroll.displayEmployees();
    }
}