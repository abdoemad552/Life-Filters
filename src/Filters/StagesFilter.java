package Filters;
import Employees.*;
import Filters.*;
import MainPackage.Utility;
import Orders.*;
import java.io.*;
import java.util.*;

public class StagesFilter implements Filter {
    private final String type;
    private final String manufacturer;
    private final String model;
    private final double capacityInLiters;
    private final double filtrationPercentage;
    private final int numberOfStages;

    public static ArrayList<StagesFilter> stagesFiltersAvailable;

    { type = "Stages Filter"; }
    static {
        stagesFiltersAvailable = new ArrayList<>() {
            @Override
            public String toString() {
                StringBuilder table = new StringBuilder(Utility.stagesFilterHeader);
                for (var e : stagesFiltersAvailable) {
                    table.append("\n" + Utility.formatStagesFilter(e));
                }
                return table.toString();
            }
        };
    }

    public StagesFilter() {
        this.manufacturer = "TANK";
        this.model = "A";
        this.capacityInLiters = 10;
        this.filtrationPercentage = 0.3;
        this.numberOfStages = 3;
    }

    public StagesFilter(StagesFilter e) {
        this(
            e.manufacturer(),
            e.model(),
            e.capacityInLiters(),
            e.filtrationPercentage(),
            e.numberOfStages()
        );
    }

    public StagesFilter(
            String  manufacturer,
            String  model,
            double  capacityInLiters,
            double  filtrationPercentage,
            int     numberOfStages
    ) {
        this.manufacturer           = manufacturer;
        this.model                  = model;
        this.capacityInLiters       = capacityInLiters;
        this.filtrationPercentage   = filtrationPercentage;
        this.numberOfStages         = numberOfStages;
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

    public int numberOfStages() {
        return numberOfStages;
    }

    @Override
    public String toString() {
        return Utility.stagesFilterHeader + "\n" +
               Utility.formatStagesFilter(this);
    }
}
