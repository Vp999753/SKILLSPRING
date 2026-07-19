## Difference between JPA, Hibernate and Spring Data JPA

| Feature | JPA | Hibernate | Spring Data JPA |
|---------|-----|-----------|-----------------|
| Definition | Java Persistence API (Specification) | ORM Framework (Implementation of JPA) | Spring Framework module built on top of JPA |
| Type | Specification | Framework | Framework/Abstraction |
| Purpose | Defines standards for Object Relational Mapping (ORM) | Implements JPA and performs ORM operations | Simplifies database operations using JPA |
| Developed By | Oracle / JCP | Red Hat (Hibernate Team) | Spring Team |
| SQL Handling | Defines ORM standards | Generates SQL and maps Java objects to database tables | Uses JPA (typically Hibernate) internally to reduce boilerplate code |
| Repository Support | No | No | Yes (`JpaRepository`) |
| Boilerplate Code | More | Moderate | Very Less |

### Relationship

```text
Spring Data JPA
        │
        ▼
       JPA
        │
        ▼
   Hibernate
        │
        ▼
     MySQL Database
```

### One-Line Definitions

- **JPA** is a Java specification that defines how Java objects should be mapped to relational databases.
- **Hibernate** is an ORM framework that implements the JPA specification and handles database operations.
- **Spring Data JPA** is a Spring module built on top of JPA that simplifies database access using repository interfaces such as `JpaRepository`.

### Example

#### JPA Entity

```java
@Entity
public class Country {

    @Id
    private String code;

    private String name;
}
```

#### Hibernate

```java
Session session = sessionFactory.openSession();
session.save(country);
```

#### Spring Data JPA

```java
public interface CountryRepository extends JpaRepository<Country, String> {
}
```

Spring Data JPA provides built-in methods such as:

```java
countryRepository.findAll();
countryRepository.save(country);
countryRepository.deleteById("IN");
```

without requiring explicit SQL queries or Hibernate session management.

### Conclusion

- **JPA** = Specification (Rules)
- **Hibernate** = Implementation (Engine)
- **Spring Data JPA** = Simplified Framework (Shortcut)
