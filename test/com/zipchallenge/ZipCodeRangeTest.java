package com.zipchallenge;

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
        ZipCodeRange z = new ZipCodeRange(lower, upper);

        return z;
    }

    @Test
    void compareZipCodes(){
        ZipCodeRange smallZip = getZipCodeRange(93644, 95817);
        ZipCodeRange largeZip = getZipCodeRange(95817, 95817);

        assertEquals(-1, smallZip.compareTo(largeZip));
    }

    @Test
    public void lowerGreaterThanUpper(){
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCodeRange z = new ZipCodeRange(95000, 9600);
        }, ZipCodeRange.FIRST_LESS_THAN_SECOND_MESSAGE);
    }

}