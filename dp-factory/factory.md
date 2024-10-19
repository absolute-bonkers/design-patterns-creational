## 🏭 The Factory Pattern: Create with Style!

### *🍰 Why Factory?*

*Imagine you’re baking a cake, and you need different types of cakes for different occasions—chocolate for birthdays,
vanilla for anniversaries, and red velvet for Valentine’s Day.🎂<br/>
Now, do you want to bake each one from scratch every time? No way! That’s where the Factory Pattern comes in.*

*Instead of creating objects directly, you delegate the responsibility to a factory. This way, you can streamline the
process and keep your code clean and maintainable. 🧹*

### 🦄 The Factory Superpower

The Factory Pattern allows you to define an interface or abstract class for creating objects, letting subclasses decide
which class to instantiate. Here’s what makes it fabulous:

	•	Decoupled Creation: Your code doesn’t need to know the specifics of how an object is created. Just call the factory and let it handle the details! This promotes flexibility and reduces tight coupling. 🎈
	•	Enhanced Readability: Using a factory makes your code more readable and easier to maintain. When you see a factory call, you know something cool is happening behind the scenes! 👀
	•	Variability: Need to swap out one object for another? No problem! Just change the factory’s logic, and you’re all set—no need to hunt down every instance of the object in your code. 🔄

#### 💻 Example:

*Here is an illustration of factory pattern.*<br/>

Consider we have to publish Notification and we have different notification channels, i.e SMS, Push, Email etc.<br>
And we want to decide which channel needs to be used everytime we publish, with minimal information provided.<br>
And we have below setup of a Notification Interface with multiple implementation.

```mermaid
stateDiagram-v2
    NotificationInterface --> SMSNotification
    NotificationInterface --> PushNotification
    NotificationInterface --> EmailNotification
```

### ***We can provide minimal information to choose implementation dynamically with [Factory implementation](/dp-factory/src/main/java/com/absolute/bonkers/factory/NotificationFactory.java)***

Interface:
*[Notification (interface)](/dp-factory/src/main/java/com/absolute/bonkers/factory/Notification.java)*<br>
Factory Implementation Class:
*[NotificationFactory.java](/dp-factory/src/main/java/com/absolute/bonkers/factory/NotificationFactory.java)*<br/>
Test Class:
*[NotificationServiceTest.java](/dp-factory/src/test/java/com/absolute/bonkers/factory/NotificationServiceTest.java)*<br/>

### 🌈 Summary

*In the realm of software design, the Factory Pattern is your best friend for creating objects efficiently and
elegantly.<br/>
By outsourcing the creation process, you can focus on the big picture while ensuring that your code remains clean and
adaptable.<br/>
So, whether you’re crafting game elements, creating UI components, or managing different product types, remember the
Factory Pattern to keep your object creation game strong! 🏆✨*