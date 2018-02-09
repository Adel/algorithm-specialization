package week3.assignment;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeTest {

    @Test
    public void getChange() {
        assertEquals(2, Change.getChange(2));
        assertEquals(6, Change.getChange(28));

    }
}