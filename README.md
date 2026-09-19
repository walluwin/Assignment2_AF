# Assignment #2 — Abstract Factory

## Software Design Patterns

### Part B — Abstract Factory

**Topic:** Drinks

This project demonstrates the **Abstract Factory** design pattern using two product families:

* Coca-Cola
* Maxi Tea

Each family contains two related products:

* Drink
* Bottle

The main goal is to create a complete family of related objects without directly instantiating concrete classes in the client.

---

## Project Structure

```text
src/
├── Drink.java
├── Bottle.java
│
├── CocaColaDrink.java
├── CocaColaBottle.java
├── MaxiTeaDrink.java
├── MaxiTeaBottle.java
│
├── DrinkFactory.java
├── CocaColaFactory.java
├── MaxiTeaFactory.java
│
└── Main.java
```

### Pattern Components

| Component          | Classes                             |
| ------------------ | ----------------------------------- |
| Abstract Products  | `Drink`, `Bottle`                   |
| Coca-Cola Products | `CocaColaDrink`, `CocaColaBottle`   |
| Maxi Tea Products  | `MaxiTeaDrink`, `MaxiTeaBottle`     |
| Abstract Factory   | `DrinkFactory`                      |
| Concrete Factories | `CocaColaFactory`, `MaxiTeaFactory` |
| Client             | `Main`                              |

---

## How It Works

`Drink` and `Bottle` are the Abstract Products:

```java
public interface Drink {
    void prepare();
}
```

```java
public interface Bottle {
    void packageDrink();
}
```

The `DrinkFactory` interface declares methods for creating both products:

```java
public interface DrinkFactory {

    Drink createDrink();

    Bottle createBottle();
}
```

`CocaColaFactory` creates the Coca-Cola product family:

```java
public class CocaColaFactory implements DrinkFactory {

    @Override
    public Drink createDrink() {
        return new CocaColaDrink();
    }

    @Override
    public Bottle createBottle() {
        return new CocaColaBottle();
    }
}
```

`MaxiTeaFactory` creates the Maxi Tea product family:

```java
public class MaxiTeaFactory implements DrinkFactory {

    @Override
    public Drink createDrink() {
        return new MaxiTeaDrink();
    }

    @Override
    public Bottle createBottle() {
        return new MaxiTeaBottle();
    }
}
```

---

## Client

The client works only with the Abstract Factory and Abstract Product interfaces:

```java
DrinkFactory factory = new CocaColaFactory();

Drink drink = factory.createDrink();
Bottle bottle = factory.createBottle();

drink.prepare();
bottle.packageDrink();
```

The client does not directly instantiate:

```java
new CocaColaDrink();
new CocaColaBottle();
```

This keeps the client independent from concrete product classes.

---

## Product Families

```text
CocaColaFactory
    ├── CocaColaDrink
    └── CocaColaBottle

MaxiTeaFactory
    ├── MaxiTeaDrink
    └── MaxiTeaBottle
```

Each Concrete Factory creates a consistent family of related products.

---

# Clean Code Principles

### 1. Meaningful Names

Classes and methods clearly describe their purpose:

```text
CocaColaFactory
MaxiTeaFactory
createDrink()
createBottle()
packageDrink()
```

These names make the code easy to understand.

### 2. Single Responsibility

Each class has one main responsibility.

```text
CocaColaDrink
→ represents Coca-Cola

CocaColaBottle
→ represents Coca-Cola packaging

CocaColaFactory
→ creates Coca-Cola products
```

### 3. Small Methods

Factory methods perform one simple task:

```java
public Drink createDrink() {
    return new CocaColaDrink();
}
```

The method only creates and returns a product.

### 4. Programming to Interfaces

The client uses interfaces instead of concrete classes:

```java
DrinkFactory factory = new CocaColaFactory();

Drink drink = factory.createDrink();
Bottle bottle = factory.createBottle();
```

This reduces coupling between the client and concrete implementations.

### 5. Separation of Object Creation

Concrete objects are created inside Concrete Factories:

```java
return new CocaColaDrink();
```

The client only requests products through the factory.
