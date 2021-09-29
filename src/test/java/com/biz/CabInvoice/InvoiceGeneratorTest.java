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
}
