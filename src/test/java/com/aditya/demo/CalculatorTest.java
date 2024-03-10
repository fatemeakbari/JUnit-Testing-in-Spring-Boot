package com.aditya.demo;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd(){
        // Given
        Calculator calculator = new Calculator();
        // When
        int actual = calculator.add(2, 3);
        // Then
        int expected = 5;
        assertEquals(expected, actual);
    }
}

