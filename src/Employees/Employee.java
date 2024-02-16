package Employees;
import Employees.*;
import Filters.*;
import Orders.*;
import java.io.*;
import java.util.*;

public abstract class Employee {
    protected String name;
    protected String id;
    protected String personalPhoneNumber;
    protected double salary;

    public Employee() {}

    public Employee(
        String name,
        String id,
        String personalPhoneNumber,
        double salary
    ) {
        this.name                   = name;
        this.id                     = id;
        this.personalPhoneNumber    = personalPhoneNumber;
        this.salary                 = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public double   getSalary() {
        return salary;
    }

    public void     setSalary(double salary) {
        this.salary = salary;
    }

    // Abstract Method that should be found in any type of employees
    // in order to show his information.
    public abstract void showMyInformation();
}