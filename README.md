# hello-world-api
The hello world API created for the Type B Digital assessment.

## Overview
This is a Spring Boot based HTTP API that exposes a single endpoint:

GET /hello-world?name=<value>

### Expected Behavior
| Input Case | HTTP Status | Response Body |
|-----------|-------------|---------------|
| First letter of `name` is A–M (case-insensitive) | 200 OK | { "message": "Hello <Name>" } |
| First letter of `name` is N–Z (case-insensitive) | 400 Bad Request | { "error": "Invalid Input" } |
| `name` is missing, empty, whitespace-only, or starts with a non-letter | 400 Bad Request | { "error": "Invalid Input" } |

The greeting decision and validation logic are handled in the service layer.

---

## How to Run the Application

### Requirements
- Java 21+
- Maven 3.8+

### Start the Application
Run:
mvn spring-boot:run

Application starts at:
http://localhost:9090/hello-world

---

## Example Usage

| Case | Request | Response |
|------|---------|----------|
| ✅ Valid (A–M) | `curl -X GET "http://localhost:9090/hello-world?name=alice"` | `{ "message": "Hello Alice" }` |
| ❌ Invalid (N–Z) | `curl -X GET "http://localhost:9090/hello-world?name=nancy"` | `{ "error": "Invalid Input" }` |
| ❌ Missing Name | `curl -X GET "http://localhost:9090/hello-world"` | `{ "error": "Invalid Input" }` |

---

## How to Run Tests

Run all tests:
mvn test

Run only service logic tests:
mvn -Dtest=HelloWorldServiceTest test

---

## Assumptions Made
- Only English alphabet letters A–Z are considered valid.
- Case-insensitive comparison.
- Input is trimmed before evaluation.
- Null, empty, whitespace-only, or non-letter-first inputs are treated as invalid.
