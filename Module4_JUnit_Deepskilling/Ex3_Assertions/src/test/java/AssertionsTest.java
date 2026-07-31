import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AssertionsTest {

    private Student passedStudent;
    private Student failedStudent;

    @Before
    public void init() {
        passedStudent = new Student(1, "Priyatosh", 85.5);
        failedStudent = new Student(2, "Riya", 30.0);
    }

    @Test
    public void testAssertEquals() {
        assertEquals(5, 2 + 3);
        assertEquals("B", passedStudent.getGrade());
        assertEquals(1, passedStudent.getId());
    }

    @Test
    public void testAssertTrue() {
        assertTrue(5 > 3);
        assertTrue(passedStudent.hasPassed());
        assertTrue(passedStudent.getMarks() > 40);
    }

    @Test
    public void testAssertFalse() {
        assertFalse(5 < 3);
        assertFalse(failedStudent.hasPassed());
        assertFalse(passedStudent.getName().isEmpty());
    }

    @Test
    public void testAssertNull() {
        String name = null;
        assertNull(name);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object());
        assertNotNull(passedStudent);
        assertNotNull(passedStudent.getName());
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertEqualsWithDelta() {
        assertEquals(85.5, passedStudent.getMarks(), 0.001);
    }

    @Test
    public void testFailedStudentGrade() {
        assertEquals("F", failedStudent.getGrade());
        assertFalse(failedStudent.hasPassed());
    }
}
