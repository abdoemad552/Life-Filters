package Filters;

public interface Filter {
    String type();
    String manufacturer();
    String model();
    double capacityInLiters();
    double filtrationPercentage();
}