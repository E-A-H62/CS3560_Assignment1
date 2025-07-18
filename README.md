# OOP Practice: Valid Parentheses & Pyramid Rubik's Cube

This repository is a Java-based project aimed to help students practice and understand **Object-Oriented Programming (OOP)** concepts. It includes:

1. **A stack-based algorithm** to validate balanced parentheses using OOP design.
2. **A simulated 3D Pyramid Rubik’s Cube**, demonstrating encapsulation, data structures, and object modeling.

---

## ValidParentheses.java

Implements a method to check if a string of brackets `()[]{}` is valid (i.e., properly nested and closed).

### Features:
- Uses a stack to track matching bracket pairs.
- Rejects mismatched, unordered, or empty input.

### Sample:
```java
ValidParentheses validator = new ValidParentheses();
boolean result = validator.isValid("()[]{}"); // returns true
````

---

## ValidParenthesesTest.java

JUnit tests for the `ValidParentheses` class, covering:

* Correct bracket sequences
* Mismatched and unordered pairs
* Edge cases (like empty strings)

### Run tests:

Make sure JUnit is available on your classpath. You can run using your IDE or a build tool like Maven or Gradle.

---

## PyramidRubiksCube.java

Models a **4-faced Pyramid Rubik’s Cube**, each face with 9 tiles arranged in a triangular shape:

```
    0
  1 2 3
4 5 6 7 8
```

### Features:

* Initializes the cube in a solved state.
* Assigns distinct colors per face: Red, Blue, Green, Yellow.
* Validates the cube for structure and color counts.
* Categorizes tiles into tips, edges, centers.
* Includes a print function for a triangle-based face layout.

### Sample usage:

```java
PyramidRubiksCube cube = new PyramidRubiksCube();
cube.printPyramid();     // Prints the cube
cube.validateCube();     // Throws error if invalid
```

---

## Concepts Covered

* Stack usage for algorithmic problems
* Encapsulation and modular class design
* 2D arrays
* Custom validation logic
* JUnit-based testing
* Console-based visual output

---

## Requirements

* Java 17 or later
* JUnit 5 (for testing)
