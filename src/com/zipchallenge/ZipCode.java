package com.zipchallenge;

/**
 * Defines what a valid ZipCode is. This is a standard 5 digit zip.
 */
public class ZipCode {
    protected int value;
    public static final String INVALID_5_DIGIT_ZIP_RANGE = "Please input valid 5 digit zip codes";

    public ZipCode(int value) {
        checkValidZipCode(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        checkValidZipCode(value);
        this.value = value;
    }

    /**
     * Zipcodes should be a valid 5 digit range ranging from 10000 - 99999
     * @param value The value to be tested.
     */
    protected void checkValidZipCode(int value) {
        if(value < 10000 || value > 99999){
            throw new IllegalArgumentException(INVALID_5_DIGIT_ZIP_RANGE);
        }
    }

    public static String getRegex() {
        return "-?\\d+";
    }
}
