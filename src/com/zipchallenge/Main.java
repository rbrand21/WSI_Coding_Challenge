package com.zipchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ZipCodeRangeProcessor zipProcessor = new ZipCodeRangeProcessor();
        ZipCodeMinimizer zipMinimizer = new ZipCodeMinimizer();
        String input = null;

        System.out.print("Please enter your list of ZipCodes to be minimized: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        List<ZipCodeRange> zipCodes = zipProcessor.readZipCodesFromInput(input);

        zipCodes = zipMinimizer.getMinimizedZipCodes(zipCodes);

        printList(zipCodes);

    }

    private static void printList(List<ZipCodeRange> myList) {

        System.out.print("The minimized ZipCode list is: ");

        for(int i=0; i<myList.size(); i++){
            if (i == myList.size()-1){
                System.out.print("[" + myList.get(i).getStart() + ", " + myList.get(i).getEnd() + "]");
            }
            else {
                System.out.print("[" + myList.get(i).getStart() + ", " + myList.get(i).getEnd() + "], ");
            }
        }
    }
}
