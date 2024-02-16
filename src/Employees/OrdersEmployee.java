package Employees;
import Employees.*;
import Filters.*;
import MainPackage.Main;
import MainPackage.Utility;
import Orders.*;
import java.io.*;
import java.util.*;

public class OrdersEmployee extends Employee {
    private String officeRoomNumber;
    private String officePhoneNumber;

    public Queue<Order> ordersHistory = new LinkedList<>() {
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder(); int i = 1;
            for (var order : ordersHistory) {
                res.append(order);
                if (i++ != ordersHistory.size()) res.append("\n");
            }
            return res.toString();
        }
    };

    public OrdersEmployee() {}

    public OrdersEmployee(
            String name,
            String id,
            String personalPhoneNumber,
            double salary,
            String officeRoomNumber,
            String officePhoneNumber
    ) {
        super(name, id, personalPhoneNumber, salary);
        this.officeRoomNumber   = officeRoomNumber;
        this.officePhoneNumber  = officePhoneNumber;
    }

    public String getOfficeRoomNumber() {
        return officeRoomNumber;
    }

    public void setOfficeRoomNumber(String officeRoomNumber) {
        this.officeRoomNumber = officeRoomNumber;
    }

    public String getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }

    public void addOrder() {
        // The criteria of choosing mission employee is by the one who
        // has the minimum number of missions in missions queue.
        MissionEmployee missionEmployee = null;
        for (var employee : Utility.employeesContainer) {
            if (employee instanceof MissionEmployee &&
                (missionEmployee == null ||
                ((MissionEmployee) employee).getNumberOfAvailableMissions() <= missionEmployee.getNumberOfAvailableMissions())
            ) {
                missionEmployee = (MissionEmployee) employee;
            }
        }
        if (missionEmployee == null) {
            System.out.printf("Sorry, there are no available employees currently.\n");
            System.out.printf("Please, try to add the order later.\n");
            return;
        }
        System.out.printf("Which type of orders you want to add?\n");
        System.out.printf("1. New filter order.\n");
        System.out.printf("2. After sale order.\n");
        System.out.printf("Enter your choice: ");
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
        System.out.printf("Enter client's phone number: ");
        String clintPhoneNumber = Utility.Input.next();
        System.out.printf("Enter client's address: ");
        String clintAddress = Utility.Input.nextLine();
        System.out.printf("Enter client's location link: ");
        String clientLocationLink = Utility.Input.next();
        if (choice.equals("1")) {
            System.out.printf("Which type of filter is needed?\n");
            System.out.printf("1. Gravity filter.\n");
            System.out.printf("2. Stages filter.\n");
            System.out.printf("Enter your choice: ");
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
            Filter filter = null;
            if (choice.equals("1")) {
                System.out.printf("%s\n", GravityFilter.gravityFiltersAvailable);
                System.out.printf("Enter the index of the filter which you want: ");
                try {
                    int index = Utility.Input.nextInt();
                    filter = new GravityFilter(GravityFilter.gravityFiltersAvailable.get(index));
                } catch (Exception exception) {
                    filter = new GravityFilter();
                }
            } else {
                System.out.printf("%s\n", StagesFilter.stagesFiltersAvailable);
                System.out.printf("Enter the index of the filter which you want: ");
                try {
                    int index = Utility.Input.nextInt();
                    filter = new StagesFilter(StagesFilter.stagesFiltersAvailable.get(index));
                } catch (Exception exception) {
                    filter = new StagesFilter();
                }
            }
            System.out.printf("Enter the amount which is needed: ");
            int amount = Utility.Input.nextInt();
            NewFilterOrder order = new NewFilterOrder(
                amount,
                clintPhoneNumber,
                clintAddress,
                clientLocationLink,
                this.getId(),
                missionEmployee.getId(),
                filter
            );
            this.ordersHistory.add(order);
            missionEmployee.ordersQueue.add(order);
        } else {
            System.out.printf("Please, write order's description in one line.\n");
            String orderDescription = Utility.Input.nextLine();
            AfterSaleOrder order = new AfterSaleOrder(
                    clintPhoneNumber,
                    clintAddress,
                    clientLocationLink,
                    this.getId(),
                    missionEmployee.getId(),
                    orderDescription
            );
            this.ordersHistory.add(order);
            missionEmployee.ordersQueue.add(order);
        }
        System.out.printf("Order added successfully.\n");
    }

    public void showMyOrdersHistory() {
        System.out.printf("%s\n", ordersHistory.toString());
    }

    @Override
    public void showMyInformation() {
        System.out.printf("%s\n", this.toString());
    }

    @Override
    public String toString() {
        return Utility.ordersEmployeeHeader + "\n" +
               Utility.formatOrdersEmployee(this);
    }
}
