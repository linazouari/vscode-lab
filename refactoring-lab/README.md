# Refactoring Lab – Java

A hands-on lab demonstrating two classic refactoring techniques in Java,
validated by a JUnit 4 test suite.

---

## Project structure

```
refactoring-lab/
├── pom.xml                          ← Maven build file (open in VS Code)
├── build.gradle                     ← Gradle build file (alternative)
└── src/
    ├── main/java/com/lab/
    │   ├── Calculator.java          ← Rename Variables/Methods example
    │   ├── Customer.java            ← Supporting model
    │   ├── Item.java                ← Supporting model
    │   ├── Order.java               ← Supporting model
    │   └── OrderProcessor.java      ← Extract Method example
    └── test/java/com/lab/
        ├── CalculatorTest.java      ← 5 tests for Calculator
        └── OrderProcessorTest.java  ← 10 tests for OrderProcessor
```

---

## Refactoring 1 – Rename Variables / Methods (`Calculator.java`)

### Before
```java
public double calc(double a, double b) {
    double x = a + b;
    double y = a * b;
    return x / y;
}
public void prtRes(double res) { ... }
```

### VS Code steps
1. Click on `calc` → press **F2** → type `calculateSumProductRatio` → Enter.
2. Click on `prtRes` → press **F2** → type `printResult` → Enter.
3. Inside the method body, rename `a`→`num1`, `b`→`num2`, `x`→`sum`, `y`→`product`.

### After
```java
public double calculateSumProductRatio(double num1, double num2) {
    double sum = num1 + num2;
    double product = num1 * num2;
    return sum / product;
}
public void printResult(double result) { ... }
```

---

## Refactoring 2 – Extract Method (`OrderProcessor.java`)

### Before
`printOrderSummary()` did everything: calculated totals, applied discounts, printed output.

### VS Code steps
1. Select the total-calculation loop → right-click → **Refactor… → Extract Method** → name it `calculateTotalPrice`.
2. Select the discount block → **Extract Method** → `applyDiscount`.
3. Select the print block → **Extract Method** → `printSummary`.
4. Inside `printSummary`, select the items loop → **Extract Method** → `printItems`.

### After
```java
public void printOrderSummary(Order order) {
    double totalPrice = calculateTotalPrice(order.getItems());
    totalPrice = applyDiscount(totalPrice, order.getCustomer().isMember());
    printSummary(order, totalPrice);
}
```

---

## Running the tests

### With Maven (recommended for VS Code)
```bash
mvn test
```

### With Gradle
```bash
gradle test
```

### Manually (no build tool)
```bash
JUNIT=/usr/share/java/junit4-4.13.2.jar
HAMCREST=/usr/share/java/hamcrest-core.jar

javac -cp "$JUNIT:$HAMCREST" -d out/main src/main/java/com/lab/*.java
javac -cp "$JUNIT:$HAMCREST:out/main" -d out/test src/test/java/com/lab/*.java

java -cp "$JUNIT:$HAMCREST:out/main:out/test" \
  org.junit.runner.JUnitCore \
  com.lab.CalculatorTest \
  com.lab.OrderProcessorTest
```

Expected output:
```
JUnit version 4.13.2
...............
Time: 0.08
OK (15 tests)
```

---

## Key takeaways

| Technique | Problem solved | VS Code shortcut |
|---|---|---|
| Rename Variable/Method | Cryptic names (`calc`, `x`, `y`) | **F2** |
| Extract Method | Long method doing too much | Right-click → **Refactor… → Extract Method** |

Both refactorings preserve behavior — confirmed by the green test suite running
identically before and after each change.
