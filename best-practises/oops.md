# ✨ Java Naming Conventions

| Element        | Convention | Example                                             |
|----------------|------------|-----------------------------------------------------|
| **Package**    | all lowercase, reverse domain style | `com.shubham.taskflowai.service`                    |
| **Class**      | PascalCase (each word starts with capital) | `User`, `TaskController`, `BankAccount`             |
| **Interface**  | PascalCase (like a role or capability) | `UserRepository`, `Runnable`, `Serializable`        |
| **Method**     | camelCase (verbs for actions) | `getUserById()`, `createTask()`, `calculateTotal()` |
| **Variable**   | camelCase (nouns, descriptive) | `taskTitle`, `dueDate`, `userList`                  |
| **Constant**   | ALL_CAPS with underscores | `MAX_USERS`, `PI_VALUE`, `JWT_SECRET_KEY`           |
| **Enum Type**  | PascalCase | `TaskStatus`                                        |
| **Enum Values**| ALL_CAPS | `TODO`, `IN_PROGRESS`, `DONE`                       |
| **Annotations**| PascalCase (like classes) | `@RestController`, `@Service`, `@Entity`            |
| **Test Class** | Same as class + `Test` | `UserServiceTest`, `TaskControllerTest`             |

# 🔒 Java Access Modifiers


| Modifier    | Class Visibility | Package Visibility | Subclass Visibility | World Visibility | Typical Use Case |
|-------------|------------------|---------------------|---------------------|------------------|------------------|
| **public**  | ✅               | ✅                  | ✅                  | ✅               | Expose APIs, Controller methods |
| **protected** | ✅             | ✅                  | ✅ (even in other package subclasses) | ❌ | Allow inheritance but hide from outside world |
| **default** (no keyword) | ✅ | ✅ | ❌ | ❌ | Internal package-only use (helper classes/methods) |
| **private** | ✅ (inside class only) | ❌ | ❌ | ❌ | Hide sensitive data, encapsulation in entities/models |

* Subclass means class inheriting it and it can be in other package as well
* a.b != a.b.c (different packages)

### 1. **Entities → Public Class, Private Fields**
- **Reasoning**:
    - JPA/Hibernate requires the entity class to be public (reflection).
    - Fields must be private to enforce validation and control.
- **Say NO** to:
    - Exposing entity fields as public.
    - Returning entities directly from controllers.

🛡️ Hibernate Access Modes & Getters/Setters

##🔹 Two Access Modes
1. **Property Access** → JPA annotations (`@Id`) placed on **getter**
    - Hibernate uses **getters/setters** for all fields.
    - Requires both getter & setter for persistence.

2. **Field Access** → JPA annotations (`@Id`) placed on **field**
    - Hibernate uses **reflection** to read/write fields directly.
    - Getters/setters are optional (only needed for your app logic).

---

### 2. **Repositories → Public Interface, Used Internally**
- **Reasoning**:
    - Spring Data needs repositories to be public to create proxies.
    - Only Services should use them — not Controllers directly.
- **Say NO** to:
    - Calling `UserRepository` from `UserController`.

---

### 3. **Services → Public Class, Hide Helpers**
- **Reasoning**:
    - Services must be public so Controllers can use them.
    - Business rules live here, so internal helpers should be private.
- **Say NO** to:
    - Making every method public.
    - Leaking internal business logic to Controllers.

---

### 4. **Controllers → Public, Expose Only DTOs**
- **Reasoning**:
    - Controllers are the **outside API** (REST endpoints).
    - Must be public, but should never return Entities.
    - Use Request/Response DTOs for safe data exposure.
- **Say NO** to:
    - Returning `User` entity with password field.
    - Accepting entities directly in `@RequestBody`.

---

### 5. **DTOs → Public but Minimal**
- **Reasoning**:
    - DTOs exist to separate external contracts from internal models.
    - Can be public, but should contain only safe/necessary fields.
- **Say NO** to:
    - Overloading DTOs with sensitive or irrelevant fields.

---

### 6. **Configurations & Constants → Isolated**
- **Reasoning**:
    - Config classes (`SecurityConfig`, `SwaggerConfig`) must be public so Spring can load them.
    - Constants should be central (e.g., `JwtConstants`) and immutable.
- **Say NO** to:
    - Sprinkling magic strings/numbers across code.


---

### 7. **Helpers**
- Keep helper classes in the same package if you want package-private access
- Make helper classes public if they're in a subpackage and need to be accessed from the parent package or vice versa

## 🔹 Rules of Thumb for Package Structure
1. Start flat → split only when things grow.
2. Entities ≠ DTOs → always separate to avoid exposing persistence model.
3. Domain-specific exceptions → stay in feature; global ones → `common`.
4. Helpers: local (same package), feature-wide (`feature.util`), global (`common.util`).
5. If unsure: keep simple, reorganize later (refactor-safe).