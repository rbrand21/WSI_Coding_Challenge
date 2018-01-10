package com.zipchallenge;

import java.util.ArrayList;
import java.util.List;

public class ZipCodeRangeProcessor {
    public ZipCodeRangeProcessor() {

    }


    public List<ZipCodeRange> readZipCodesFromInput(String s) {
        List<Integer> numbers;
        List<ZipCodeRange> zips;

        numbers = getListOfNumbersFromInput();

        zips = convertNumbersToZips(numbers);

        return zips;
    }

    private List<Integer> getListOfNumbersFromInput() {
        List<Integer> numbers = new ArrayList<>();

        return numbers;
    }

    private List<ZipCodeRange> convertNumbersToZips(List<Integer> numbers) {
        List<ZipCodeRange> zips = new ArrayList<>();

        return zips;
    }
}
