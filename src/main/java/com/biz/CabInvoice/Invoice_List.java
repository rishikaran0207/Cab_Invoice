package com.biz.CabInvoice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Invoice_List {
    Map<String, ArrayList<CabRides>> RideMap;

    public Invoice_List() {
        this.RideMap = new HashMap<>();
    }

    public void addRides(String id, ArrayList<CabRides> rides) {
        if (id != null)
            RideMap.put(id, rides);
    }

    public ArrayList<CabRides> getRides(String id) {
        if (RideMap.containsKey(id))
            return RideMap.get(id);
        else
            return null;
    }

}
