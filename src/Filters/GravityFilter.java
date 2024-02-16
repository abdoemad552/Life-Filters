package Filters;
import Employees.*;
import Filters.*;
import MainPackage.Utility;
import Orders.*;
import java.io.*;
import java.util.*;

public class GravityFilter implements Filter {
    private final String  type;
    private final String  manufacturer;
    private final String  model;
    private final double  capacityInLiters;
    private final double  filtrationPercentage;
    private final boolean portable;
    private final double  flowRateLitersPerHour;

    public static ArrayList<GravityFilter> gravityFiltersAvailable;

    { type = "Gravity Filter"; }
    static {
        gravityFiltersAvailable = new ArrayList<>() {
            @Override
            public String toString() {
                StringBuilder table = new StringBuilder(Utility.gravityFilterHeader);
                for (var e : gravityFiltersAvailable) {
                    table.append("\n" + Utility.formatGravityFilter(e));
                }
                return table.toString();
            }
        };
    }

    public GravityFilter() {
        manufacturer = "AQUACERA";
        model = "B";
        capacityInLiters = 5;
        filtrationPercentage = 0.6;
        portable = true;
        flowRateLitersPerHour = 1;
    }

    public GravityFilter(GravityFilter e) {
        this(
            e.manufacturer,
            e.model,
            e.capacityInLiters,
            e.filtrationPercentage,
            e.portable,
            e.flowRateLitersPerHour
        );
    }

    public GravityFilter(
            String  manufacturer,
            String  model,
            double  capacityInLiters,
            double  filtrationPercentage,
            boolean portable,
            double  flowRateLitersPerHour
    ) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacityInLiters = capacityInLiters;
        this.filtrationPercentage = filtrationPercentage;
        this.portable = portable;
        this.flowRateLitersPerHour = flowRateLitersPerHour;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public String manufacturer() {
        return manufacturer;
    }

    @Override
    public String model() {
        return model;
    }

    @Override
    public double capacityInLiters() {
        return capacityInLiters;
    }

    @Override
    public double filtrationPercentage() {
        return filtrationPercentage;
    }

    public boolean portable() {
        return portable;
    }

    public double flowRateLitersPerHour() {
        return flowRateLitersPerHour;
    }


    @Override
    public String toString() {
        return Utility.gravityFilterHeader + "\n" +
               Utility.formatGravityFilter(this);
    }
}
