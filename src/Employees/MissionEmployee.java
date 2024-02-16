package Employees;
import Employees.*;
import Filters.*;
import MainPackage.Utility;
import Orders.*;
import java.io.*;
import java.util.*;

public class MissionEmployee extends Employee {
    private double salaryPerMission;
    public Queue<Order> ordersQueue;
    public Queue<Order> ordersHistory;

    {
        ordersQueue = new LinkedList<>() {
            @Override
            public String toString() {
                if (ordersQueue.isEmpty()) return "Missions queue is empty.";
                StringBuilder res = new StringBuilder(); int i = 1;
                for (var order : ordersQueue) {
                    res.append(order);
                    if (i++ != ordersQueue.size()) res.append("\n");
                }
                return res.toString();
            }
        };
        ordersHistory = new LinkedList<>() {
            @Override
            public String toString() {
                if (ordersHistory.isEmpty()) return "History is empty.";
                StringBuilder res = new StringBuilder(); int i = 1;
                for (var order : ordersHistory) {
                    res.append(order);
                    if (i++ != ordersHistory.size()) res.append("\n");
                }
                return res.toString();
            }
        };
    }

    public MissionEmployee() {}
    public MissionEmployee(
            String name,
            String id,
            String personalPhoneNumber,
            double salaryPerMission
    ) {
        super(name, id, personalPhoneNumber, -1);
        this.salaryPerMission = salaryPerMission;
    }

    @Override
    public double getSalary() { return ordersHistory.size() * salaryPerMission; }

    public double getSalaryPerMission() {
        return salaryPerMission;
    }

    public void setSalaryPerMission(double salaryPerMission) {
        this.salaryPerMission = salaryPerMission;
    }

    public int getNumberOfPerformedMissions() {
        return ordersHistory.size();
    }

    public int getNumberOfAvailableMissions() {
        return ordersQueue.size();
    }

    public void performMission() {
        if (ordersQueue.isEmpty()) {
            System.out.printf("You don't have any missions currently.\n");
        } else {
            ordersQueue.element().setStatus(true);
            System.out.printf("%s\n", ordersQueue.element());
            ordersHistory.add(ordersQueue.remove());
            System.out.printf("Mission performed successfully.\n");
        }
    }

    public void showMyMissionsQueue() {
        System.out.printf("%s\n", this.ordersQueue.toString());
    }
    public void showMyMissionsHistory() {
        System.out.printf("%s\n", this.ordersHistory.toString());
    }
    public void showMyCurrentSalary() {
        System.out.printf("Your current salary is %.3f EGP.\n", this.getSalary());
    }
    @Override
    public void showMyInformation() {
        System.out.printf("%s\n", this.toString());
    }

    @Override
    public String toString() {
        return Utility.missionEmployeeHeader + "\n" +
               Utility.formatMissionEmployee(this);
    }
}
