## Item 5: Prefer dependency injection to hardwiring resources

> Static utility classes and singletons are inappropriate forclasses whose behavior is parameterized by an underlying resource.What is required is the ability to support multiple instances of the class, each of which uses the resource desired by the client.

### 1. Pass the resource into the constructor when creating a new instance.

```java
// Dependency injection provides flexibility and testability
public class SpellChecker {
    private final Lexicon dictionary;
    public SpellChecker(Lexicon dictionary) { 
        this.dictionary = Objects.requireNonNull(dictionary);
    }
    public boolean isValid(String word) {}
    public List<String> suggestions(String typo) {}
}
```

### 2. Pass a resource *factory* to the constructor.

> A factory is an object that can be called repeatedly to create instances of a type.The Supplier<T> interface, introduced in Java 8, is perfect for representing factories.

```
Mosaic create(Supplier<? extends Tile> tileFactory) {}
```

> Although dependency injection greatly improves flexibility and testability, it can clutter up large projects, which typically contain thousands of dependencies. This clutter can be all but eliminated by using a *dependency injection framework*, such as Dagger, Guice, or Spring. 