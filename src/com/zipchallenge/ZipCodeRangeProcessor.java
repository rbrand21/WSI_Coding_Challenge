package com.zipchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeRangeProcessor {

    final String NON_EMPTY_STRING_MESSAGE = "Please input a non-empty string";
    final String ODD_NUMBER_OF_NUMBERS_MESSAGE = "Please input an even number of zip codes (ranges)";

    public ZipCodeRangeProcessor() {

    }

    public List<ZipCodeRange> readZipCodesFromInput(String s) {
        List<Integer> numbers;
        List<ZipCodeRange> zips;

        checkInput(s);

        numbers = parseInputForNumbers(s);

        checkNumbers(numbers);

        zips = convertNumbersToZips(numbers);

        return zips;
    }

    private void checkInput(String s) {
        if(s.isEmpty()){
            throw new IllegalArgumentException(NON_EMPTY_STRING_MESSAGE);
        }
    }

    private void checkNumbers(List<Integer> numbers) {
        if(numbers.size() % 2 != 0){
            throw new IllegalArgumentException(ODD_NUMBER_OF_NUMBERS_MESSAGE);
        }
    }

    private List<Integer> parseInputForNumbers(String s) {
        List<Integer> numbers = new ArrayList<>();

        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(s);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }

        return numbers;
    }

    private List<ZipCodeRange> convertNumbersToZips(List<Integer> numbers) {
        List<ZipCodeRange> zips = new ArrayList<>();

        for (int i=0; i<numbers.size(); i+=2){
            ZipCodeRange z = new ZipCodeRange(numbers.get(i), numbers.get(i+1));
            zips.add(z);
        }

        return zips;
    }
}
