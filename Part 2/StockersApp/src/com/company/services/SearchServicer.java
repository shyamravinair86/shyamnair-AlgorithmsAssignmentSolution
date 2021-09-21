package com.company.services;

public class SearchServicer {

    //to search value using iterative binary search
    public static int searchValue(double[] arr, double value) {
        //declaring left and right indexes
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            //checks if the value is present     in the middle
            if (arr[m] == value) {
                return m;
            }

            //checks if the value is present in the left half
            if (arr[m] < value) {
                l = m + 1;
            }
            //checks if the value is present in the right half
            else {
                r = m - 1;
            }
        }

        //return -1 if the value is not present
        return -1;
    }
}
