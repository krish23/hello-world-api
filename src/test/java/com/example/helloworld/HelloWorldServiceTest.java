package com.example.helloworld;

import com.example.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldServiceTest {

    private final HelloWorldService service = new HelloWorldService();

    //Handled all the cases plus edge cases for unittest.

    @Test
    void validFirstHalfLowercase() {
        assertEquals("Hello Alice", service.evaluateGreeting("alice"));
    }

    @Test
    void validFirstHalfUppercase() {
        assertEquals("Hello Alice", service.evaluateGreeting("Alice"));
    }

    @Test
    void validBoundaryM() {
        assertEquals("Hello Mary", service.evaluateGreeting("mary"));
    }

    @Test
    void invalidBoundaryN() {
        assertThrows(IllegalArgumentException.class, () -> service.evaluateGreeting("nancy"));
    }

    @Test
    void invalidSecondHalfUppercase() {
        assertThrows(IllegalArgumentException.class, () -> service.evaluateGreeting("Zoe"));
    }

    @Test
    void trimWhitespaceInput() {
        assertEquals("Hello Alice", service.evaluateGreeting("   alice   "));
    }

    @Test
    void emptyInput() {
        assertThrows(IllegalArgumentException.class, () -> service.evaluateGreeting(""));
    }

    @Test
    void whitespaceOnly() {
        assertThrows(IllegalArgumentException.class, () -> service.evaluateGreeting("   "));
    }

    @Test
    void nonLetterFirstChar() {
        assertThrows(IllegalArgumentException.class, () -> service.evaluateGreeting("1alice"));
    }

    @Test
    void singleValidLetter() {
        assertEquals("Hello A", service.evaluateGreeting("a"));
    }

    @Test
    void singleInvalidLetter() {
        assertThrows(IllegalArgumentException.class, () -> service.evaluateGreeting("z"));
    }
}
