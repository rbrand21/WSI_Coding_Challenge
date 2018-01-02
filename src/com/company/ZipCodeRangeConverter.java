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
     * @param raw_zips The collection of raw formatted zip code ranges
     * @return The collection of more consumable zip code ranges.
     */
    public List<ZipCodeRange> convertFromRawZipCodes(List<int[]> raw_zips) {
        List<ZipCodeRange> converted_zips = new ArrayList<>();

        for(int i=0; i< raw_zips.size(); i++){
            ZipCodeRange zip = new ZipCodeRange(raw_zips.get(i));
            converted_zips.add(zip);
        }

        return converted_zips;
    }

    /**
     * Obtain a converted list of raw zip code ranges.
     * @param converted_zips The list of user defined obj zip codes
     * @return The collection of raw formatted zip code ranges
     */
    public List<int[]> convertToRawZipCodes(List<ZipCodeRange> converted_zips){
        List<int[]> raw_zips = new ArrayList<>();
        for(int i=0; i<converted_zips.size(); i++){
            int[] zip = new int[]{converted_zips.get(i).getStart(), converted_zips.get(i).getEnd()};
            raw_zips.add(zip);
        }

        return raw_zips;
    }
}
