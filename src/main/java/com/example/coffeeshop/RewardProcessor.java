package com.example.coffeeshop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RewardProcessor {
    private final int threshold;

    public RewardProcessor(int threshold) {
        this.threshold = threshold;
    }

    public List<String> getEligibleCustomers(Map<String, Integer> visitMap) {
        List<String> rewardEligible = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = visitMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() >= threshold) {
                rewardEligible.add(entry.getKey());
            }
        }

        return rewardEligible;
    }
}
