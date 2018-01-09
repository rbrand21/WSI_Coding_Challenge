package com.zipchallenge;


/**
 * A class used to better represent the Zip code range. We can use meaningful method names from this class
 * instead of array indexes.
 * This class also contains the code for how comparison happens, which is a great place for it to exist.
 */
public class ZipCodeRange implements Comparable<ZipCodeRange> {
    private int start;
    private int end;

    public ZipCodeRange(int[] zips) {
        checkFormatting(zips);
        setStart(zips[0]);
        setEnd(zips[1]);
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    //If they are equal it doesn't matter which one goes first.
    @Override
    public int compareTo(ZipCodeRange o) {
        if(this.getStart() > o.getStart()){
            return 1;
        }
        else{
            return -1;
        }
    }

    /**
     * Private Methods
     */
    private void checkFormatting(int[] zips) {
        checkArraySize(zips);
        checkOrdering(zips);
    }

    private void checkArraySize(int[] zips) {
        if(zips.length != 2){
            throw new IllegalArgumentException("Must pass in valid range with size of 2");
        }
    }

    private void checkOrdering(int[] zips) {
        if(zips[0] > zips[1]){
            throw new IllegalArgumentException("Range not valid, must be in format of (min - max)");
        }
    }

}
