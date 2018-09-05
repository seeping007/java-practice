## Item 1: Consider static factory methods instead of constructors

### Advantages

#### 1. They have names. 

- It's easier to use and read.
- In cases where a class seems to require multiple constructors with the same signature, replace the constructors with static factory methods and carefully chosen names to highlight their differences.

#### 2. They are not required to create a new object each time they’re invoked.

- This allows immutable classes (Item 17) to use preconstructed instances, or to cache instances as they’re constructed, and dispense them repeatedly to avoid creating unnecessary duplicate objects. 
- *Instance-controlled*: classes that maintain strict control over what instances exist at any time. (singleton or noninstantiable)

#### 3. They can return an object of any subtype of their return type.

- One application of this flexibility is that an API can return objects without making their classes public. Hiding implementation classes in this fashion leads to a very compact API. This technique lends itself to interface-based frameworks (Item 20), where interfaces provide natural return types for static factory methods.
- java.util.Collections

#### 4. The class of the returned object can vary from call to call as a function of the input parameters. 

- EnumSet class (Item 36)

#### 5. The class of the returned object need not exist when the class containing the method is written.

- Such flexible static factory methods form the basis of service provider frameworks, like the Java Database Connectivity API (JDBC). A service provider framework is a system in which providers implement a service, and the system makes the implementations available to clients, decoupling the clients from the implementations.

### Disadvantages

#### 1. The main limitation of providing only static factory methods is that classes without public or protected constructors cannot be subclassed.

- But it encourages programmers to use composition instead of inheritance (Item 18).

#### 2. They are hard for programmers to find.

- you can reduce this problem by drawing attention to static factories in class or interface documentation and by adhering to common naming conventions.

| name                 | description                                                  | example                                                     |
| -------------------- | ------------------------------------------------------------ | ----------------------------------------------------------- |
| from                 | A type-conversion method that takes a single parameter and returns a corresponding instance of this type. | Date d = Date.from(instant);                                |
| of                   | An aggregation method that takes multiple parameters and returns an in- stance of this type that incorporates them. | Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);        |
| valueOf              | A more verbose alternative to from and of.                   | BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);   |
| instance/getInstance | Returns an instance that is described by its pa- rameters (if any) but cannot be said to have the same value. | StackWalker luke = StackWalker.getInstance(options);        |
| create/newInstance   | Like instance or getInstance, except that the method guarantees that each call returns a new instance. | Object newArray = Array.newInstance(classObject, arrayLen); |
| getType              | Like getInstance, but used if the factory method is in a different class. Type is the type of object returned by the factory method. | FileStore fs = Files.getFileStore(path);                    |
| newType              | Like newInstance, but used if the factory method is in a different class. Type is the type of object returned by the factory method. | BufferedReader br = Files.newBufferedReader(path);          |
| type                 | A concise alternative to getType and newType.                | List<Complaint> litany = Collections.list(legacyLitany);    |
