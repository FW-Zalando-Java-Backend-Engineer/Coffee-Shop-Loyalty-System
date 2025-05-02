package com.example;


import com.example.coffeeshop.CustomerVisitTracker;
import com.example.coffeeshop.DailyVisitLog;
import com.example.coffeeshop.RewardProcessor;

public class CoffeeLoyaltyApp
{
    public static void main( String[] args )
    {

        CustomerVisitTracker tracker = new CustomerVisitTracker();
        DailyVisitLog dailyLog = new DailyVisitLog();
        RewardProcessor processor = new RewardProcessor(3);

        String[] customers = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Charlie"};

        for (String name : customers) {
            if (dailyLog.addVisit(name)) {
                tracker.logVisit(name);
            }
        }

        System.out.println("Reward-eligible customers: " +
                processor.getEligibleCustomers(tracker.getAllVisits()));
    }
}
