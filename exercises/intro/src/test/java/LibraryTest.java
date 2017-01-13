import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void getLetterCountsShouldReturnValidNumber() {

        // Setup
        String[] args = new String[] {"hi", "there", "world!"};
        Library library = new Library(args);
        List<Integer> expected = Arrays.asList(2,5,6);

        // Exercise
        List<Integer> actual = library.getLetterCounts();

        // Assert
        Assert.assertEquals("getLetterCounts", expected, actual);

        // Teardown
        // The Java GC takes care of this for us!
    }

}
