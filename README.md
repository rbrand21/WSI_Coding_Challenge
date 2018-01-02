# WSI_Coding_Challenge

The purpose of this project is to demonstrate my level of Java coding competency. The problem that is being solved is: Given a collection of 5 digit zip codes, produce the minimum number of ranges that represent the same restrictions as the input.

The ZipCodeMinimizer is the class which contains the algorithm. It operates on a `List<ZipCodeRange>`.  Since the format of the problem statement looked like a List<int[]>, there is also a conversion class to translate to and from `List<int[]>` to `List<ZipCodeRange>`.

## Code Example
main.java has a working code example, but below is a short API usage of the ZipCodeMinimizer:

```java
List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
ZipCodeMinimizer zip_minimizer = new ZipCodeMinimizer();

zipCodeRanges.add(new ZipCodeRange(new int[]{91200, 91300}));
zipCodeRanges.add(new ZipCodeRange(new int[]{91250, 91350}));

zipCodeRanges = zip_minimizer.getMinimizedZipCodes(zipCodeRanges);
```

## Tests
All of the tests can be found under the test directory. All of the corner cases for the algorithm should have corresponding tests.
