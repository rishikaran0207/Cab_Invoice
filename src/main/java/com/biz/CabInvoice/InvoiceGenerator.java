package com.biz.CabInvoice;
import java.util.ArrayList;
import java.util.Locale;
public class InvoiceGenerator {
    private static final double Minimum_Per_Kilometer = 10;
    private static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final int Cost_Per_Hour = 1;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double Minimum_Pay = 5;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    public double calculateFare(double distance, int time, String user) {
        double totalFare = 0.0;
        if (user.equalsIgnoreCase("normal")) {
            totalFare = distance * Minimum_Per_Kilometer + time * Cost_Per_Hour;
            if (totalFare < Minimum_Pay)
                return Minimum_Pay;
        }
        if (user.equalsIgnoreCase("premium")) {
            totalFare = distance * PREMIUM_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
            if (totalFare < Minimum_Pay)
                return PREMIUM_MINIMUM_FARE;
        }
        return totalFare;
    }
    public double calculateFare(CabRides[] rides) {

        double totalFare = 0;
        for (CabRides ride : rides) {
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time, ride.user);
        }
        return totalFare;
    }
    public Invoice_List calculateFareReturnSummary(ArrayList<CabRides> rides) {

        double totalFare = 0;
        for (CabRides ride : rides) {
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time, ride.user);
        }
        return new Invoice_List(rides.size(), totalFare);
    }
}
