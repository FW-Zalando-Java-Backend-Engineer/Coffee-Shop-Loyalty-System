package com.example.coffeeshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerVisitTrackerTest {

    @Test
    void testLogVisit() {
        CustomerVisitTracker tracker = new CustomerVisitTracker();
        tracker.logVisit("Alice");
        tracker.logVisit("Alice");
        tracker.logVisit("Bob");

        assertEquals(2, tracker.getVisitCount("Alice"));
        assertEquals(1, tracker.getVisitCount("Bob"));
        assertEquals(0, tracker.getVisitCount("Charlie"));
    }
}
