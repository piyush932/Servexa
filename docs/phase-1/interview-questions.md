# Phase 1 — Interview Questions

Answer these without memorizing definitions. Use examples from the Servexa console application where possible.

## Java platform

### 1. What is the difference between JDK, JRE, and JVM?

Cover development tools, runtime libraries, the JVM, and how source code becomes bytecode.

### 2. Explain the Java compilation and execution process.

Explain `.java` source, `javac`, `.class` bytecode, class loading, and JVM execution.

### 3. Why is Java platform-independent?

Explain bytecode and the JVM available for different operating systems.

## Types and values

### 4. What is the difference between primitive and reference types?

Discuss storage behavior conceptually, default values, methods, and object references.

### 5. What are wrapper classes?

Explain `Integer`, `Long`, `Boolean`, autoboxing, unboxing, and why collections use objects.

### 6. What is widening and narrowing conversion?

Give examples and explain possible data loss during narrowing.

### 7. Is Java pass-by-reference or pass-by-value?

The correct answer is pass-by-value. Explain that an object reference is copied by value, so object fields can be changed but the caller's reference cannot be replaced.

## Strings

### 8. Why is `String` immutable?

Discuss string pooling, security, thread-safety, caching, and predictable behavior.

### 9. What is the difference between `==` and `equals()` for strings?

`==` compares references; `equals()` compares content.

### 10. Compare `String`, `StringBuilder`, and `StringBuffer`.

Discuss immutability, mutable construction, synchronization, and suitable use cases.

## Control flow and arrays

### 11. What is the difference between `break` and `continue`?

`break` exits the loop or switch; `continue` skips to the next loop iteration.

### 12. When would you use a `do-while` loop?

Use it when the body must execute at least once, such as a menu that must be displayed before reading the next choice.

### 13. What are the limitations of arrays?

Fixed size, homogeneous elements, manual resizing, and limited operations compared with collections.

### 14. What happens when an array reaches capacity?

New values cannot be inserted unless a larger array is created and values are copied. Phase 3 will replace this with collections.

## Methods and class members

### 15. What is method overloading?

Multiple methods with the same name but different parameter lists. Return type alone cannot overload a method.

### 16. What is the difference between static and instance members?

Static members belong to the class; instance members belong to individual objects.

### 17. Why should a constant be declared static final?

It creates one class-level value that cannot be reassigned.

### 18. What is the purpose of this?

It refers to the current object and helps distinguish instance fields from parameters.

## Practical behavior

### 19. What happens when Integer values are compared with ==?

== compares references. Some values may appear equal because of wrapper caching, so equals() should be used for value comparison.

### 20. How would you validate user input in a console application?

Read input safely, trim it, validate blank values and format, handle NumberFormatException, and continue prompting instead of terminating.

### 21. How would you improve the current fixed-array implementation?

Introduce a ServiceRequest class, use a collection, separate repository and service responsibilities, add validation, and write tests.

### 22. What design problems exist when all logic is placed in main?

Poor readability, difficult testing, high coupling, duplicated logic, and difficult future conversion to layered architecture.

## Coding exercises

1. Reverse a string without using a built-in reverse method.
2. Count character frequencies using an array.
3. Find the first non-repeating character.
4. Implement power calculation using iteration and recursion.
5. Demonstrate primitive pass-by-value.
6. Demonstrate mutation of an object passed to a method.
7. Print a two-dimensional array.
8. Validate that a request title is not blank.
9. Find the maximum value in an integer array.
10. Remove duplicate values from an integer array without using a collection.

## Completion standard

For every question, prepare:

- A one-sentence answer.
- A detailed explanation.
- A small code example.
- An example from the Servexa project.
- One common mistake or misconception.