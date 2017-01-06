package com.galvanize;

import com.galvanize.StringUtil;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void findsCharsInBoth() {

        // Setup
        Map<Character,Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);
        StringUtil classUnderTest = new StringUtil();

        // Exercise
        Map<Character,Integer> actual = classUnderTest.charsInBoth("ab", "b");

        // Assert
        assertEquals("takes two strings and returns and object with character counts", expected, actual);

        // Teardown
        // Java GC does this automatically!
    }

}
