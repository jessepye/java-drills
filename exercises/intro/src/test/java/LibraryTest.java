import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        assertEquals("getLetterCounts", expected, actual);

        // Teardown
        // The Java GC takes care of this for us!
    }

    @Test
    public void constructor() {
        // Setup
        String[] expected = new String[] {"best", "pals"};
        Library library = new Library(new String[] {"best", "pals"});

        // Exercise
        String[] actual = library.wordList;

        // Assert
        assertArrayEquals(expected, actual);

        // Teardown
        // The Java GC takes care of this for us!
    }

    @Test
    public void getLetterCounts_returnsListOfLettersInEachWord() {
        List<Integer> expected = Arrays.asList(4, 4);
        Library library = new Library(new String[] {"best", "pals"});

        List<Integer> actual = library.getLetterCounts();

        assertEquals(expected, actual);
        assertEquals(expected, actual);
    }

    @Test
    public void getLetterCounts_putsNegativeOneInListWhenCertainWordsAreProvided() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(-1,-1,-1,6));

        Library library = new Library(new String[] {"secret", "hidden", "shhh", "abcdef"});
        List<Integer> actual = library.getLetterCounts();

        assertEquals(expected, actual);
    }
}
