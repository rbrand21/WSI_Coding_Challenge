package com.zipchallenge;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Takes in a list of zip code ranges and minimizes the ranges so that they are all mutually exclusive.
 *
 * To do the above minimization the following algorithm is used:
 * 1) Sort the list so we can rely on the assumption that the min range is increasing in order. This allows us to
 * only have to iterate through the list once.
 *
 * 2)Iterate through the list and compare current iteration to the most recent range in the minimized list.
 *
 * 3)If the current list range is mutually exclusive with the most recent range in the minimized list, add it to the
 * minimized list, otherwise collapse them into one range.
 *
 * A user defined object, ZipCodeRange, was used to make the code more readable and maintainable.
 */
public class ZipCodeMinimizer {
    private List<ZipCodeRange> minZipCodes;

    /**
     * Initialize our list that will be used to manipulate data later
     */
    public ZipCodeMinimizer() {
    }

    /**
     * This method is used to retrieve the mutually exclusive list from the list passed in.
     * @return A sorted list of mutually exclusive zip code ranges.
     */
    public List<ZipCodeRange> getMinimizedZipCodes(List<ZipCodeRange> zips){
        checkFormattingOfList(zips);

        zips = sortZipCodes(zips);

        minZipCodes = new ArrayList<>();

        minZipCodes.add(zips.get(0));

        //Skip index 0 because we already added it to the list as a starting point above
        for(int i = 1; i<(zips.size()); i++){
            //Merge the current iteration of the list with the top of the minimized list
            mergeZipCodes(zips.get(i), minZipCodes.get(minZipCodes.size()-1));
        }
        return minZipCodes;
    }

    private List<ZipCodeRange> sortZipCodes(List<ZipCodeRange> zips) {
        Collections.sort(zips);
        return zips;
    }

    /**
     * When merging two zip codes, either they will collapse into one zip code or (current zip is mut-ex) current zip
     * is added to the list.
     * @param currentZip The current iteration through the passed in list
     * @param prevZip The top of the mut-ex list
     */
    private void mergeZipCodes(ZipCodeRange currentZip, ZipCodeRange prevZip) {
        if(isStartOfCurrentZipIndicatingOverlapWithPrevZip(currentZip, prevZip)){

            //Now determine which end is greater so that we can merge
            if(isCurrentZipEndLargerThanPrevZipEnd(currentZip, prevZip)){
                updateRangeEndValue(currentZip);
            }
            //Otherwise, do nothing because the prevZip encompasses current
        }
        else{//The start is outside of prev zip code range indicating start of a new range
            minZipCodes.add(currentZip);
        }
    }

    private void updateRangeEndValue(ZipCodeRange currentZip) {
        minZipCodes.get(minZipCodes.size()-1).setEnd(currentZip.getEnd());
    }

    private boolean isCurrentZipEndLargerThanPrevZipEnd( ZipCodeRange currentZip, ZipCodeRange prevZip) {
        return currentZip.getEnd() > prevZip.getEnd();
    }

    private boolean isStartOfCurrentZipIndicatingOverlapWithPrevZip(ZipCodeRange currentZip, ZipCodeRange prevZip) {
        return currentZip.getStart() >= prevZip.getStart() &&
                currentZip.getStart() <= (prevZip.getEnd()+1);
        //Overlap is indicated when the start is in between the prev zip range OR one above the prev zip's end.
    }

    private void checkFormattingOfList(List<ZipCodeRange> zipCodes) {
        checkForEmptyList(zipCodes);
        checkForIllegalStartAndEnd(zipCodes);
    }

    private void checkForEmptyList(List<ZipCodeRange> zipCodes) {
        if(zipCodes.isEmpty()){
            throw new IllegalArgumentException("Must set a non empty list");
        }
    }

    private void checkForIllegalStartAndEnd(List<ZipCodeRange> zipCodes) {
        for(int i=0; i<zipCodes.size(); i++){
            if(zipCodes.get(i).getStart() > zipCodes.get(i).getEnd()){
                throw new IllegalArgumentException("All ranges must start with the lower number and end with higher number");
            }
        }
    }
}
