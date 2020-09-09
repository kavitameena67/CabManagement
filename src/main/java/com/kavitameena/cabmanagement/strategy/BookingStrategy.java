package com.kavitameena.cabmanagement.strategy;

import com.kavitameena.cabmanagement.database.CabDAL;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.City;
import com.kavitameena.cabmanagement.model.Rider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.PriorityQueue;

// 1. Available cab with Max Idle time will be assigned
// 2. If 2 available cabs has same idle time then any one of them will be assigned
@Component
public class BookingStrategy {

    PriorityQueue<Cab> minHeap = new PriorityQueue<>((a, b) -> (int) (a.getLastTripTime() - b.getLastTripTime()));

    public Cab findCab(List<Cab> cabs) {

        minHeap.addAll(cabs);

        Cab cabAssigned = null;
        if (!minHeap.isEmpty()) {
            cabAssigned = minHeap.poll();
        }
        return cabAssigned;
    }

}
