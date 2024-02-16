package Employees;
import MainPackage.*;
import Employees.*;
import Filters.*;
import Orders.*;
import java.io.*;
import java.util.*;

// We use only one object from this
// class which represents the manger.

public class Manager extends Employee {
    // The manger reference variable.
    public static Manager manager;

    public Manager(
        String name,
        String id,
        String personalPhoneNumber,
        double salary
    ) {
        super(name, id, personalPhoneNumber, salary);
    }

    // This method is used to fire an employee. This happens by
    // removing this employee from the employees' container.
    public void fireEmployee() {
        // Taking the id of the employee to be fired.
        System.out.printf("Enter Employee's ID: ");

        // Getting the employee from the employees' container.
        Employee employee = Utility.getById(Utility.Input.next());
        if (employee != null) {
            // If the employee exists, then it's removed and his
            // information is displayed to the manager.
            System.out.printf("%s\n", employee.toString());
            Utility.employeesContainer.remove(employee);
            System.out.printf("FIRED SUCCESSFULLY.\n");
        } else {
            System.out.printf("UNSUCCESSFUL FIRING ATTEMPT. PLEASE CHECK THE ID.\n");
        }
    }

    // This method is used to hire a new employee. Either
    // an orders employee or mission employee.
    public void hireEmployee() {
        System.out.printf("Which type of employees you want to hire?\n");
        System.out.printf("1. Orders Employee.\n");
        System.out.printf("2. Mission Employee.\n");
        System.out.printf("Enter your choice here: ");
        String choice;
        while (true) {
            choice = Utility.Input.next();
            if (
                choice.equals("1") ||
                choice.equals("2")
            ) {
                break;
            } else {
                System.out.printf("INVALID INPUT. Try again: ");
            }
        }
        switch (choice) {
            case "1": {
                System.out.printf("|| HIRING ORDERS EMPLOYEE ||\n");
                // Creating the object to hold the information of the new orders employee.
                OrdersEmployee newOrdersEmployee = new OrdersEmployee();
                // Collecting the required information.
                System.out.printf("Enter the required information\n");
                System.out.printf("Name: ");
                newOrdersEmployee.setName(Utility.Input.nextLine());
                System.out.printf("ID: ");
                newOrdersEmployee.setId(Utility.getNewId());
                System.out.printf("Phone number: ");
                newOrdersEmployee.setPersonalPhoneNumber(Utility.Input.next());
                System.out.printf("Salary: ");
                newOrdersEmployee.setSalary(Utility.Input.nextDouble());
                System.out.printf("Office room number: ");
                newOrdersEmployee.setOfficeRoomNumber(Utility.Input.next());
                System.out.printf("Office phone number: ");
                newOrdersEmployee.setOfficePhoneNumber(Utility.Input.next());
                // Adding the new employee to the employees' container.
                Utility.employeesContainer.add(newOrdersEmployee);
                System.out.printf("%s\n", newOrdersEmployee.toString());
                System.out.printf("%s is hired as an orders employee successfully.\n", newOrdersEmployee.getName());
                break;
            } case "2": {
                System.out.printf("|| HIRING MISSION EMPLOYEE ||\n");
                // Creating the object to hold the information of the new mission employee.
                MissionEmployee newMissionEmployee = new MissionEmployee();
                // Collecting the required information.
                System.out.printf("Enter the required information\n");
                System.out.printf("Name: ");
                newMissionEmployee.setName(Utility.Input.nextLine());
                System.out.printf("ID: ");
                newMissionEmployee.setId(Utility.getNewId());
                System.out.printf("Phone number: ");
                newMissionEmployee.setPersonalPhoneNumber(Utility.Input.next());
                System.out.printf("Salary pre mission: ");
                newMissionEmployee.setSalaryPerMission(Utility.Input.nextDouble());
                // Adding the new employee to the employees' container.
                Utility.employeesContainer.add(newMissionEmployee);
                System.out.printf("%s\n", newMissionEmployee.toString());
                System.out.printf("%s is hired as a mission employee successfully.\n", newMissionEmployee.getName());
                break;
            }
        }
    }

    // This function shows the information of a specific employee
    // to the manager according to his id.
    // The id of any employee is exactly 5 digits.
    public void showSpecificEmployee() {
        System.out.printf("Enter id: ");
        String id;
        while (true) {
            // Taking the id from the manager.
            id = Utility.Input.next();
            // Checking the validity of the id's format.
            if (Utility.isValidId(id)) {
                if (Utility.idChecker.contains(id)) {
                    // If the id is valid and the employee exists,
                    // then we show his information to the manager.
                    System.out.printf("%s\n", Utility.getById(id));
                } else {
                    // Employee not found.
                    System.out.printf("Not Found.\n");
                }
                return;
            } else {
                // The id format is not valid.
                System.out.printf("Invalid ID format. Try again: ");
            }
        }
    }

    // In this method, all mission employees are displayed by
    // iterating over all employees, and then checking if the
    // current employee is instance of MissionEmployee class.
    // If so, then we display his information.
    public void showAllMissionEmployees() {
        System.out.printf("%s\n", Utility.missionEmployeeHeader);
        for (var e : Utility.employeesContainer)
            if (e instanceof MissionEmployee)
                System.out.printf("%s\n", Utility.formatMissionEmployee((MissionEmployee) e));
    }

    // In this method, all orders employees are displayed by
    // iterating over all employees, and then checking if the
    // current employee is instance of OrdersEmployee class.
    // If so, then we display his information.
    public void showAllOrderEmployees() {
        System.out.printf("%s\n", Utility.ordersEmployeeHeader);
        for (var e : Utility.employeesContainer)
            if (e instanceof OrdersEmployee)
                System.out.printf("%s\n", Utility.formatOrdersEmployee((OrdersEmployee) e));
    }

    // This method show the information of the manager as well
    // as all employees in the system.
    public void showAllEmployees() {
        System.out.printf("%s\n", Manager.manager.toString());
        showAllMissionEmployees();
        showAllOrderEmployees();
    }

    // This method shows all non performed new filter orders by
    // iterating over each mission employee's ordersQueue, and
    // printing any order which is instance of NewFilterOrder class.
    public void showNewFilterOrders() {
        System.out.printf("%s\n", Utility.newFilterOrderHeader);
        for (var employee : Utility.employeesContainer)
            if (employee instanceof MissionEmployee)
                for (var e : ((MissionEmployee) employee).ordersQueue)
                    if (e instanceof NewFilterOrder)
                        System.out.printf("%s\n", Utility.formatNewFilterOrder((NewFilterOrder) e));
    }

    // This method shows all non performed after sale orders by
    // iterating over each mission employee's ordersQueue, and
    // printing any order which is instance of AfterSaleOrder class.
    public void showAfterSaleOrders() {
        System.out.printf("%s\n", Utility.afterSaleOrderHeader);
        for (var employee : Utility.employeesContainer)
            if (employee instanceof MissionEmployee)
                for (var e : ((MissionEmployee) employee).ordersQueue)
                    if (e instanceof AfterSaleOrder)
                        System.out.printf("%s\n", Utility.formatAfterSaleOrder((AfterSaleOrder) e));
    }

    // This method prints all non performed orders.
    public void showAllOrders() {
        showNewFilterOrders();
        showAfterSaleOrders();
    }

    // This method shows all performed new filter orders by
    // iterating over each mission employee's ordersHistory, and
    // printing any order which is instance of NewFilterOrder class.
    public void showNewFilterOrdersHistory() {
        System.out.printf("%s\n", Utility.newFilterOrderHeader);
        for (var employee : Utility.employeesContainer)
            if (employee instanceof MissionEmployee)
                for (var e : ((MissionEmployee) employee).ordersHistory)
                    if (e instanceof NewFilterOrder)
                        System.out.printf("%s\n", Utility.formatNewFilterOrder((NewFilterOrder) e));
    }

    // This method shows all performed after sale orders by
    // iterating over each mission employee's ordersQueue, and
    // printing any order which is instance of AfterSaleOrder class.
    public void showAfterSaleOrdersHistory() {
        System.out.printf("%s\n", Utility.afterSaleOrderHeader);
        for (var employee : Utility.employeesContainer)
            if (employee instanceof MissionEmployee)
                for (var e : ((MissionEmployee) employee).ordersHistory)
                    if (e instanceof AfterSaleOrder)
                        System.out.printf("%s\n", Utility.formatAfterSaleOrder((AfterSaleOrder) e));
    }

    // This method prints all performed orders.
    public void showAllOrdersHistory() {
        showNewFilterOrdersHistory();
        showAfterSaleOrdersHistory();
    }

    // This method prints the information of the manager.
    @Override
    public void showMyInformation() {
        System.out.printf("%s\n", manager.toString());
    }

    // toString method provides a representation of the manager's information.
    @Override
    public String toString() {
        return  String.format(
            "+---------------------------------------------------------+\n" +
            "|                         MANAGER                         |\n" +
            "+----------------------+-------+-------------+------------+\n" +
            "| %-20s | %-5s | %-11s | %-10s |\n" +
            "+----------------------+-------+-------------+------------+\n" +
            "| %-20s | %-5s | %-11s | %-10s |\n" +
            "+----------------------+-------+-------------+------------+",
            "Name", "ID", "Phone No.", "Salary",
            getName(), getId(), getPersonalPhoneNumber(), getSalary()
        );
    }
}
