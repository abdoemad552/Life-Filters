package Orders;

import Employees.*;
import Filters.*;
import MainPackage.Utility;
import Orders.*;
import java.io.*;
import java.util.*;

public class AfterSaleOrder extends Order {
    private String orderDescription;

    { orderType = "After sale order"; }

    public AfterSaleOrder(
            String clientPhoneNumber,
            String clientAddress,
            String clientLocationLink,
            String orderEmployeeId,
            String missionEmployeeId,
            String orderDescription
    ) {
        super(clientPhoneNumber, clientAddress, clientLocationLink, orderEmployeeId, missionEmployeeId);
        this.orderDescription = orderDescription;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    @Override
    public String toString() {
        return Utility.afterSaleOrderHeader + "\n" +
               Utility.formatAfterSaleOrder(this);
//        return  String.format(
//                "+-----------------------------------------------------------------------------------------------------------------------------------------------+\n" +
//                "|                                                                        ORDER                                                                  |\n" +
//                "+------------------+-------------+--------------+----------------------+-------+-------+----------------------------------------------------+---+\n" +
//                "| %-16s | %-11s | %-12s | %-20s | %-5s | %-5s | %-50s | %1s |" + "\n" +
//                "+------------------+-------------+--------------+----------------------+-------+-------+----------------------------------------------------+---+\n" +
//                "| %-16s | %-11s | %-12s | %-20s | %-5s | %-5s | %-50s | %1s |",
//                "Type", "Client PNo.", "Client Add.", "Client Loc.", "OE ID", "ME ID", "Description", "S",
//                orderType,
//                clientPhoneNumber,
//                clientAddress,
//                clientLocationLink,
//                orderEmployeeId,
//                missionEmployeeId,
//                orderDescription,
//                status == true ? "1" : "0"
//                ) + "\n" +
//                "+------------------+-------------+--------------+----------------------+-------+-------+----------------------------------------------------+---+";
    }
}
