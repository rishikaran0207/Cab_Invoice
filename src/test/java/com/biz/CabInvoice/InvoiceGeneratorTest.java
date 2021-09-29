package com.biz.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class InvoiceGeneratorTest {
    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void distance_Time_ReturnTotalFareForNormal_User() {
        double distance = 2.0;
        int time = 5;
        String user = "Normal";
        double total_fare = invoiceGenerator.calculateFare(distance, time, user);
        Assert.assertEquals(25, total_fare, 0.0);
    }
    @Test
    public void shorterDistanceAndTime_ReturnsMinFareForNormal_User() {

        double distance = 0.1;
        int time = 1;
        String user = "Normal";
        double fare = invoiceGenerator.calculateFare(distance, time, user);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void multipleRides_ReturnInvoiceForNormal_User() {
        String user = "Normal";
        CabRides[] rides = {new CabRides(5.0, 2, user),
                new CabRides(0.1, 1, user)};
        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(57, totalFare, 0.0);
    }
    @Test
    public void multipleRides_ReturnInvoiceSummaryForNormal_User() {

        String user = "Normal";
        CabRides[] rides = {new CabRides(5.0, 5, user),
                new CabRides(0.1, 1, user)};
        CabSummary actualsummary = invoiceGenerator.calculateFareReturnSummary(rides);
        CabSummary expectedSummary = new CabSummary(2, 60);
        if(expectedSummary.getAverageFare() == actualsummary.getAverageFare() && expectedSummary.getNumberOfRides() == actualsummary.getNumberOfRides() && expectedSummary.getTotalFare() == actualsummary.getTotalFare())
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(1,0);
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFareForPremium_User() {
        double distance = 2.0;
        int time = 5;
        String user = "Premium";
        double total_fare = invoiceGenerator.calculateFare(distance, time, user);
        Assert.assertEquals(40, total_fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_Should_then_ReturnMinFareForPremium_User() {

        double distance = 0.1;
        int time = 1;
        String user = "Premium";
        double fare = invoiceGenerator.calculateFare(distance, time, user);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_Should_then_ReturnInvoiceSummaryForPremium_User() {

        String user = "Premium";
        CabRides[] rides = {new CabRides(5.0, 2, user),
                new CabRides(0.1, 1, user)};
        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(99, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryForPremium_User() {

        String user = "Premium";
        CabRides[] rides = {new CabRides(5.0, 5, user),
                new CabRides(0.1, 1, user)};
        CabSummary actualsummary = invoiceGenerator.calculateFareReturnSummary(rides);
        CabSummary expectedSummary = new CabSummary(2, 105);
        if (expectedSummary.getAverageFare() == actualsummary.getAverageFare() && expectedSummary.getNumberOfRides() == actualsummary.getNumberOfRides() && expectedSummary.getTotalFare() == actualsummary.getTotalFare())
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(1, 0);
    }

    @Test
    public void givenUserId_Should_then_ReturnInvoiceSummary_ListForPremium_User() {

        String user = "Premium";
        String userId = "1";
        Invoice_List invoicelist = new Invoice_List();

        ArrayList<CabRides> rides = new ArrayList<CabRides>();
        rides.add(new CabRides(5.0, 5, user));
        rides.add(new CabRides(0.1, 1, user));

        invoicelist.addRides(userId, rides);
        ArrayList<CabRides> listOfRides = invoicelist.getRides(userId);

        CabSummary summaryForUser1 = invoiceGenerator.calculateFareReturnSummary(listOfRides);
        CabSummary expectedSummary = new CabSummary(2, 105);
        if (expectedSummary.getAverageFare() == summaryForUser1.getAverageFare() && expectedSummary.getNumberOfRides() == summaryForUser1.getNumberOfRides() && expectedSummary.getTotalFare() == summaryForUser1.getTotalFare())
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(1, 0);
    }
}
