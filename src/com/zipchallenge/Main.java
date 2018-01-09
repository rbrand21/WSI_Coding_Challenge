package com.zipchallenge;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        //Example usage:

        //First create the components to do the minimization
        ZipCodeRangeConverter zipConverter = new ZipCodeRangeConverter();
        ZipCodeMinimizer zipMinimizer = new ZipCodeMinimizer();


        //Now create the list of zipcodes to pass in
        List<int[]> myList = new ArrayList<>();
        List<ZipCodeRange> myConvertedList;
        int[] zipCode1 = new int[]{95817, 96000};
        int[] zipCode2 = new int[]{95863, 97000};
        int[] zipCode3 = new int[]{98172, 99182};
        myList.add(zipCode1);
        myList.add(zipCode2);
        myList.add(zipCode3);

        myConvertedList = zipConverter.convertFromRawZipCodes(myList);

        myConvertedList = zipMinimizer.getMinimizedZipCodes(myConvertedList);

        printList(myConvertedList);

        String input = null;
        int number = 0;




        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(input);
        while (m.find()) {

            numbers.add(Integer.parseInt(m.group()));
        }
        for (Integer num : numbers){
            System.out.print(num);
        }

        myConvertedList.clear();
        //First check to make sure this doesn't go out of bounds
        for (int i=0; i<numbers.size(); i+=2){
            ZipCodeRange z = new ZipCodeRange(numbers.get(i), numbers.get(i+1));
            myConvertedList.add(z);
        }

        myConvertedList = zipMinimizer.getMinimizedZipCodes(myConvertedList);

        printList(myConvertedList);
//        System.out.print(numbers);
    }

    private static void printList(List<ZipCodeRange> myList) {
        for(int i=0; i<myList.size(); i++){
            if (i == myList.size()-1){
                System.out.print("{" + myList.get(i).getStart() + ", " + myList.get(i).getEnd() + "}");
            }
            else {
                System.out.print("{" + myList.get(i).getStart() + ", " + myList.get(i).getEnd() + "}, ");
            }
        }
    }
}
