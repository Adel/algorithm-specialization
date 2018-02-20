package week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeDPTest {

    @Test
    void shouldReturnCorrectChangeForOneElement() {
        assertEquals(2, ChangeDP.getChange(2));
    }

    @Test
    void shouldReturnCorrectChangeForOneCoin() {
        assertEquals(1, ChangeDP.getChange(1));
        assertEquals(1, ChangeDP.getChange(3));
        assertEquals(1, ChangeDP.getChange(4));
    }

    @Test
    void shouldReturnCorrectChange1() {
        assertEquals(2, ChangeDP.getChange(6));
    }

    @Test
    void shouldReturnCorrectChange2() {
        assertEquals(9, ChangeDP.getChange(34));
    }
}