package seedu.trackermon.model.show;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.trackermon.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid name
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Name.isValidName("you*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Name.isValidName("You")); // alphabets only
        assertTrue(Name.isValidName("007")); // numbers only
        assertTrue(Name.isValidName("Peter the 2nd")); // alphanumeric characters
        assertTrue(Name.isValidName("YoU")); // with capital letters
        assertTrue(Name.isValidName("The Time I Got Bang Down by Truck kun")); // long names
    }

    @Test
    void testToString() {
        Name testName = new Name("Another");
        assertEquals("Another", testName.fullName);
    }

    @Test
    void testEquals() {
        Name testName = new Name("Another");
        assertTrue(testName.equals(testName));
    }

    @Test
    void testHashCode() {
        Name testName = new Name("Another");
        assertEquals("Another".hashCode(), testName.hashCode());
    }

    @Test
    void compareTo() {
        Name testName = new Name("Another");
        assertEquals(0, testName.compareTo(new Name("ANOTHER")));
    }
}
