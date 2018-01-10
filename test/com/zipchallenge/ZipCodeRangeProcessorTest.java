package com.zipchallenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeRangeProcessorTest {

    ZipCodeRangeProcessor processor;
    List<ZipCodeRange> zipList;

    @BeforeEach
    void setUp() {
        processor = new ZipCodeRangeProcessor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void singlePairInput() {
        String s = "[95000, 96000]";

        zipList = processor.readZipCodesFromInput(s);

        assertEquals(95000, zipList.get(0).getStart());
        assertEquals(96000, zipList.get(0).getEnd());
    }

    @Test
    void multiPairInput() {
        String s = "[95000, 96000], [95500, 96500]";

        zipList = processor.readZipCodesFromInput(s);

        assertEquals(95500, zipList.get(1).getStart());
        assertEquals(96500, zipList.get(1).getEnd());
    }

    @Test
    void emptyInput() {
        String s = "";

        assertThrows(IllegalArgumentException.class, () -> {
                    zipList = processor.readZipCodesFromInput(s);
                }, processor.NON_EMPTY_STRING_MESSAGE
        );
    }

    @Test
    void oddNumberOfNumbers() {
        String s = "[95000, ]";

        assertThrows(IllegalArgumentException.class, () -> {
                    zipList = processor.readZipCodesFromInput(s);
                }, processor.INCORRECT_NUMBER_OF_NUMBERS_MESSAGE
        );
    }

    @Test
    public void noNumbers(){
        String s = "\n";

        assertThrows(IllegalArgumentException.class, () -> {
                    zipList = processor.readZipCodesFromInput(s);
                }, processor.INCORRECT_NUMBER_OF_NUMBERS_MESSAGE
        );
    }
}