package com.example.coffeeshop;

import java.util.HashSet;
import java.util.Set;

public class DailyVisitLog {
    private Set<String> visitedToday = new HashSet<>();

    public boolean addVisit(String customerName) {
        return visitedToday.add(customerName);
    }

    public void resetLog() {
        visitedToday.clear();
    }

    public boolean hasVisited(String customerName) {
        return visitedToday.contains(customerName);
    }
}
