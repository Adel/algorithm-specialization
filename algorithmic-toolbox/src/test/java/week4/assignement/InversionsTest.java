package week4.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InversionsTest {

    @Test public void shouldSortAndCountInversions(){
        assertEquals(0,Inversions.getNumberOfInversions(new long[]{1}));
    }
    @Test public void shouldSortAndCountInversions2(){
        assertEquals(0,Inversions.getNumberOfInversions(new long[]{1,2,3,4,5,6}));
    }
    @Test public void shouldSortAndCountInversions3(){
        assertEquals(15,Inversions.getNumberOfInversions(new long[]{6,5,4,3,2,1}));
    }

}