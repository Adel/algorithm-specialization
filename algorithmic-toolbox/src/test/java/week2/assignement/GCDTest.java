package week2.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GCDTest {

    @Test
    public void gcd() {
        assertEquals(1, GCD.gcd(18,35));
        assertEquals(17657, GCD.gcd(28851538, 1183019));
    }
}