package week2.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCMTest {

    @Test
    public void lcm() {
        assertEquals(24, LCM.lcm(6, 8));
        assertEquals(1933053046, LCM.lcm(28851538, 1183019));
    }
}