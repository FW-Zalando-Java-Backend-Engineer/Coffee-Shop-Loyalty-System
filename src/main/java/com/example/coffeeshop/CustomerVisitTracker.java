package com.example.coffeeshop;

import java.util.HashMap;
import java.util.Map;

public class CustomerVisitTracker {
    private Map<String, Integer> visitMap = new HashMap<>();

    public void logVisit(String customerName) {
        visitMap.put(customerName, visitMap.getOrDefault(customerName, 0) + 1);
    }

    public int getVisitCount(String customerName) {
        return visitMap.getOrDefault(customerName, 0);
    }

    public Map<String, Integer> getAllVisits() {
        return visitMap;
    }
}
