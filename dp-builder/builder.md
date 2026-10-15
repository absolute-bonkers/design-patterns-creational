## 🏗️ The Builder Pattern: Construct with Precision!

### *🍔 Why Builder?*

*Imagine you’re ordering a gourmet burger, and you want full control over every ingredient—pick the bun, choose the meat, add toppings like avocado or bacon, and don’t forget the sauces! 🍔<br/>
You want it just the way you like it, right?<br/> 
The Builder Pattern does exactly that for object creation—giving you the power to construct complex objects step by step, customized to your needs.*

*Instead of juggling constructors with a dozen parameters, the Builder lets you add components in a clean, readable way, without messing up your code! 🧑‍🍳*

### 🛠️ The Builder Superpower

The Builder Pattern provides a way to construct complex objects incrementally, step by step, without exposing the object’s internal details. Here’s what makes it shine:

    • Step-by-Step Flexibility: Build an object piece by piece, in a structured order. Want to create a house with multiple rooms and a fancy garden? No problem! 🏡
    • Readable Code: With Builder, you can avoid those messy constructors with endless parameters. Instead, create objects in a clear and intuitive manner! It’s like writing out a shopping list. 🛒
    • Immutable Result: The Builder pattern typically produces an immutable object—once it’s built, you can’t change it! This guarantees consistency and thread safety in multi-threaded environments. 🔒

### 🌈 Summary

*In the world of object creation, the Builder Pattern is your best friend for constructing complex objects with precision.<br/>
By providing a clean and structured way to assemble objects step by step, you maintain control and clarity without drowning in parameters or constructors.<br/>
Whether you’re designing a burger, building a house, or assembling a user profile, the Builder Pattern is the ultimate tool for building exactly what you need, with zero confusion and maximum customization! 🏆✨*

### 💻 Java Example

This module builds an immutable `Sandwich` from required bread and filling, with optional toppings:

```java
Sandwich sandwich =
    new Sandwich.Builder("sourdough", "roasted vegetables")
        .addTopping("spinach")
        .addTopping("tomato")
        .build();
```

- [Sandwich.java](src/main/java/com/absolute/bonkers/builder/Sandwich.java)
- [SandwichTest.java](src/test/java/com/absolute/bonkers/builder/SandwichTest.java)

Run this module's tests with `./gradlew :dp-builder:test` from the repository root.