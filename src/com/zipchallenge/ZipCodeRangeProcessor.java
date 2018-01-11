package com.zipchallenge;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The ZipCodeRangeProcessor is responsible for parsing the input string for numbers,
 * verifying that the number of numbers input looks like they could be ZipCodeRanges,
 * and returning a List back to the caller.
 * For the actual verification of valid ZipCodeRanges, see ZipCodeRange.
 */
public class ZipCodeRangeProcessor {

    final String NON_EMPTY_STRING_MESSAGE = "Please input a non-empty string";
    final String INCORRECT_NUMBER_OF_NUMBERS_MESSAGE = "Please input a nonzero even number of zip codes (ranges)";

    public ZipCodeRangeProcessor() {

    }

    /**
     * Parse the incoming string for numbers, check that the amount of numbers is correct,
     * and convert them to ZipCodeRanges.
     * @param s The string to parse for numbers
     * @return Extracted ZipCodeRanges from the passed in string.
     */
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
        if(numbers.size() % 2 != 0 || numbers.size() == 0){
            throw new IllegalArgumentException(INCORRECT_NUMBER_OF_NUMBERS_MESSAGE);
        }
    }

    /**
     * Use Pattern and Matcher class so that we can use regex in matching on our string
     * @param s The string we're parsing for numbers
     * @return List of numbers that were parsed
     */
    private List<Integer> parseInputForNumbers(String s) {
        List<Integer> numbers = new ArrayList<>();

        Pattern p = Pattern.compile(ZipCode.getRegex());
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
