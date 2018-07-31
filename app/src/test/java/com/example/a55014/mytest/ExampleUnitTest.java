package com.example.a55014.mytest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void print_dimens() {
        for (int i = 1; i < 2000; i++) {
            System.out.print("<dimen name=\"dimen_" + i + "px\">" + (float) i / 2 + "dp</dimen>\n");
        }
    }
}