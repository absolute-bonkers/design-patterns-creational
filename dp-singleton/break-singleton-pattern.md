## 🚨 Breaking the Singleton Design Pattern

*The Singleton pattern ensures that a class has only one instance and provides a global point of access to that
instance.<br/>
While this can be useful in specific cases, there are valid reasons to break the Singleton pattern, especially when
scaling, testing, or flexibility are priorities.*

### 🛑 Why Break the Singleton?

- **Testing Difficulties**<br>
  *Singletons maintain global state, which can make unit testing challenging.<br>
  Mocking or resetting their state between tests can result in unexpected behavior or test pollution.*<br><br>

- **Scalability Issues**<br>
  *Singletons assume that a single instance is sufficient, which can limit scalability in distributed systems or cloud
  environments, where multiple instances may need to operate concurrently.*<br><br>

- **Tight Coupling**<br>
  *The global access provided by Singletons can result in tight coupling, making code less flexible and more difficult
  to maintain or extend.*<br><br>

- **Hidden Dependencies**<br>
  *Singletons hide dependencies behind static methods, making it harder to track and manage those dependencies,
  potentially causing issues in complex systems.*

---

## 💡 Breaking Singleton: 3 Dangerous Ways

*Singletons are designed to restrict instantiation, but they can be broken in specific scenarios.<br>
Let’s explore how reflection, cloning, and serialization/deserialization can bypass the Singleton pattern and why you
should be cautious about these vulnerabilities.*

## *🔍 Breaking Singleton via Reflection*

Reflection allows access to private constructors, which can be used to create multiple instances of a Singleton.

*Here is an illustration of breaking Singleton Pattern via Reflection.*<br/>
*[BreakSingletonPatternByReflectionTest.java](/dp-singleton/src/test/java/com/absolute/bonkers/singleton/eager/BreakSingletonPatternByReflectionTest.java)*<br/>

### 😈 *If you want to avoid breaking singleton pattern via reflection*

*you can make sure you that by throwing error from private constructor if the instance exists*

```java
class SingletItem {

    private static SingletItem singletItem;

    // avoid using constructor twice
    private SingletItem() {
        if (singletItem != null) {
            throw new RuntimeException(
                    "Good try buddy! But I won't let you break singleton pattern by reflection :D ");
        }
    }

    // lazy way creation goes here
}

```

---

## 🔍 Breaking Singleton via Serialization

*Serialization allows us to convert an object into a byte stream to store it or send it over the network, and
deserialization reconstructs the object from the byte stream.<br>
This process can inadvertently break the Singleton pattern, which ensures that only one instance of a class is created.*

***NOTE: We need to make Service / Java class as serializable to break this pattern via serialization***

*When you serialize and deserialize a Singleton object, the default behavior of Java is to create a new instance upon
deserialization, even if the class enforces a Singleton through traditional methods like lazy initialization or
double-checked locking.*

*Here is an illustration of breaking Singleton Pattern via Serialization.*<br/>
*[BreakSingletonPatternBySerializationTest.java](/dp-singleton/src/test/java/com/absolute/bonkers/singleton/eager/BreakSingletonPatternBySerializationTest.java)*<br/>

### 😈 *If you want to avoid breaking singleton pattern via serialization*

*you can make sure that by overriding readResolve method that is used while deserialization*

```java
class SingletItem {

    private static SingletItem singletItem;

    // avoid using constructor twice
    private SingletItem() {
    }

    // lazy way creation goes here

    // below method is used at the time of deserialization, and we make it return the same instance to
    // avoid deserialization
    public Object readResolve() {
        return singletItem;
    }
}

```

**IMPORTANT NOTE**: *In newer versions of Java, including Java 23, there are mechanisms that might automatically protect
singletons from being broken via serialization/deserialization, especially if you’re using modern best practices like
enums for singleton implementation.<br>
Java provides built-in protection for enums by ensuring they remain singletons even after deserialization.<br>
This is because only the enum name is serialized, and during deserialization, the JVM uses the valueOf method to return
the same enum instance, preventing multiple instances from being created.*

--- 

## *🔍 Breaking Singleton via Cloning*

*Cloning is a mechanism in Java that allows you to create a duplicate of an object by copying its field values.<br>
If a class implements the Cloneable interface and overrides the clone() method, it becomes cloneable.<br>
However, this can unintentionally break the Singleton pattern, as cloning creates a new instance of the Singleton
class.*

***NOTE: since clone method has protected access hence need to override clone method within concerned Class***

*When you clone an object of a Singleton class, the clone() method creates a new instance, even though the Singleton
pattern is meant to restrict the class to one instance.*

*Here is an illustration of breaking Singleton Pattern via Object Cloning.*<br/>
*[BreakSingletonPatternByCloningTest.java.java](/dp-singleton/src/test/java/com/absolute/bonkers/singleton/eager/BreakSingletonPatternByCloningTest.java)*<br/>

### 😈 *If you want to avoid breaking singleton pattern via Cloning*

*you can make sure you that by overriding clone() method and return same instance*

```java
class SingletItem implements Cloneable {

    private static SingletItem singletItem;

    // avoid using constructor twice
    private SingletItem() {
    }

    // lazy way creation goes here

    /**
     * if we need to break singleton pattern via clone method, we need to allow access to clone()
     * method outside the Class and implement Cloneable interface
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return singletItem;
    }
}

```

---
