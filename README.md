## 📁 Project Structure

```
coffee-shop-loyalty/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/example/coffeeshop/
    │           ├── CustomerVisitTracker.java
    │           ├── DailyVisitLog.java
    │           └── RewardProcessor.java
    └── test/
        └── java/
            └── com/example/coffeeshop/
                ├── CustomerVisitTrackerTest.java
                ├── DailyVisitLogTest.java
                └── RewardProcessorTest.java
```

---

## 📦 `pom.xml` (Maven Setup)

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>coffee-shop-loyalty</artifactId>
  <version>1.0-SNAPSHOT</version>
  <dependencies>
    <!-- JUnit 5 -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.9.3</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <!-- Enable JUnit 5 platform -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M7</version>
      </plugin>
    </plugins>
  </build>
</project>
```

---

## ☕ `CustomerVisitTracker.java`

```java
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
```

---

## 📃 `DailyVisitLog.java`

```java
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
```

---

## 🎁 `RewardProcessor.java`

```java
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
```

---

## ✅ JUnit 5 Tests

---

### `CustomerVisitTrackerTest.java`

```java
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
```

---

### `DailyVisitLogTest.java`

```java
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
```

---

### `RewardProcessorTest.java`

```java
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
```

---

## 🚀 Example Main Flow (Optional Teaching Demo)

If you want to show a full simulated flow:

```java
public class CoffeeLoyaltyApp {
    public static void main(String[] args) {
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
```

---
