[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![GitHub watchers](https://img.shields.io/github/watchers/absolute-bonkers/design-patterns-creational)
![GitHub Repo stars](https://img.shields.io/github/stars/absolute-bonkers/design-patterns-creational)
![GitHub Repo forks](https://img.shields.io/github/forks/absolute-bonkers/design-patterns-creational)

---

## 🎨 Creational Design Patterns

****Design patterns*** are like cheat codes for coding problems! <br/>
They’re tried-and-true solutions to common software design challenges,
making your code cleaner, easier to maintain, and more flexible. <br/>
Think of them as blueprints, split into creational, structural, and behavioral categories,
each helping you level up your coding game in different ways.*

### *Creational Design Patterns*

*Examples built with Java 21 and Spring Boot.* ☕

Creational design patterns are like your **personal object factory!** Instead of chaotically creating objects all over
the place, these patterns give you **control** over how and when your objects are born. Think of it as leveling up your
object-creation game! 🛠️✨

This repository is part of a three-part GoF design patterns series:

- [Creational patterns](https://github.com/absolute-bonkers/design-patterns-creational) (this repository)
- [Structural patterns](https://github.com/absolute-bonkers/design-patterns-structural)
- [Behavioral patterns](https://github.com/absolute-bonkers/design-patterns-behavioral)

### Here's the squad:

1. **🥇 Singleton**  
   The "only one" friend. Ensures a class has just **one instance**, like a VIP who doesn't do duplicates. Exclusive
   access only! 🔑<br/>

2. **☕ Factory Method**  
   Think of it as a **barista** taking your order. You say what type of drink you want, and it whips up the right one —
   without you worrying about the recipe. Easy-peasy!

3. **🏗️ Abstract Factory**  
   Next level barista. It's like a **factory of factories**, creating entire sets of related objects — like picking out
   a full outfit, instead of just shoes. Drip 💧!

4. **🥪 Builder**  
   The **meal-prep master**. Helps you build complex objects step-by-step, like assembling a perfect sandwich 🥪, instead
   of tossing everything together into chaos.

5. **🧬 Prototype**  
   The **clone master**. Instead of starting from scratch, it copies existing objects, like **Ctrl+C and Ctrl+V** but in
   code. Fast and efficient, baby! ⚡

<br/>

*These patterns are your **superpowers** 🦸‍♂️ for handling object creation, keeping your code sleek, clean, and
drama-free! 💥*

## *⭐ Let's understand all design patterns in details*

### [Singleton Design Pattern](/dp-singleton/singleton.md)

Also See 👉🏻 [Breaking Singleton Design Patterns](/dp-singleton/break-singleton-pattern.md)

### [Factory Design Pattern](/dp-factory/factory.md)

### [Abstract Factory Design Pattern](/dp-abstract-factory/abstract-factory.md)

### [Prototype Design Pattern](/dp-prototype/prototype.md)

### [Builder Design Pattern](/dp-builder/builder.md)

<br/>
<br/>

## 🧩 The complete GoF design-pattern collection

Want to explore the whole squad? The 23 classic patterns are split across these three repositories:

### 🎨 Creational — creating objects without the chaos

1. [Singleton](/dp-singleton/singleton.md) — one shared instance, VIP-style 🔑
2. [Factory Method](/dp-factory/factory.md) — delegate which product gets made ☕
3. [Abstract Factory](/dp-abstract-factory/abstract-factory.md) — create families of related products together 🏗️
4. [Builder](/dp-builder/builder.md) — assemble a complex object one step at a time 🥪
5. [Prototype](/dp-prototype/prototype.md) — make a new object by copying an existing one 🧬

### 🧱 Structural — making objects fit together

Explore [Adapter](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/adapter),
[Bridge](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/bridge),
[Composite](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/composite),
[Decorator](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/decorator),
[Facade](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/facade),
[Flyweight](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/flyweight), and
[Proxy](https://github.com/absolute-bonkers/design-patterns-structural/tree/main/proxy). 🧩

### 🤝 Behavioral — getting objects to work as a team

Explore [Chain of Responsibility](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/chain-of-responsibility),
[Command](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/command),
[Interpreter](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/interpreter),
[Iterator](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/iterator),
[Mediator](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/mediator),
[Memento](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/memento),
[Observer](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/observer),
[State](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/state),
[Strategy](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/strategy),
[Template Method](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/template-method), and
[Visitor](https://github.com/absolute-bonkers/design-patterns-behavioral/tree/main/visitor). ✨

All three collections target **Java 21**. The other repositories include focused Java examples, tests, and chapter guides;
Spring Boot is used where it helps show the pattern in a realistic application.

### 🚀 Build and test

Install JDK 21, then run the bundled Gradle Wrapper from this repository:

```sh
./gradlew build
./gradlew test
./gradlew :dp-builder:test
```

No system Gradle installation is needed—the wrapper downloads the pinned Gradle 9.8.1 distribution and verifies its
SHA-256 checksum the first time you run it.

<br/>
<br/>

---
```Note from author: Got an idea? Want to help make this project even more epic? We’d love to hear from you! 🤩```

*Let's stay in touch:*

<p>
<a href="https://www.linkedin.com/in/adityachandeliya/">
    <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" />
</a>&nbsp;&nbsp;
<a href="https://github.com/imchandeliya">
    <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" />
</a>&nbsp;&nbsp;
</p>

*Star this repo if you found it helpful! ⭐ It helps others discover it too!*

---

Made with 💻 and ☕ by [Aditya Chandeliya](https://github.com/imchandeliya)
