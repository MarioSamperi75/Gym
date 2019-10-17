

package se.nackademin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {

    Splitter s1 = new Splitter("7507219173, Mario Samperi");
    Splitter s2 = new Splitter("7507219173,           Mario Samperi");

    @Test
    public void testGetName() {
        assertNotEquals(s1.getName(), "Maria Samperi");
        assertEquals(s1.getName(), "Mario Samperi");
        assertEquals(s2.getName(), "Mario Samperi");

    }

}


