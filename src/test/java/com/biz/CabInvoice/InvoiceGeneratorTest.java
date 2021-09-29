package com.biz.CabInvoice;
import com.biz.CabInvoice.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;
public class InvoiceGeneratorTest {
    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void distance_Time_ReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double total_fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, total_fare, 0.0);
    }
    @Test
    public void shorterDistanceAndTime_ReturnsMinFare() {

        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void multipleRides_ReturnInvoice() {

        CabRides[] rides = {new CabRides(5.0, 2),
                new CabRides(0.1, 1)};
        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(57, totalFare, 0.0);
    }
    @Test
    public void multipleRides_ReturnInvoiceSummary() {

        CabRides[] rides = {new CabRides(5.0, 5),
                new CabRides(0.1, 1)};
        CabSummary actualsummary = invoiceGenerator.calculateFareReturnSummary(rides);
        CabSummary expectedSummary = new CabSummary(2, 60);
        if(expectedSummary.getAverageFare() == actualsummary.getAverageFare() && expectedSummary.getNumberOfRides() == actualsummary.getNumberOfRides() && expectedSummary.getTotalFare() == actualsummary.getTotalFare())
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(1,0);
    }
}
