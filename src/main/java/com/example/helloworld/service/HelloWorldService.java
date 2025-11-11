package com.example.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    /**
     * Validates the input name and returns a greeting when it meets the rules.
     *
     * Rules:
     * - The input cannot be null.
     * - Leading and trailing spaces are trimmed.
     * - The resulting value must not be empty.
     * - The first character must be an English alphabet letter (A-Z or a-z).
     * - If the first letter is in the range A–M (case-insensitive), return "Hello <Name>".
     * - If the first letter is in the range N–Z or any rule fails, an IllegalArgumentException is thrown.
     *
     * Exception Handling:
     * The IllegalArgumentException thrown here is not caught in this class.
     * The GlobalExceptionHandler (annotated with @RestControllerAdvice) catches it
     * and converts it into a 400 Bad Request JSON response:
     *     { "error": "Invalid Input" }
     *
     * This keeps the service focused on business logic only.
     *
     * @param name The input value from the request parameter.
     * @return A greeting message like "Hello Alice" if valid.
     * @throws IllegalArgumentException if the input is invalid or starts with N–Z.
     */
    public String evaluateGreeting(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid Input");
        }

        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input");
        }

        char first = trimmed.charAt(0);
        if (!Character.isLetter(first)) {
            throw new IllegalArgumentException("Invalid Input");
        }

        char upper = Character.toUpperCase(first);

        if (upper >= 'A' && upper <= 'M') {
            return "Hello " + capitalize(trimmed);
        }

        throw new IllegalArgumentException("Invalid Input");
    }

    /**
     * Capitalizes only the first character of the given string.
     *
     * @param s A non-null trimmed string.
     * @return Same string with the first character converted to uppercase. This requires to maintain the correct and
     * requried matched output.
     */
    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
