package Orders;

import Employees.*;
import Filters.*;
import MainPackage.Utility;
import Orders.*;
import java.io.*;
import java.util.*;

public class NewFilterOrder extends Order {
    private int amount;
    private Filter filter;

    { orderType = "New filter order"; }

    public NewFilterOrder(
            int amount,
            String clientPhoneNumber,
            String clientAddress,
            String clientLocationLink,
            String orderEmployeeId,
            String missionEmployeeId,
            Filter filter
    ) {
        super(
            clientPhoneNumber,
            clientAddress,
            clientLocationLink,
            orderEmployeeId,
            missionEmployeeId
        );
        this.amount = amount;
        this.filter = filter;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return Utility.newFilterOrderHeader + "\n" +
               Utility.formatNewFilterOrder(this);
    }
}
