# Design Patterns & Principles — Java

Hands-on exercises covering core Design Patterns and OOP principles.  
Part of the Cognizant upskilling program.

---

## Exercises

| # | Pattern | Key Idea |
|---|---------|----------|
| 1 | Singleton | One Logger instance app-wide (thread-safe, double-checked locking) |
| 2 | Factory Method | Create Word / PDF / Excel docs without `new` in client code |
| 3 | Builder | Fluent API to build `Computer` objects with optional parts |
| 4 | Adapter | Plug Stripe & PayPal behind a unified `PaymentProcessor` interface |
| 5 | Decorator | Stack Email → SMS → Slack notifications at runtime |
| 6 | Proxy | Lazy-load + cache remote images via `ProxyImage` |
| 7 | Observer | Stock price changes pushed to MobileApp & WebApp subscribers |
| 8 | Strategy | Swap payment method (Credit Card / PayPal) at runtime |
| 9 | Command | Remote control issues & undoes light commands |
| 10 | MVC | Student record management with Model-View-Controller separation |
| 11 | Dependency Injection | `CustomerService` decoupled from repo via constructor injection |

---

## How to Run

Each exercise is self-contained. Compile and run from the project root:

```bash
# Example: Exercise 1
javac Ex1_Singleton/*.java
java -cp . singleton.SingletonTest

# Example: Exercise 7
javac Ex7_Observer/*.java
java -cp . observer.ObserverTest
```

Or import the whole project into IntelliJ / Eclipse as a Java project.

---

## Patterns Covered

- **Creational**: Singleton, Factory Method, Builder  
- **Structural**: Adapter, Decorator, Proxy  
- **Behavioral**: Observer, Strategy, Command  
- **Architectural**: MVC, Dependency Injection
