package com.zipchallenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeMinimizerTest {

    List<ZipCodeRange> minimizedList;
    List<ZipCodeRange> testList;
    ZipCodeMinimizer zipCodeMinimizer;

    @BeforeEach
    void setUp() {
        testList = new ArrayList<>();
        zipCodeMinimizer = new ZipCodeMinimizer();
    }

    @AfterEach
    void tearDown() {
    }

    private void addZipCodeRange(int lower, int upper) {
        testList.add(new ZipCodeRange(lower, upper));
    }

    @Test
    void returnValue() {
        addZipCodeRange(93644, 94817);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(1, minimizedList.size());
    }

    @Test
    void twoZipCodesNotOverlappingRange(){
        addZipCodeRange(93644, 94817);
        addZipCodeRange(95816, 95817);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(2, minimizedList.size());
    }

    @Test
    void twoZipCodesWithOverlappingRange(){
        addZipCodeRange(93644, 94817);
        addZipCodeRange(93644, 95817);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(1, minimizedList.size());
        assertEquals(93644, minimizedList.get(0).getStart());
        assertEquals(95817, minimizedList.get(0).getEnd());
    }

    @Test
    void threeZipCodesWithNotOverlappingRange(){
        addZipCodeRange(93644, 94817);
        addZipCodeRange(95816, 95817);
        addZipCodeRange(95820, 96344);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(3, minimizedList.size());
    }

    @Test
    void threeZipCodesWithAllOverlappingRange(){
        addZipCodeRange(93644, 94817);
        addZipCodeRange(93644, 94000);
        addZipCodeRange(94100, 97817);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(1, minimizedList.size());
        assertEquals(93644, minimizedList.get(0).getStart());
        assertEquals(97817, minimizedList.get(0).getEnd());
    }

    @Test
    void threeZipCodesWithOnlyTwoOverlappingRange(){
        addZipCodeRange(93644, 94817);
        addZipCodeRange(94819, 95817);
        addZipCodeRange(95000, 97817);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(2, minimizedList.size());
        //The first one should go from 93644 - 94817
        assertEquals(93644, minimizedList.get(0).getStart());
        assertEquals(94817, minimizedList.get(0).getEnd());
        //Second range should go from 94819 - 97817
        assertEquals(94819, minimizedList.get(1).getStart());
        assertEquals(97817, minimizedList.get(1).getEnd());
    }

    @Test
    void outOfOrderZipCodes(){
        addZipCodeRange(95000, 97817);
        addZipCodeRange(93644, 94817);
        addZipCodeRange(94819, 95817);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(2, minimizedList.size());
        //The first one should go from 93644 - 94817
        assertEquals(93644, minimizedList.get(0).getStart());
        assertEquals(94817, minimizedList.get(0).getEnd());
        //Second range should go from 94819 - 97817
        assertEquals(94819, minimizedList.get(1).getStart());
        assertEquals(97817, minimizedList.get(1).getEnd());
    }

    @Test
    void borderingRanges(){
        addZipCodeRange(95000, 97817);
        addZipCodeRange(97818, 98000);

        minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);

        assertEquals(1, minimizedList.size());
        assertEquals(95000, minimizedList.get(0).getStart());
        assertEquals(98000, minimizedList.get(0).getEnd());
    }

    @Test
    public void emptyListGetMinimizedZipCodes(){
        assertThrows(IllegalArgumentException.class, () ->{
            minimizedList = zipCodeMinimizer.getMinimizedZipCodes(testList);
        }, zipCodeMinimizer.NON_EMPTY_LIST_MESSAGE);
    }

    @Test
    public void nullListGetMinimizedZipCodes(){
        assertThrows(IllegalArgumentException.class, () ->{
            minimizedList = zipCodeMinimizer.getMinimizedZipCodes(null);
        }, zipCodeMinimizer.NON_NULL_LIST_MESSAGE12345);
    }
}