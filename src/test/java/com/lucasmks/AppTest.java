package com.lucasmks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testCountOccurrencesSimple() throws Exception {
        String text = "hello world hello";
        String target = "hello";

        Method method = App.class.getDeclaredMethod("countOccurrences", String.class, String.class);
        method.setAccessible(true);

        int result = (int) method.invoke(null, text, target);

        assertEquals(2, result);
    }

    @Test
    public void testCountOccurrencesNotFound() throws Exception {
        String text = "bloques de piedra";
        String target = "hello";

        Method method = App.class.getDeclaredMethod("countOccurrences", String.class, String.class);
        method.setAccessible(true);

        int result = (int) method.invoke(null, text, target);

        assertEquals(0, result);
    }

    @Test
    public void testFetchUrlInvalidUrl() throws Exception {
        Method method = App.class.getDeclaredMethod("fetchUrl", String.class);
        method.setAccessible(true);

        try {
            method.invoke(null, "http://urlinvalida.com");
            fail("É esperado um erro ao acessar uma URL inválida");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}