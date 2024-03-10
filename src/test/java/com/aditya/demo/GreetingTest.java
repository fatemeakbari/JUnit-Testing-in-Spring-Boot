package com.aditya.demo;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @Test
    public void testGreet(){
        //Given
        Greeting greeting = new Greeting();
        String actual = "Hello";
        //When
        String expected = greeting.greet();

        //Then
        assertEquals(actual, expected);
    }
}
