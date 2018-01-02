package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Example usage:

        //First create the components to do the minimization
        ZipCodeRangeConverter zip_converter = new ZipCodeRangeConverter();
        ZipCodeMinimizer zip_minimizer = new ZipCodeMinimizer();


        //Now create the list of zipcodes to pass in
        List<int[]> myList = new ArrayList<>();
        List<ZipCodeRange> myConvertedList;
        int[] zip_code1 = new int[]{95817, 96000};
        int[] zip_code2 = new int[]{95863, 97000};
        int[] zip_code3 = new int[]{98172, 99182};
        myList.add(zip_code1);
        myList.add(zip_code2);
        myList.add(zip_code3);

        myConvertedList = zip_converter.convertFromRawZipCodes(myList);

        myConvertedList = zip_minimizer.getMinimizedZipCodes(myConvertedList);

        _printList(myConvertedList);
    }

    private static void _printList(List<ZipCodeRange> myList) {
        for(int i=0; i<myList.size(); i++){
            System.out.print("{" + myList.get(i).getStart() + "," + myList.get(i).getEnd() + "}, ");
        }
    }
}
