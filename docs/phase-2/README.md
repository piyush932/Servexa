# Phase 2: Object-Oriented Java

## Goal
Replace the Phase 1 `String[]` request storage with a real domain model.

## Topics covered
- Classes, objects, constructors, encapsulation
- Inheritance (`User` -> `Employee`, `SupportAgent`)
- Enums: `UserRole`, `RequestStatus`, `Priority`
- Composition: `ServiceRequest` owns `RequestComment` and `AuditEntry` lists
- `equals()`, `hashCode()`, `toString()` based on ID
- Defensive copies (`List.copyOf`, `Set.copyOf`) for getters
- State changes only through methods (`assignTo`, `changeStatus`)

## Code location
`Backend/src/com/example/servicerequest/model/`

## Compile and run
```bash
cd Backend
javac -d out $(find src -name "*.java")
java -cp out com.example.servicerequest.Main
```

## Manual checks
- Creating a user with a blank name or an email without `@` throws `IllegalArgumentException`.
- Assigning a CLOSED or REJECTED request throws `IllegalStateException`.
- Modifying the list returned by `getComments()` throws `UnsupportedOperationException`.
- Two objects with the same ID are equal and share a hash code.

## Exercises
1. Create an immutable `Department` class.
2. Add a private constructor and factory method to `User`.
3. Demonstrate polymorphism with `Employee` and `SupportAgent`.
4. Create a `NotificationSender` interface with email and console implementations.
5. Prevent a rejected request from being resolved.
6. Try modifying a private field directly and explain the compiler error.

## Completion checklist
- [ ] `ServiceRequest` is a class, not a string
- [ ] Enums used for role, status, priority
- [ ] Constructors validate input
- [ ] `equals`/`hashCode`/`toString` implemented
- [ ] Collections returned by getters are unmodifiable
- [ ] Can explain inheritance, polymorphism, abstraction, encapsulation
