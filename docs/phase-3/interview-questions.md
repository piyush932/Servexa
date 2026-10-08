# Phase 3 Interview Questions: Collections, Generics, Exceptions, Streams

## Collections
1. `List` vs `Set` vs `Map`?
2. `ArrayList` vs `LinkedList`?
3. `HashMap` vs `LinkedHashMap` vs `TreeMap`?
4. What happens if a mutable `HashMap` key changes after insertion?
5. How does `HashMap` handle collisions?

## Generics
6. Why use generics instead of `Object`?
7. What is type erasure?
8. `<T>` vs `<? extends T>` vs `<? super T>`?
9. Why can't you create a generic array?

## Exceptions
10. Checked vs unchecked exceptions?
11. When should you create a custom exception?
12. Why throw `ResourceNotFoundException` instead of returning `null`?
13. What is `try-with-resources`?

## Streams and Optional
14. `map()` vs `filter()` vs `flatMap()`?
15. What is lazy evaluation in streams?
16. When should you return `Optional`? Why avoid `Optional.get()` without a check?

## Design
17. `Comparable` vs `Comparator`?
18. How do you support several sort orders without changing the domain class?
19. `ReentrantReadWriteLock` vs `synchronized` vs `ConcurrentHashMap`?
20. Why does the service depend on `Repository<T, ID>` and not a concrete class?
