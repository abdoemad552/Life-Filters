package MainPackage;
import Employees.*;
import Filters.*;
import Orders.*;
import java.io.*;
import java.util.*;

public class Utility {
    public static ArrayList<Employee> employeesContainer = new ArrayList<>();
    public static Set<String> idChecker = new HashSet<>();

    public static Employee getById(String id) {
        for (Employee e : employeesContainer) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public static boolean isValidId(String id) {
        if (
            id.length() == 5 &&
            id.charAt(0) >= '0' && id.charAt(0) <= '9' &&
            id.charAt(1) >= '0' && id.charAt(1) <= '9' &&
            id.charAt(2) >= '0' && id.charAt(2) <= '9' &&
            id.charAt(3) >= '0' && id.charAt(3) <= '9' &&
            id.charAt(4) >= '0' && id.charAt(4) <= '9'
        ) {
            return true;
        } else {
            return false;
        }
    }

    public static String getNewId() {
        String id;
        while (true) {
            id = Utility.Input.next();
            if (isValidId(id)) {
                if (idChecker.contains(id)) {
                    System.out.printf("Duplicate ID. Try again: ");
                } else {
                    idChecker.add(id);
                    return id;
                }
            } else {
                System.out.printf("Invalid ID format. Try again: ");
            }
        }
    }

    public class Input {
        private static Scanner input = new Scanner(System.in);

        public static String next() {
            String next = input.next().strip();
            input.nextLine();
            return next;
        }

        public static String nextLine() {
            return input.nextLine().strip();
        }

        public static int nextInt() {
            int nextInt = input.nextInt();
            input.nextLine();
            return nextInt;
        }

        public static double nextDouble() {
            double nextDouble = input.nextDouble();
            input.nextLine();
            return nextDouble;
        }
    }

    public static final String ordersEmployeeHeader = String.format(
        "+----------------------------------------------------------------------------+\n" +
        "|                              ORDERS EMPLOYEE                               |\n" +
        "+----------------------+-------+-------------+------------+-----+------------+\n" +
        "| %-20s | %-5s | %-11s | %-10s | %-3s | %-10s |" + "\n" +
        "+----------------------+-------+-------------+------------+-----+------------+",
        "Name", "ID", "Phone No.", "Salary", "ORN", "OPN"
    );
    public static final String missionEmployeeHeader = String.format(
        "+-----------------------------------------------------------------------------------+\n" +
        "|                                 MISSION EMPLOYEE                                  |\n" +
        "+----------------------+-------+-------------+------------+------------+------------+\n" +
        "| %-20s | %-5s | %-11s | %-10s | %-10s | %-10s |" + "\n" +
        "+----------------------+-------+-------------+------------+------------+------------+",
        "Name", "ID", "Phone No.", "M.Required", "M.Done", "SPM"
    );
    public static final String afterSaleOrderHeader = String.format(
        "+-----------------------------------------------------------------------------------------------------------------------------------------------+\n" +
        "|                                                                        ORDER                                                                  |\n" +
        "+------------------+-------------+--------------+----------------------+-------+-------+----------------------------------------------------+---+\n" +
        "| %-16s | %-11s | %-12s | %-20s | %-5s | %-5s | %-50s | %1s |\n" +
        "+------------------+-------------+--------------+----------------------+-------+-------+----------------------------------------------------+---+",
        "Type", "Client PNo.", "Client Add.", "Client Loc.", "OE ID", "ME ID", "Description", "S"
    );
    public static final String newFilterOrderHeader = String.format(
        "+-------------------------------------------------------------------------------------------------------------------------------------------+\n" +
        "|                                                                      ORDER                                                                |\n" +
        "+------------------+-------------+--------------+----------------------+-------+-------+----------------+--------------+-------+--------+---+\n" +
        "| %-16s | %-11s | %-12s | %-20s | %-5s | %-5s | %-14s | %-12s | %-5s | %-6s | %-1s |" + "\n" +
        "+------------------+-------------+--------------+----------------------+-------+-------+----------------+--------------+-------+--------+---+",
        "Type", "Client PNo.", "Client Add.", "Client Loc.", "OE ID", "ME ID", "Filter type", "Manufacturer", "Model", "Amount", "S"
    );
    public static final String gravityFilterHeader = String.format(
        "+------------------------------------------------------------------------------------+\n" +
        "|                                   GRAVITY FILTER                                   |\n" +
        "+--------------------------------+-------+------------+-------+----------+-----------+\n" +
        "| %-30s | %-5s | %-10s | %-5s | %-8s | %-9s |\n" +
        "+--------------------------------+-------+------------+-------+----------+-----------+",
        "Manufacturer", "Model", "Capacity", "F %", "Portable", "Flow Rate"
    );
    public static final String stagesFilterHeader = String.format(
        "+----------------------------------------------------------------------+\n" +
        "|                             STAGES FILTER                            |\n" +
        "+--------------------------------+-------+------------+-------+--------+\n" +
        "| %-30s | %-5s | %-10s | %-5s | %-6s |\n" +
        "+--------------------------------+-------+------------+-------+--------+",
        "Manufacturer", "Model", "Capacity", "F %", "Stages"
    );

    public static final String formatOrdersEmployee(OrdersEmployee e) {
        return String.format(
            "| %-20s | %-5s | %-11s | %-10s | %-3s | %-10s |" + "\n" +
            "+----------------------+-------+-------------+------------+-----+------------+",
            e.getName(),
            e.getId(),
            e.getPersonalPhoneNumber(),
            String.valueOf(e.getSalary()),
            e.getOfficeRoomNumber(),
            e.getOfficePhoneNumber()
        );
    }
    public static final String formatMissionEmployee(MissionEmployee e) {
        return String.format(
            "| %-20s | %-5s | %-11s | %-10s | %-10s | %-10s |" + "\n" +
            "+----------------------+-------+-------------+------------+------------+------------+",
            e.getName(),
            e.getId(),
            e.getPersonalPhoneNumber(),
            String.valueOf(e.getNumberOfAvailableMissions()),
            String.valueOf(e.getNumberOfPerformedMissions()),
            String.valueOf(e.getSalaryPerMission())
        );
    }
    public static final String formatAfterSaleOrder(AfterSaleOrder e) {
        return String.format(
            "| %-16s | %-11s | %-12s | %-20s | %-5s | %-5s | %-50s | %1s |\n" +
            "+------------------+-------------+--------------+----------------------+-------+-------+----------------------------------------------------+---+",
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
    public static final String formatNewFilterOrder(NewFilterOrder e) {
        return String.format(
            "| %-16s | %-11s | %-12s | %-20s | %-5s | %-5s | %-14s | %-12s | %-5s | %-6s | %-1s |\n" +
            "+------------------+-------------+--------------+----------------------+-------+-------+----------------+--------------+-------+--------+---+",
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
    public static final String formatGravityFilter(GravityFilter e) {
        return String.format(
            "| %-30s | %-5s | %-10s | %-5s | %-8s | %-9s |\n" +
            "+--------------------------------+-------+------------+-------+----------+-----------+",
            e.manufacturer(),
            e.model(),
            e.capacityInLiters() + " L",
            e.filtrationPercentage() * 100,
            e.portable() == true ? "YES" : "NO",
            e.flowRateLitersPerHour() + " L/H"
        );
    }
    public static final String formatStagesFilter(StagesFilter e) {
        return String.format(
            "| %-30s | %-5s | %-10s | %-5s | %-6s |\n" +
            "+--------------------------------+-------+------------+-------+--------+",
            e.manufacturer(),
            e.model(),
            e.capacityInLiters() + " L",
            e.filtrationPercentage() * 100,
            e.numberOfStages()
        );
    }
}
