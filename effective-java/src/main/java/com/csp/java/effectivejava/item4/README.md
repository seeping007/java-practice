## Item 4: Enforce noninstantiability with a private constructor

> *Utility classes* were not designed to be instantiated. (such as *java.lang.Math* and *java.util.Arrays*)

> Attempting to enforce noninstantiability by making a class abstract does not work. The class can be subclassed and the subclass instantiated. Furthermore, it misleads the user into thinking the class was designed for inheritance (Item 19).

```java
// Noninstantiable utility class
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError(); // isn’t strictly required
    }
}
```