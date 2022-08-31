package c_stream.app.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExamples {

    @Test
    public void whenAssertingEquality_thenEqual(){
        String expected = "Baeldung";
        String actual = "Baeldungsd";

        assertEquals(expected, actual,"iki değer eşit değildir");
    }
    @Test
    @DisplayName("İki ifadenin eşitliği")
    void whenAssertingEqualityWithDelta_thenEqual() {
        float square = 2 * 2;
        float rectangle = 3 * 2;
        float delta = 2;

        assertEquals(square, rectangle, delta);
    }

    @Test
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
        char[] actual = "Jupiter".toCharArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    public void whenAssertingNull_thenTrue() {
        Object car = null;

        assertNull(car, () -> "The car should be null");
    }


    @Test
    public void whenAssertingNotSameObject_thenDifferent() {
        Object cat = new Object();
        Object dog = new Object();

        assertNotSame(cat, dog);
    }

    @Test
    void whenAssertingSameObject_thenSuccessfull() {
        String language = "Java";
        Optional<String> optional = Optional.of(language);

        assertSame(language, optional.get());
    }

    @Test
    public void whenAssertingConditions_thenVerified() {
        assertTrue(5 > 4, "5 is greater then 4");
        assertFalse(5 > 6, "5 is not greater then 6");
    }

    @Test
    void givenMultipleAssertion_whenAssertingAll_thenOK() {
        Object obj = null;
        assertAll(
                "heading",
                () -> assertEquals(6, 2 * 3, "4 is 2 times 2"),
                () -> assertEquals("java", "JAVA".toLowerCase()),
                () -> assertNull(obj, "obj is null")
        );
    }

    @Test
    void whenAssertingEquality_thenNotEqual() {
        Integer value = 5; // result of an algorithm

        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds(){
        Exception exception = assertThrows(NumberFormatException.class ,
                ()->{Integer.parseInt("1a");});

        String expectedMessage = "For input string";
        String actualMessage=exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void whenDerivedExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenAritmeticExceptionThrown_thenAssertionSucceeds(){
        Exception exception = assertThrows(ArithmeticException.class,()->{
            double num = 10 / 0;
        });

        String expectedMessage = "zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }



    @Test
    void whenAssertingException_thenThrown() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Exception message");
                }
        );
        assertEquals("Exception message", exception.getMessage());
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testDivide(){
        assertThrows(ArithmeticException.class,()-> {double num= 2/0;},"sayı sıfıra bölünemez");
    }


}
