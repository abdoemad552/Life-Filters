package MainPackage;
import Employees.*;
import Filters.*;
import Orders.*;
import java.io.*;
import java.util.*;

public class DataBase {
    public static void store() {
        storeMissionEmployees();
        storeOrdersEmployees();
        storeManager();
        storeOrdersQueue();
        storeOrdersHistory();
    }
    public static void load() {
        loadOrdersEmployees();
        loadMissionEmployees();
        loadManager();
        loadOrdersQueue();
        loadOrdersHistory();
        loadIds();
        loadFilters();
    }
    ///////////////////////////////////////////////////////////////////////////
    public static void loadMissionEmployees() {
        try (Scanner input = new Scanner(new File("DataBaseFiles\\MissionEmployees.txt"))) {
            while (input.hasNext()) {
                String[] line = input.nextLine().split("-");
                Utility.employeesContainer.add(new MissionEmployee(
                    line[0].strip(),
                    line[1].strip(),
                    line[2].strip(),
                    Double.parseDouble(line[3].strip())
                ));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public static void loadOrdersEmployees() {
        try (Scanner input = new Scanner(new File("DataBaseFiles\\OrdersEmployees.txt"))) {
            while (input.hasNext()) {
                String[] line = input.nextLine().split("-");
                Utility.employeesContainer.add(new OrdersEmployee(
                    line[0].strip(),
                    line[1].strip(),
                    line[2].strip(),
                    Double.parseDouble(line[3].strip()),
                    line[4].strip(),
                    line[5].strip()
                ));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public static void loadManager() {
        try (Scanner input = new Scanner(new File("DataBaseFiles\\Manager.txt"))) {
            while (input.hasNext()) {
                String[] line = input.nextLine().split("-");
                Utility.employeesContainer.add(Manager.manager = new Manager(
                    line[0].strip(),
                    line[1].strip(),
                    line[2].strip(),
                    Double.parseDouble(line[3].strip())
                ));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    ///////////////////////////////////////////////////////////////////////////
    public static void loadOrdersQueue(MissionEmployee e) {
        try (Scanner input = new Scanner(new File(String.format("DataBaseFiles\\MEQueue%s.txt", e.getId())))) {
            while (input.hasNext()) {
                Order order;
                String[] line = input.nextLine().split("-");
                if (line.length == 11) {
                    order = new NewFilterOrder(
                        Integer.parseInt(line[9].strip()),
                        line[1].strip(),
                        line[2].strip(),
                        line[3].strip(),
                        line[4].strip(),
                        line[5].strip(),
                        line[6].strip().equals("Gravity Filter") ? new GravityFilter() : new StagesFilter()
                    );
                    order.setStatus(line[10].strip().equals("1") ? true : false);
                    e.ordersQueue.add(order);
                } else {
                    order = new AfterSaleOrder(
                        line[1].strip(),
                        line[2].strip(),
                        line[3].strip(),
                        line[4].strip(),
                        line[5].strip(),
                        line[6].strip()
                    );
                    order.setStatus(line[7].equals("1") ? true : false);
                    e.ordersQueue.add(order);
                }
            }
        } catch (Exception exception) {
        }
    }

    public static void loadOrdersQueue() {
        for (var employee : Utility.employeesContainer) {
            if (employee instanceof MissionEmployee) {
                loadOrdersQueue((MissionEmployee) employee);
            }
        }
    }

    public static void loadOrdersHistory(MissionEmployee e) {
        try (Scanner input = new Scanner(new File(String.format("DataBaseFiles\\MEHistory%s.txt", e.getId())))) {
            while (input.hasNext()) {
                Order order;
                String[] line = input.nextLine().split("-");
                if (line.length == 11) {
                    order = new NewFilterOrder(
                        Integer.parseInt(line[9].strip()),
                        line[1].strip(),
                        line[2].strip(),
                        line[3].strip(),
                        line[4].strip(),
                        line[5].strip(),
                        line[6].strip().equals("Gravity Filter") ? new GravityFilter() : new StagesFilter()
                    );
                    order.setStatus(line[10].strip().equals("1") ? true : false);
                    e.ordersHistory.add(order);
                } else {
                    order = new AfterSaleOrder(
                        line[1].strip(),
                        line[2].strip(),
                        line[3].strip(),
                        line[4].strip(),
                        line[5].strip(),
                        line[6].strip()
                    );
                    order.setStatus(line[7].strip().equals("1") ? true : false);
                    e.ordersHistory.add(order);
                }
            }
        } catch (Exception exception) {
        }
    }

    public static void loadOrdersHistory(OrdersEmployee e) {
        try (Scanner input = new Scanner(new File(String.format("DataBaseFiles\\OEHistory%s.txt", e.getId())))) {
            while (input.hasNext()) {
                Order order;
                String[] line = input.nextLine().split("-");
                if (line.length == 11) {
                    order = new NewFilterOrder(
                        Integer.parseInt(line[9].strip()),
                        line[1].strip(),
                        line[2].strip(),
                        line[3].strip(),
                        line[4].strip(),
                        line[5].strip(),
                        line[6].strip().equals("Gravity Filter") ? new GravityFilter() : new StagesFilter()
                    );
                    order.setStatus(line[10].strip().equals("1") ? true : false);
                    e.ordersHistory.add(order);
                } else {
                    order = new AfterSaleOrder(
                        line[1].strip(),
                        line[2].strip(),
                        line[3].strip(),
                        line[4].strip(),
                        line[5].strip(),
                        line[6].strip()
                    );
                    order.setStatus(line[7].strip().equals("1") ? true : false);
                    e.ordersHistory.add(order);
                }
            }
        } catch (Exception exception) {
        }
    }

    public static void loadOrdersHistory() {
        for (var employee : Utility.employeesContainer) {
            if (employee instanceof MissionEmployee) {
                loadOrdersHistory((MissionEmployee) employee);
            } else if (employee instanceof  OrdersEmployee) {
                loadOrdersHistory((OrdersEmployee) employee);
            }
        }
    }

    public static void loadIds() {
        for (var employee : Utility.employeesContainer) {
            Utility.idChecker.add(employee.getId());
        }
    }

    public static void loadFilters() {
        try (Scanner input = new Scanner(new File("DataBaseFiles\\Filters.txt"))) {
            while (input.hasNext()) {
                String[] line = input.nextLine().split("-");
                if (line[0].strip().equals("Gravity Filter")) {
                    GravityFilter.gravityFiltersAvailable.add(new GravityFilter(
                        line[1].strip(),
                        line[2].strip(),
                        Double.parseDouble(line[3].strip()),
                        Double.parseDouble(line[4].strip()),
                        line[5].strip().equals("YES") ? true : false,
                        Double.parseDouble(line[6].strip())
                    ));
                } else if (line[0].strip().equals("Stages Filter")) {
                    StagesFilter.stagesFiltersAvailable.add(new StagesFilter(
                        line[1].strip(),
                        line[2].strip(),
                        Double.parseDouble(line[3].strip()),
                        Double.parseDouble(line[4].strip()),
                        Integer.parseInt(line[5].strip())
                    ));
                }
            }
        } catch (Exception exception) {
            System.out.printf("%s\n", exception);
        }
    }
    ///////////////////////////////////////////////////////////////////////////
    public static String formatMissionEmployee(MissionEmployee e) {
        return String.format(
            "%-20s - %-5s - %-11s - %-10s",
            e.getName(),
            e.getId(),
            e.getPersonalPhoneNumber(),
            String.valueOf(e.getSalaryPerMission())
        );
    }

    public static void storeMissionEmployees() {
        try (PrintWriter print = new PrintWriter("DataBaseFiles\\MissionEmployees.txt")) {
            for (var employee : Utility.employeesContainer) {
                if (employee instanceof MissionEmployee) {
                    print.println(formatMissionEmployee((MissionEmployee) employee));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static String formatOrdersEmployee(OrdersEmployee e) {
        return String.format(
            "%-20s - %-5s - %-11s - %-10s - %-10s - %-10s",
            e.getName(),
            e.getId(),
            e.getPersonalPhoneNumber(),
            String.valueOf(e.getSalary()),
            e.getOfficeRoomNumber(),
            e.getOfficeRoomNumber()
        );
    }

    public static void storeOrdersEmployees() {
        try (PrintWriter print = new PrintWriter("DataBaseFiles\\OrdersEmployees.txt")) {
            for (var employee : Utility.employeesContainer) {
                if (employee instanceof OrdersEmployee) {
                    print.println(formatOrdersEmployee((OrdersEmployee) employee));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static String formatManager(Manager e) {
        return String.format(
            "%-20s - %-5s - %-11s - %-10s",
            e.getName(),
            e.getId(),
            e.getPersonalPhoneNumber(),
            String.valueOf(e.getSalary())
        );
    }

    public static void storeManager() {
        try (PrintWriter print = new PrintWriter("DataBaseFiles\\Manager.txt")) {
            print.println(formatManager(Manager.manager));
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static String formatNewFilterOrder(NewFilterOrder e) {
        return String.format(
            "%-16s - %-11s - %-12s - %-20s - %-5s - %-5s - %-14s - %-12s - %-5s - %-6s - %-1s",
            e.getOrderType(),
            e.getClientPhoneNumber(),
            e.getClientAddress(),
            e.getClientLocationLink(),
            e.getOrderEmployeeId(),
            e.getMissionEmployeeId(),
            e.getFilter().type(),
            e.getFilter().manufacturer(),
            e.getFilter().model(),
            String.valueOf(e.getAmount()),
            e.getStatus() == true ? "1" : "0"
        );
    }

    public static String formatAfterSaleOrder(AfterSaleOrder e) {
        return String.format(
            "%-16s - %-11s - %-12s - %-20s - %-5s - %-5s - %-50s - %-1s",
            e.getOrderType(),
            e.getClientPhoneNumber(),
            e.getClientAddress(),
            e.getClientLocationLink(),
            e.getOrderEmployeeId(),
            e.getMissionEmployeeId(),
            e.getOrderDescription(),
            e.getStatus() == true ? "1" : "0"
        );
    }

    public static void storeOrdersHistory(MissionEmployee e) {
        try (PrintWriter print = new PrintWriter(String.format("DataBaseFiles\\MEHistory%s.txt", e.getId()))) {
            for (var order : e.ordersHistory) {
                if (order instanceof NewFilterOrder) {
                    print.println(formatNewFilterOrder((NewFilterOrder) order));
                } else if (order instanceof AfterSaleOrder) {
                    print.println(formatAfterSaleOrder((AfterSaleOrder) order));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void storeOrdersHistory(OrdersEmployee e) {
        try (PrintWriter print = new PrintWriter(String.format("DataBaseFiles\\OEHistory%s.txt", e.getId()))) {
            for (var order : e.ordersHistory) {
                if (order instanceof NewFilterOrder) {
                    print.println(formatNewFilterOrder((NewFilterOrder) order));
                } else if (order instanceof AfterSaleOrder) {
                    print.println(formatAfterSaleOrder((AfterSaleOrder) order));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void storeOrdersHistory() {
        for (var employee : Utility.employeesContainer) {
            if (employee instanceof MissionEmployee) {
                storeOrdersHistory((MissionEmployee) employee);
            } else if (employee instanceof OrdersEmployee) {
                storeOrdersHistory((OrdersEmployee) employee);
            }
        }
    }

    public static void storeOrdersQueue(MissionEmployee e) {
        try (PrintWriter print = new PrintWriter(String.format("DataBaseFiles\\MEQueue%s.txt", e.getId()))) {
            for (var order : e.ordersQueue) {
                if (order instanceof NewFilterOrder) {
                    print.println(formatNewFilterOrder((NewFilterOrder) order));
                } else if (order instanceof AfterSaleOrder) {
                    print.println(formatAfterSaleOrder((AfterSaleOrder) order));
                }
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void storeOrdersQueue() {
        for (var employee : Utility.employeesContainer) {
            if (employee instanceof MissionEmployee) {
                storeOrdersQueue((MissionEmployee) employee);
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////
}
