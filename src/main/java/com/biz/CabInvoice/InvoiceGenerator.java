package com.biz.CabInvoice;

public class InvoiceGenerator {
    private static final double Minimum_Per_Kilometer = 10;
    private static final int Cost_Per_Hour = 1;
    private static final double Minimum_Pay = 5;

    public double calculateFare(double distance, int time) {

        double totalFare = distance * Minimum_Per_Kilometer + time * Cost_Per_Hour;
        if (totalFare < Minimum_Pay)
            return Minimum_Pay;
        return totalFare;
    }
    public double calculateFare(CabRides[] rides) {

        double totalFare = 0;
        for (CabRides ride : rides) {
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
