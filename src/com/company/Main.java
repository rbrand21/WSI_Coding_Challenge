package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

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
    }

    private static void printList(List<ZipCodeRange> myList) {
        for(int i=0; i<myList.size(); i++){
            System.out.print("{" + myList.get(i).getStart() + "," + myList.get(i).getEnd() + "}, ");
        }
    }
}
