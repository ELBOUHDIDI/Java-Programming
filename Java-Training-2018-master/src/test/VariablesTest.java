package test;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VariablesTest {

    // More info: https://tutorialspoint.com/junit/junit_using_assertion.htm

    @Test
    public void testingVariables() {
        int a = 100;
        assertEquals(100, a);

        a *= 2;
        assertEquals(200, a);

        String hello = "Hello World!";
        assertEquals("Hello World!", hello);

        hello = hello.concat(" What are you doing?");
        assertEquals("Hello World! What are you doing?", hello);

        int[] array = {1, 2, 3, 4};
        array[0] += 49;
        int[] expected = {50, 2, 3, 4};
        assertArrayEquals(expected, array);
        assertEquals(4, array.length);

        String subHello = hello.substring(0,5);
        assertEquals("Hello", subHello);
    }
}
