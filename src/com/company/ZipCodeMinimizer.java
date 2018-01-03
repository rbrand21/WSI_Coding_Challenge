package com.company;

import org.jetbrains.annotations.NotNull;

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
 * minimized list, other wise collapse them into one range.
 *
 * A user defined object, ZipCodeRange, was used to make the code more readable and maintainable.
 */
public class ZipCodeMinimizer {
    private List<ZipCodeRange> _minZipCodes;

    /**
     * Initialize our list that will be used to manipulate data later
     */
    public ZipCodeMinimizer() {
        _minZipCodes = new ArrayList<>();
    }

    /**
     * This method is used to retrieve the mutually exclusive list from the list passed in.
     * @return A sorted list of mutually exclusive zip code ranges.
     */
    public List<ZipCodeRange> getMinimizedZipCodes(List<ZipCodeRange> zips){
        _checkFormattingOfList(zips);

        zips = _sortZipCodes(zips);

        _minZipCodes.clear();

        _minZipCodes.add(zips.get(0));

        //Skip index 0 because we already added it to the list as a starting point above
        for(int i = 1; i<(zips.size()); i++){
            //Merge the current iteration of the list with the top of the minimized list
            mergeZipCodes(zips.get(i), _minZipCodes.get(_minZipCodes.size()-1));
        }
        return _minZipCodes;
    }

    /**
     * Private Methods
     */
    private List<ZipCodeRange> _sortZipCodes(List<ZipCodeRange> zips) {
        Collections.sort(zips);
        return zips;
    }

    /**
     * When merging two zip codes, either they will collapse into one zip code or (current zip is mut-ex) current zip
     * is added to the list.
     * @param current_zip The current iteration through the passed in list
     * @param prev_zip The top of the mut-ex list
     */
    private void mergeZipCodes(ZipCodeRange current_zip, ZipCodeRange prev_zip) {
        if(isStartOfCurrentZipIndicatingOverlapWithPrevZip(current_zip, prev_zip)){

            //Now determine which end is greater so that we can merge
            if(isCurrentZipEndLargerThanPrevZipEnd(current_zip, prev_zip)){
                _updateRangeEndValue(current_zip);
            }
            //Otherwise, do nothing because the prev_zip encompasses current
        }
        else{//The start is outside of prev zip code range indicating start of a new range
            _minZipCodes.add(current_zip);
        }
    }

    private void _updateRangeEndValue(ZipCodeRange current_zip) {
        _minZipCodes.get(_minZipCodes.size()-1).setEnd(current_zip.getEnd());
    }

    private boolean isCurrentZipEndLargerThanPrevZipEnd( ZipCodeRange current_zip, ZipCodeRange prev_zip) {
        return current_zip.getEnd() > prev_zip.getEnd();
    }

    private boolean isStartOfCurrentZipIndicatingOverlapWithPrevZip(ZipCodeRange current_zip, ZipCodeRange prev_zip) {
        return current_zip.getStart() >= prev_zip.getStart() &&
                current_zip.getStart() <= (prev_zip.getEnd()+1);
        //Overlap is indicated when the start is in between the prev zip range OR one above the prev zip's end.
    }

    private void _checkFormattingOfList(List<ZipCodeRange> zip_codes) {
        _checkForEmptyList(zip_codes);
        _checkForIllegalStartAndEnd(zip_codes);
    }

    private void _checkForEmptyList(List<ZipCodeRange> zip_codes) {
        if(zip_codes.isEmpty()){
            throw new IllegalArgumentException("Must set a non empty list");
        }
    }

    private void _checkForIllegalStartAndEnd(List<ZipCodeRange> zip_codes) {
        for(int i=0; i<zip_codes.size(); i++){
            if(zip_codes.get(i).getStart() > zip_codes.get(i).getEnd()){
                throw new IllegalArgumentException("All ranges must start with the lower number and end with higher number");
            }
        }
    }
}
