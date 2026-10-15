## 🧬 The Prototype Pattern: Clone with Confidence!

### *🔄 Why Prototype?*

*Imagine you’re running a high-end tailor shop where every suit is custom-made. 🎩<br/>  
You’ve just finished crafting the perfect suit, and now a VIP client walks in and wants the exact same design, but with a few minor tweaks. <br/>
Would you start from scratch? Of course not! You’d clone the existing design and make adjustments. 🧵*

*This is exactly what the Prototype Pattern does—it allows you to clone existing objects to avoid the cost of creating them from scratch, especially when the creation process is complex.*

### 🦸‍♀️ The Prototype Superpower

The Prototype Pattern is all about creating new objects by copying existing ones (prototypes) rather than creating them from scratch. Here’s what makes it awesome:

    • Efficient Cloning: Save time and resources by copying an existing object, especially when object creation is costly. Need another spaceship blueprint? Just clone the existing one! 🚀
    • Customizable Copies: Easily make tweaks to the cloned object without affecting the original, allowing for rapid prototyping and experimentation. Think of it like creating multiple test models from a master copy! 🔧
    • Decoupled Instantiation: The client code doesn’t need to worry about the specifics of how an object is created. It simply requests a copy from the prototype. This keeps your code flexible and adaptable. 🎯

### 🌈 Summary

*In software design, the Prototype Pattern is your go-to for creating objects efficiently by cloning existing ones rather than starting from scratch.<br/>
Whether you’re duplicating complex objects, creating variations of a base model, or building rapid prototypes, the Prototype Pattern keeps the process smooth and resource-friendly.<br/>
So, the next time you need multiple versions of an object, remember the Prototype Pattern and clone with confidence! 🏆✨*

### 💻 Java Example

`Recipe` acts as a prototype. Its `copy()` method creates an independent recipe that can be customized without changing the original:

```java
Recipe original = new Recipe("Vegetable soup", List.of("carrot", "potato"));
Recipe variation = original.copy();
variation.setName("Spicy vegetable soup");
variation.addIngredient("chili");
```

- [Recipe.java](src/main/java/com/absolute/bonkers/prototype/Recipe.java)
- [RecipeTest.java](src/test/java/com/absolute/bonkers/prototype/RecipeTest.java)

Run this module's tests with `./gradlew :dp-prototype:test` from the repository root.