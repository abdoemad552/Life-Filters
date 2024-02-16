package MainPackage;
import Employees.*;
import Filters.*;
import Orders.*;
import java.io.*;
import java.util.*;

public class Main {
    public static boolean checkId(String id, String choice) {
        // Getting the employee with the given id.
        Employee employee = Utility.getById(id);

        // There is no employee with this id.
        if (employee == null) return false;

        // Orders employee and the user chose 1.
        if (employee instanceof OrdersEmployee   && choice.equals("1")) return true;
        // Mission employee and the user chose 2.
        if (employee instanceof MissionEmployee  && choice.equals("2")) return true;
        // Manager and the user chose 3.
        if (employee instanceof Manager          && choice.equals("3")) return true;
        return false;
    }
    public static void main(String[] args) throws Exception {
        // Loading the latest version of the program from the database files.
        DataBase.load();
        while (true) {
            System.out.printf("|| LIFE FILTERS MANAGEMENT SYSTEM ||\n");

            System.out.printf("YOU WANT TO ENTER AS:\n");
            System.out.printf("1. Orders Employee\n");
            System.out.printf("2. Mission Employee\n");
            System.out.printf("3. Manager\n");
            System.out.printf("4. Exit\n");

            String choice;
            System.out.printf("Enter your choice: ");
            while (true) {
                choice = Utility.Input.next();
                if (
                    choice.equals("1") ||
                    choice.equals("2") ||
                    choice.equals("3") ||
                    choice.equals("4")
                ) {
                    break;
                } else {
                    System.out.printf("INVALID INPUT. Try again: ");
                }
            }

            // EXITING THE PROGRAM...
            if (choice.equals("4")) {
                System.out.printf("*********************************\n");
                System.out.printf("*********    EXITING    *********\n");
                System.out.printf("*********************************"  );
                break;
            }

            String id = null;
            boolean success = false;
            System.out.printf("Please, Enter your id (You have only 5 attempts): ");
            // This loop takes the id from the user, and checks
            // if the id is valid and check if the id matches
            // any user from the employees' container.
            for (int i = 0; i < 5; i++) {
                id = Utility.Input.next();
                if (Utility.isValidId(id) && checkId(id, choice)) {
                    success = true;
                    break;
                } else {
                    if (i < 4) System.out.printf("INVALID INPUT. Try again: ");
                }
            }

            // The user has only 5 attempts, if he gives wrong
            // id for 5 times, the program exits.
            if (!success) {
                System.out.printf("Sorry, you ran out of attempts.\n");
                System.exit(0);
            }

            switch (choice) {
                case "1": /* Orders Employee */ {
                    OrdersEmployee e = (OrdersEmployee) Utility.getById(id);
                    System.out.printf("Welcome, %s.\n", e.getName());
                    while (true) {
                        System.out.printf("How can i help you?\n");
                        System.out.printf("1. Add an order.\n");
                        System.out.printf("2. Show my orders' history.\n");
                        System.out.printf("3. Show my information.\n");
                        System.out.printf("4. Quit.\n");
                        System.out.printf("Enter your choice: ");
                        while (true) {
                            choice = Utility.Input.next();
                            if (
                                choice.equals("1") ||
                                choice.equals("2") ||
                                choice.equals("3") ||
                                choice.equals("4")
                            ) {
                                break;
                            } else {
                                System.out.printf("INVALID INPUT. Try again.\n");
                            }
                        }
                        switch (choice) {
                            // 1. Add an order.
                            case "1": e.addOrder();
                                break;
                            // 2. Show my orders' history.
                            case "2": e.showMyOrdersHistory();
                                break;
                            // 3. Show my information.
                            case "3": e.showMyInformation();
                                break;
                        }
                        if (choice.equals("4")) break;
                        System.out.printf("Anything more? (Y / N): ");
                        choice = Utility.Input.next().toLowerCase();
                        if (choice.equals("n")) break;
                    }
                    System.out.printf("Goodbye %s.\n", e.getName());
                    break;
                } case "2": /* Mission Employee */ {
                    MissionEmployee e = (MissionEmployee) Utility.getById(id);
                    System.out.printf("Welcome, %s\n", e.getName());
                    while (true) {
                        System.out.printf("How can i help you?\n");
                        System.out.printf("1. Perform mission.\n");
                        System.out.printf("2. Show my missions' queue.\n");
                        System.out.printf("3. Show my missions' history.\n");
                        System.out.printf("4. Show my current salary.\n");
                        System.out.printf("5. Show my information.\n");
                        System.out.printf("6. Quit.\n");
                        System.out.printf("Enter your choice: ");
                        while (true) {
                            choice = Utility.Input.next();
                            if (
                                choice.equals("1") ||
                                choice.equals("2") ||
                                choice.equals("3") ||
                                choice.equals("4") ||
                                choice.equals("5") ||
                                choice.equals("6")
                            ) {
                                break;
                            } else {
                                System.out.printf("INVALID INPUT. Try again.\n");
                            }
                        }
                        switch (choice) {
                            // 1. Perform mission.
                            case "1": e.performMission();
                                break;
                            // 2. Show my missions' queue.
                            case "2": e.showMyMissionsQueue();
                                break;
                            // 3. Show my missions' history.
                            case "3": e.showMyMissionsHistory();
                                break;
                            // 4. Show my current salary.
                            case "4": e.showMyCurrentSalary();
                                break;
                            // 5. Show my information.
                            case "5": e.showMyInformation();
                                break;
                        }
                        if (choice.equals("6")) break;
                        System.out.printf("Anything more? (Y / N): ");
                        choice = Utility.Input.next().toLowerCase();
                        if (choice.equals("n")) break;
                    }
                    System.out.printf("Goodbye %s.\n", e.getName());
                    break;
                } case "3": /* Manager */ {
                    System.out.printf("Hi, manager %s\n", Manager.manager.getName());
                    while (true) {
                        System.out.printf("How can i help you?\n");
                        System.out.printf("1.  Hire an employee.\n");
                        System.out.printf("2.  Fire an employee.\n");
                        System.out.printf("3.  Show specific employee.\n");
                        System.out.printf("4.  Show all mission employees.\n");
                        System.out.printf("5.  Show all orders employees.\n");
                        System.out.printf("6.  Show all employees.\n");
                        System.out.printf("7.  Show new filter orders.\n");
                        System.out.printf("8.  Show after sale orders.\n");
                        System.out.printf("9.  Show all orders.\n");
                        System.out.printf("10. Show new filter orders history.\n");
                        System.out.printf("11. Show after sale orders history.\n");
                        System.out.printf("12. Show all orders history.\n");
                        System.out.printf("13. Show your information.\n");
                        System.out.printf("14. Quit.\n");
                        while (true) {
                            System.out.printf("Enter you choice: ");
                            choice = Utility.Input.next();
                            if (
                                choice.equals("1")  ||
                                choice.equals("2")  ||
                                choice.equals("3")  ||
                                choice.equals("4")  ||
                                choice.equals("5")  ||
                                choice.equals("6")  ||
                                choice.equals("7")  ||
                                choice.equals("8")  ||
                                choice.equals("9")  ||
                                choice.equals("10") ||
                                choice.equals("11") ||
                                choice.equals("12") ||
                                choice.equals("13") ||
                                choice.equals("14")
                            ) {
                                break;
                            } else {
                                System.out.printf("INVALID INPUT. Try again.\n");
                            }
                        }
                        switch (choice) {
                            // 1.  Hire a new employee.
                            case "1": Manager.manager.hireEmployee();
                                break;
                            // 2.  Fire an employee.
                            case "2": Manager.manager.fireEmployee();
                                break;
                            // 3.  Show specific employee.
                            case "3": Manager.manager.showSpecificEmployee();
                                break;
                            // 4.  Show all mission employees.
                            case "4": Manager.manager.showAllMissionEmployees();
                                break;
                            // 5.  Show all orders employees.
                            case "5": Manager.manager.showAllOrderEmployees();
                                break;
                            // 6.  Show all employees.
                            case "6": Manager.manager.showAllEmployees();
                                break;
                            // 7.  Show new filter orders.
                            case "7": Manager.manager.showNewFilterOrders();
                                break;
                            // 8.  Show after sale orders.
                            case "8": Manager.manager.showAfterSaleOrders();
                                break;
                            // 9. Show all orders.
                            case "9": Manager.manager.showAllOrders();
                                break;
                            // 10. Show new filter orders history.
                            case "10": Manager.manager.showNewFilterOrdersHistory();
                                break;
                            // 11. Show after sale orders history.
                            case "11": Manager.manager.showAfterSaleOrdersHistory();
                                break;
                            // 12. Show all orders history.
                            case "12": Manager.manager.showAllOrdersHistory();
                                break;
                            // 13. Show my information.
                            case "13": Manager.manager.showMyInformation();
                                break;
                        }
                        if (choice.equals("14")) break;
                        System.out.printf("Anything more? (Y / N): ");
                        choice = Utility.Input.next().toLowerCase();
                        if (choice.equals("n")) break;
                    }
                    System.out.printf("Goodbye manager %s.\n", Manager.manager.getName());
                    break;
                }
            }
            System.out.printf("*********************************\n");
            System.out.printf("********* LOADING AGAIN *********\n");
            System.out.printf("*********************************\n");
        }
        // Storing the changes in the program in the database files.
        DataBase.store();
    }
}