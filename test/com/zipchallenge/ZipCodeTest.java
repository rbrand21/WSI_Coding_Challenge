package com.zipchallenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ZipCodeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void validZipCode(){
        ZipCode z = new ZipCode(10000);

        assertEquals(10000, z.getValue());
    }

    @Test
    public void invalidZipCode(){

        assertThrows(IllegalArgumentException.class, () ->{
            ZipCode z = new ZipCode(500);
        }, ZipCode.INVALID_5_DIGIT_ZIP_RANGE);
    }

    @Test
    public void negativeNumber(){
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCode z = new ZipCode(-95000);
        }, ZipCode.INVALID_5_DIGIT_ZIP_RANGE);
    }

    @Test
    public void correctNumberOfDigitsButOutOfRange(){
        assertThrows(IllegalArgumentException.class, ()->{
            ZipCode z = new ZipCode(00001);
        }, ZipCode.INVALID_5_DIGIT_ZIP_RANGE);
    }
}