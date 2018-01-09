package com.zipchallenge.Tests;

import com.zipchallenge.ZipCodeRange;
import com.zipchallenge.ZipCodeRangeConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeRangeConverterTest {

    ZipCodeRangeConverter converter;
    List<ZipCodeRange> zipCodeList;
    List<int[]> arrayZipList;
    @BeforeEach
    void setUp() {
        converter = new ZipCodeRangeConverter();
        zipCodeList = new ArrayList<>();
        arrayZipList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void convertFromRaw(){
        arrayZipList.add(new int[]{9400, 9600});

        zipCodeList = converter.convertFromRawZipCodes(arrayZipList);

        assertEquals(9400, zipCodeList.get(0).getStart());
        assertEquals(9600, zipCodeList.get(0).getEnd());

    }

    @Test
    public void convertToRaw(){
        zipCodeList.add(new ZipCodeRange(new int[]{9400, 9600}));

        arrayZipList = converter.convertToRawZipCodes(zipCodeList);

        assertEquals(9400, arrayZipList.get(0)[0]);
        assertEquals(9600, arrayZipList.get(0)[1]);

    }
}