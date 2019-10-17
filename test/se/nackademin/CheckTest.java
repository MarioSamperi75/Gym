package se.nackademin;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {

    Check c1 = new Check("Ingmar Bergman");
    Check c2 = new Check("Super Man");

    LocalDate dateOfTest = LocalDate.of (2019, 10, 14);
    long elapsedTime = Period.between(dateOfTest, LocalDate.now()).getDays();


    @Test
    public void testGetStatus() {
        assertNotEquals(c1.getStatus(LocalDate.of
                (1978, 07, 16).plusDays(elapsedTime)) , "Nuvarande medlem");
        assertEquals(c1.getStatus(LocalDate.of
                (1978, 07, 16).plusDays(elapsedTime)) , "Före detta kund");
        assertEquals(c2.getStatus(LocalDate.of
                (2018, 10, 15).plusDays(elapsedTime)) , "Nuvarande medlem");
    }

    @Test
    public void testCounterUppdate() {
        assertTrue(c1.counterUppdate(0) == 1);
        assertTrue(c1.counterUppdate(35) == 36);
        assertFalse(c1.counterUppdate(0)== 0);
    }

    @Test
    public void testItemIsFound() {
        assertTrue(c1.itemIsFound("8507219173, Mario Samperi", "Mario") == true);
        assertTrue(c1.itemIsFound("8507219173, Mario Samperi", "Ma") == true);
        assertTrue(c1.itemIsFound("8507219173, Mario Samperi", "850721") == true);
        assertTrue(c1.itemIsFound("3608021234, Federico Fellini", "Mario") == false);
        assertFalse(c1.itemIsFound("3608021234, Federico Fellini", "Mario") == true);
            }
}







