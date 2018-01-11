package com.zipchallenge;


/**
 * A class used to better represent the Zip code range. We can use meaningful method names from this class
 * instead of array indexes.
 * ZipCodeRange contains all of the error and invalid ZipCode checks (negative numbers, etc...).
 */
public class ZipCodeRange implements Comparable<ZipCodeRange> {
    public static final String FIRST_LESS_THAN_SECOND_MESSAGE = "The first number of the range must be less than the second";
    private int start;
    private int end;

    public ZipCodeRange(int lower, int upper){
        checkLowerLessThanUpper(lower, upper);
        setStart(lower);
        setEnd(upper);
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

    /**
     * Define how to compare two ZipCodeRanges.
     * The algorithm used in ZipCodeMinimizer assumes that the
     * starting range is always increasing after it has been sorted.
     * @param o
     * @return
     */
    @Override
    public int compareTo(ZipCodeRange o) {
        if(this.getStart() > o.getStart()){
            return 1;
        }
        else{
            return -1;
        }
    }

    private void checkLowerLessThanUpper(int lower, int upper) {
        if(lower > upper){
            throw new IllegalArgumentException(FIRST_LESS_THAN_SECOND_MESSAGE);
        }
    }
}
