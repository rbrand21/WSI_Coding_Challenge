package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class that translates to and from the raw zip code structure into a more
 * easily consumable object, ZipCodeRange.
 */
public class ZipCodeRangeConverter{

    /**
     * Obtain a converted list of user defined zip code ranges.
     * @param rawZips The collection of raw formatted zip code ranges
     * @return The collection of more consumable zip code ranges.
     */
    public List<ZipCodeRange> convertFromRawZipCodes(List<int[]> rawZips) {
        List<ZipCodeRange> convertedZips = new ArrayList<>();

        for(int i=0; i< rawZips.size(); i++){
            ZipCodeRange zip = new ZipCodeRange(rawZips.get(i));
            convertedZips.add(zip);
        }

        return convertedZips;
    }

    /**
     * Obtain a converted list of raw zip code ranges.
     * @param convertedZips The list of user defined obj zip codes
     * @return The collection of raw formatted zip code ranges
     */
    public List<int[]> convertToRawZipCodes(List<ZipCodeRange> convertedZips){
        List<int[]> rawZips = new ArrayList<>();
        for(int i=0; i<convertedZips.size(); i++){
            int[] zip = new int[]{convertedZips.get(i).getStart(), convertedZips.get(i).getEnd()};
            rawZips.add(zip);
        }

        return rawZips;
    }
}
