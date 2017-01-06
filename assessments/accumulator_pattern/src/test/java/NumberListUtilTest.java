import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NumberListUtilTest {
    @Test
    public void returnsAnEmptyArrayIfAllSame() {

        // Setup
        List<Integer> expected = new ArrayList<>();
        NumberListUtil classUnderTest = new NumberListUtil();
        List<Integer> a = Arrays.asList(1,2,3,4,5);
        List<Integer> b = Arrays.asList(2,3,1,4,5);

        // Exercise
        List<Integer> actual = classUnderTest.findMissingNumbers(a, b);

        // Assert
        assertEquals("returns an empty array when the arrays contain the same numbers", expected, actual);

        // Teardown
        // Java GC does this automatically!
    }

    @Test
    public void findsMissingNumbers() {

        // Setup
        List<Integer> expected1 = Arrays.asList(4);
        List<Integer> expected2 = Arrays.asList(4,5);
        NumberListUtil classUnderTest = new NumberListUtil();

        // Exercise
        List<Integer> actual1 = classUnderTest.findMissingNumbers(Arrays.asList(1,2,3,4,5), Arrays.asList(2,3,1,0,5));
        List<Integer> actual2 = classUnderTest.findMissingNumbers(Arrays.asList(1,2,3,4,5), Arrays.asList(2,3,1));

        // Assert
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

        // Teardown
        // Java GC does this automatically!
    }
}
