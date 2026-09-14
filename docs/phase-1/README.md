# Phase 1 — Java Fundamentals

## Project context

Servexa is being developed as an enterprise service-request management system. The existing Phase 1 implementation is located under `Backend/src/com/example/servicerequest/Main.java`.

## Goal

Revise the Java fundamentals required before object-oriented modeling and Spring Boot development.

## Topics

- JDK, JRE, JVM, compilation, and bytecode
- Primitive types, wrapper classes, autoboxing, and casting
- Variables, scope, operators, and control flow
- Loops, arrays, and multidimensional arrays
- `String`, immutability, the string pool, and `StringBuilder`
- Methods, parameters, return values, and overloading
- Java pass-by-value
- `static`, `final`, and basic package usage
- Input validation with `Scanner`

## Existing implementation

The current code is a menu-driven console prototype that demonstrates:

- Creating service requests
- Viewing all requests
- Searching by request ID
- Input validation
- A fixed-size in-memory array
- Separating menu operations into methods

## Run the application

From the repository root:

```bash
javac -d out Backend/src/com/example/servicerequest/Main.java
java -cp out com.example.servicerequest.Main
```

If the source file uses additional classes later, compile all Java files with:

```bash
javac -d out $(find Backend/src -name "*.java")
java -cp out com.example.servicerequest.Main
```

## Manual verification

- Create a request with a valid title.
- Try creating a request with a blank title.
- View requests when the store is empty.
- Search for an existing request ID.
- Search for a missing or invalid request ID.
- Verify that the application exits cleanly.

## Completion checklist

- [ ] I can explain JDK, JRE, and JVM.
- [ ] I can explain primitive versus reference values.
- [ ] I can explain why `String` is immutable.
- [ ] I can explain Java pass-by-value.
- [ ] I can write methods instead of placing all logic in `main`.
- [ ] I can use arrays and loops confidently.
- [ ] I can compile and run the project from the command line.
- [ ] I completed the interview questions.
- [ ] I tested valid, invalid, empty, and boundary inputs.

## Next phase

Phase 2 will replace the raw request-title representation with encapsulated domain classes such as `User`, `Employee`, and `ServiceRequest`. It will introduce constructors, access modifiers, inheritance, interfaces, polymorphism, `equals()`, `hashCode()`, and `toString()`.