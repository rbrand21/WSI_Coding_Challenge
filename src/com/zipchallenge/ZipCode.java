package com.zipchallenge;

public class ZipCode {
    private int value;
    public static final String INVALID_5_DIGIT_ZIP_RANGE = "Please input valid 5 digit zip codes";

    public ZipCode(int value) {
        checkValidZipcode(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Zipcodes should be a valid 5 digit range ranging from 10000 - 99999
     * @param value The value to be tested.
     */
    private void checkValidZipcode(int value) {
        if(value < 10000 || value > 99999){
            throw new IllegalArgumentException(INVALID_5_DIGIT_ZIP_RANGE);
        }
    }
}
