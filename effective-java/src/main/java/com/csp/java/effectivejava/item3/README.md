## Item 3: Enforce the singleton property with a private constructor or an enum type

Singletons typically represent either a stateless object such as a function (Item 24) or a system component that is intrinsically unique.

### Approach 1: public final field

```java
// Singleton with public final field
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public void leaveTheBuilding() {}
}
```

- The API makes it clear that the class is a singleton: the public static field is final, so it will always contain
  the same object reference.
- It's simpler.

### Approach 2: static factory

```java
// Singleton with static factory
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public static Elvis getInstance() { return INSTANCE; }
    public void leaveTheBuilding() {}
}
```

- It gives you the flexibility to change your mind about whether the class is a singleton without changing its API. (return instance could be modified)
- You can write a *generic singleton factory* if your application requires it (Item 30). 
- A *method reference* can be used as a supplier, for example  Elvis::instance is a  Supplier<Elvis> .

### Warnings for approach 1 and 2

> Nothing that a client does can change this, with one caveat: **a privileged client can invoke the private constructor reflectively (Item 65) with the aid of the  *AccessibleObject.setAccessible* method.** If you need to defend against this attack, modify the constructor to make it throw an exception if it’s asked to create a second instance. 

> To make a singleton class that uses either of these approaches serializable (Chapter 12), it is not sufficient merely to add  implements *Serializable* to its declaration. To maintain the singleton guarantee, declare all instance fields *transient* and provide a  *readResolve* method (Item 89). 

```java
// readResolve method to preserve singleton property
private Object readResolve() {
    // Return the one true Elvis and let the garbage collector
    // take care of the Elvis impersonator.
    return INSTANCE;
}
```

### Approach 3: single-element enum type

```java
// Enum singleton - the preferred approach
public enum Elvis {
    INSTANCE;
    public void leaveTheBuilding() {}
}
```

- It is more concise, provides the serialization machinery for free, and provides an ironclad guarantee
  against multiple instantiation, even in the face of sophisticated serialization or reflection attacks.

- You can’t use this approach if your singleton must extend a superclass other than *Enum*.