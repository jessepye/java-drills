import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HospitalTest {
    @Test
    public void isPatientAdmitted() {

        // Setup
        Patient p1 = new Patient("John", "Doe");
        Patient p2 = new Patient("Jane", "Doe");
        Patient p3 = new Patient("Billy", "Bob");
        Hospital classUnderTest = new Hospital(Arrays.asList(p1, p2, p3));

        // Exercise
        boolean result1 = classUnderTest.isPatientAdmitted("John", "Doe");
        boolean result2 = classUnderTest.isPatientAdmitted("Jane", "Doe");
        boolean result3 = classUnderTest.isPatientAdmitted("Billy", "Bob");
        boolean result4 = classUnderTest.isPatientAdmitted("John", "Smith");

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);

        // Teardown
        // Java GC does this automatically!
    }

}
