package com.company.Tests;

import com.company.ZipCodeRange;
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

    private ZipCodeRange _getZipCodeRange(int lower, int upper) {
        int[] zip_range = new int[]{lower, upper};

        ZipCodeRange z = new ZipCodeRange(zip_range);

        return z;
    }

    @Test
    void instantiateWithArray(){
        ZipCodeRange z = _getZipCodeRange(93644, 95817);

        assertEquals(93644, z.getStart());
        assertEquals(95817, z.getEnd());
    }

    @Test
    void compareZipCodes(){
        ZipCodeRange small_z = _getZipCodeRange(93644, 95817);
        ZipCodeRange large_z = _getZipCodeRange(95817, 95817);

        assertEquals(-1, small_z.compareTo(large_z));
    }

    @Test
    public void incorrectArraySizeInstantiation(){
        int[] zip_range = new int[]{95817};
        assertThrows(IllegalArgumentException.class, ()->{
           ZipCodeRange z = new ZipCodeRange(zip_range);
        });
    }

    @Test
    public void mixedOrderInstantiation(){
        int[] zip_range = new int[]{95000, 94000};
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCodeRange z = new ZipCodeRange(zip_range);
        });
    }
}