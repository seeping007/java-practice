## Item 2: Consider a builder when faced with many constructor parameters

### 1. Telescoping constructor pattern

```java
public class NutritionFacts { // does not scale well
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0); 
    }
        
    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }
        
    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this.servingSize  = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = 0;
    }
    
    //... ....
}

// It works, but hard to write client code and harder to read.
NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35);
```

### 2. JavaBeans pattern

```java
// allows inconsistency, mandates mutability
public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize = -1;
    private int servings = -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
    
    public NutritionFacts() { }

    // Setters
    public void setServingSize(int val) { servingSize = val; }
    public void setServings(int val) { servings = val; }
    public void setCalories(int val) { calories = val; }
    public void setFat(int val) {fat=val;}
    public void setSodium(int val) { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }
}
```

### 3. Builder pattern

#### Advantages

1. The Builder pattern simulates named optional parameters as found in Python and Scala. (@see *sample1*)

2. The Builder pattern is well suited to class hierarchies. (@see *sample2*)

#### Disadvantages

1. In order to create an object, youmust first create its builder. While the cost of creating this builder is unlikely to benoticeable in practice, it could be a problem in performance-critical situations.

2. The Builder pattern is more verbose than the telescoping constructor pattern, so it should be used only if there are enough parameters to make it worthwhile, say four or more.

> In summary, the Builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters, especially if many of the parameters are optional or of identical type. Client code is much easier to read and write with builders than with telescoping constructors, and builders are much safer than JavaBeans.