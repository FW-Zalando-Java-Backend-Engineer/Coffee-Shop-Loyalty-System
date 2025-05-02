package com.example.coffeeshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DailyVisitLogTest {

    @Test
    void testAddVisitAndReset() {
        DailyVisitLog log = new DailyVisitLog();
        assertTrue(log.addVisit("Alice"));
        assertFalse(log.addVisit("Alice")); // duplicate

        assertTrue(log.hasVisited("Alice"));
        assertFalse(log.hasVisited("Bob"));

        log.resetLog();
        assertFalse(log.hasVisited("Alice")); // should be reset
    }
}
