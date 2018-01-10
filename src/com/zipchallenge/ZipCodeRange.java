package com.zipchallenge;


/**
 * A class used to better represent the Zip code range. We can use meaningful method names from this class
 * instead of array indexes.
 * This class also contains the code for how comparison happens, which is a great place for it to exist.
 */
public class ZipCodeRange implements Comparable<ZipCodeRange> {
    public static final String FIRST_LESS_THAN_SECOND_MESSAGE = "The first number of the range must be less than the second";
    public static final String INVALID_5_DIGIT_ZIP = "Please input valid 5 digit zip codes";
    private int start;
    private int end;

    public ZipCodeRange(int lower, int upper){
        checkLowerLessThanUpper(lower, upper);
        checkValidZipCodes(lower, upper);
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
    private void checkLowerLessThanUpper(int lower, int upper) {
        if(lower > upper){
            throw new IllegalArgumentException(FIRST_LESS_THAN_SECOND_MESSAGE);
        }
    }

    private void checkValidZipCodes(int lower, int upper) {
        if(String.valueOf(lower).length() < 5 || String.valueOf(upper).length() < 5){
            throw new IllegalArgumentException(INVALID_5_DIGIT_ZIP);
        }
    }
    
}
