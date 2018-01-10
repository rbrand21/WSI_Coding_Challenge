package com.zipchallenge;

import com.zipchallenge.ZipCodeRange;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeRangeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private ZipCodeRange getZipCodeRange(int lower, int upper) {
        int[] zipRange = new int[]{lower, upper};

        ZipCodeRange z = new ZipCodeRange(zipRange);

        return z;
    }

    @Test
    void instantiateWithArray(){
        ZipCodeRange z = getZipCodeRange(93644, 95817);

        assertEquals(93644, z.getStart());
        assertEquals(95817, z.getEnd());
    }

    @Test
    void compareZipCodes(){
        ZipCodeRange smallZip = getZipCodeRange(93644, 95817);
        ZipCodeRange largeZip = getZipCodeRange(95817, 95817);

        assertEquals(-1, smallZip.compareTo(largeZip));
    }

    @Test
    public void incorrectArraySizeInstantiation(){
        int[] zipRange = new int[]{95817};
        assertThrows(IllegalArgumentException.class, ()->{
           ZipCodeRange z = new ZipCodeRange(zipRange);
        });
    }

    @Test
    public void mixedOrderInstantiation(){
        int[] zipRange = new int[]{95000, 94000};
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCodeRange z = new ZipCodeRange(zipRange);
        });
    }

    @Test
    public void lowerGreaterThanUpper(){
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCodeRange z = new ZipCodeRange(95000, 9600);
        }, ZipCodeRange.FIRST_LESS_THAN_SECOND_MESSAGE);
    }

    @Test
    public void incorrectNumberOfDigits(){
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCodeRange z = new ZipCodeRange(9500, 9600);
        }, ZipCodeRange.INVALID_5_DIGIT_ZIP);
    }
}