# Phase 2 Interview Questions: Object-Oriented Java

## Classes and objects
1. What is the difference between a class and an object?
2. What is encapsulation and why are fields usually private?
3. What is constructor overloading and constructor chaining?
4. Can a constructor be inherited or overridden?

## Inheritance and polymorphism
5. What is method overriding versus overloading?
6. Compile-time versus runtime polymorphism?
7. Abstract class versus interface: when do you choose each?
8. Why does Java not allow multiple inheritance of classes?
9. What do `super` and upcasting/downcasting do?
10. Can an interface have default and static methods?

## Object methods
11. Why must `equals()` and `hashCode()` be overridden together?
12. What happens if equal objects have different hash codes?
13. Identity (`==`) versus equality (`equals`)?
14. What goes wrong when mutable fields are used in `hashCode()`?

## Design
15. What is composition and when is it better than inheritance?
16. How do you make a class immutable?
17. Why return defensive copies from getters?
18. Why keep business rules inside domain objects?
19. How do you design a class that cannot exist in an invalid state?
20. Why use enums instead of strings for status values?

## Project-based
21. Why does `ServiceRequest` expose `assignTo()` instead of a status setter?
22. Why is `User.id` final while `name` is mutable?
23. How would `equals()` behave between an `Employee` and a `SupportAgent` with the same ID?
