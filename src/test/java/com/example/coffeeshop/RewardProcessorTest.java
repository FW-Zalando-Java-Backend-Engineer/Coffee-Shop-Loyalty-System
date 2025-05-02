package com.example.coffeeshop;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class RewardProcessorTest {

    @Test
    void testRewardEligibility() {
        RewardProcessor processor = new RewardProcessor(3);
        Map<String, Integer> visits = new HashMap<>();
        visits.put("Alice", 5);
        visits.put("Bob", 2);
        visits.put("Charlie", 3);

        List<String> eligible = processor.getEligibleCustomers(visits);

        assertTrue(eligible.contains("Alice"));
        assertTrue(eligible.contains("Charlie"));
        assertFalse(eligible.contains("Bob"));
        assertEquals(2, eligible.size());
    }
}
