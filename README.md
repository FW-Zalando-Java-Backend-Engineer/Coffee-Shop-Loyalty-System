# 🎓 Assignment: **Coffee Shop Loyalty System**

## ☕️ Theme: Real-World Café Loyalty Program

Imagine you're building the backend system for a small coffee shop's **loyalty rewards program**. The café wants to:

1. Keep track of each **customer’s total orders**.
2. Prevent **duplicate visit logs** per day.
3. Display each customer’s reward-eligible visits in order using an `Iterator`.

---

## 🧠 Learning Goals

* Use a **`HashMap`** to map customers to their visit count.
* Use a **`HashSet`** to avoid logging duplicate visits for the same customer on the same day.
* Use an **`Iterator`** to process the final list of customers eligible for rewards.

---

## 🪜 Assignment Steps

### ✅ Step 1: `CustomerVisitTracker` Class

1. Declare a `HashMap<String, Integer>` where the key is the **customer name** or email, and the value is **total number of visits**.
2. Provide a method `void logVisit(String customerName)`:

   * Each call should **increase** the customer’s visit count by 1.

> 🧠 Why HashMap? To track customer data and allow fast updates and lookups.

---

### ✅ Step 2: `DailyVisitLog` Class

1. Use a `HashSet<String>` to store customers who have already visited **today**.
2. Provide a method `boolean addVisit(String customerName)`:

   * If the customer is already in the set, return `false` (indicates duplicate).
   * If not, add them and return `true`.

> 🧠 Why HashSet? To ensure a customer can't log multiple visits per day.

---

### ✅ Step 3: `RewardProcessor` Class

1. Create a method that takes in the `HashMap` of visits from `CustomerVisitTracker`.
2. Iterate through the entries using an **`Iterator<Map.Entry<String, Integer>>`**.
3. Collect customers with **5 or more visits** (e.g. loyalty reward threshold).
4. Print or return their names as eligible for free coffee.

> 🧠 Why Iterator? Practice safe, manual traversal of collections.

---

## 💼 Bonus Ideas for Ambitious Students

* Support date-based visit tracking.
* Allow resetting the daily log (`HashSet`) at midnight.
* Add a method to get a list of top N customers by visits.

---

## 📦 Deliverables

Students should submit:

* `CustomerVisitTracker.java`
* `DailyVisitLog.java`
* `RewardProcessor.java`
* A test class for each using **JUnit 5**
* A short `Main` method that simulates a day of visits and prints reward-eligible customers

---

## 🧠 Knowledge Recap

| Concept    | Use Case in Assignment                  |
| ---------- | --------------------------------------- |
| `HashMap`  | Tracking visit count per customer       |
| `HashSet`  | Preventing multiple visits per day      |
| `Iterator` | Traversing map entries for reward logic |


