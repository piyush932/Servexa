# Phase 3: Collections, Generics, Exceptions, Streams

## Goal
Turn the domain model into a working in-memory service layer.

## Topics covered
- Generic repository interface `Repository<T, ID>`
- `List`, `Set`, `Map` (`LinkedHashMap` keeps insertion order)
- `Optional` for lookups instead of `null`
- Custom exceptions: `ResourceNotFoundException`, `InvalidRequestStateException`
- `Comparator` (`ServiceRequestPriorityComparator`) and `Comparable`
- Streams for filtering and sorting
- `ReentrantReadWriteLock` for thread-safe reads and writes

## Code location
```text
Backend/src/com/example/servicerequest/
  exception/   custom exceptions
  repository/  Repository, InMemoryServiceRequestRepository, InMemoryUserRepository
  service/     ServiceRequestService
  model/       ServiceRequestPriorityComparator
```

## Compile and run
```bash
cd Backend
javac -d out $(find src -name "*.java")
java -cp out com.example.servicerequest.Main
```

## Verified output
Three requests are created (LOW, HIGH, CRITICAL).
- Sorted by priority: CRITICAL (id 3), HIGH (id 1), LOW (id 2)
- High priority open requests: ids 1 and 3
- Total requests: 3

## Completion checklist
- [x] Generic repository used by two repositories
- [x] Custom exceptions instead of `null`
- [x] Service layer mediates domain operations
- [x] Filter and sort with Streams and Comparator
- [x] `Optional` used for lookups
- [ ] JUnit tests (no `src/test` or Maven `pom.xml` on `main` yet)

## Next step
Add a Maven `pom.xml` and JUnit 5 tests for exception paths, sorting, and filtering.
