package se.nackademin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    Input i1 = new Input();

    @Test
    public void testManageSpaces() {
        assertEquals(i1.manageSpaces("Mario     Samperi"), "Mario Samperi");
        assertEquals(i1.manageSpaces("    Mario     "), "Mario");
        assertEquals(i1.manageSpaces("      Mario        Samperi             "), "Mario Samperi");
        assertNotEquals(i1.manageSpaces("Mario    Samperi"), "Mario    Samperi");
    }

}
