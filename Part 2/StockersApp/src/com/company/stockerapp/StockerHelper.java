package com.company.stockerapp;

import com.company.services.SearchServicer;
import com.company.services.SortingServicer;

public class StockerHelper {
    //variables
    private double[] sortedStockPrices;
    private int stockIncreased = 0, stockDecreased = 0;

    //Constructor
    public StockerHelper(double[] stockPrices, boolean[] priceStatuses) {
        //sort the array
        SortingServicer.sort(stockPrices, 0, stockPrices.length - 1);

        //copy the sorted array
        sortedStockPrices = stockPrices;

        //take the count of companies for which stock price has increased/decreased
        for (boolean status :priceStatuses) {
            if (status) {
                stockIncreased++;
            }
            else {
                stockDecreased++;
            }
        }
    }

    //to display companies in ascending or descending order
    public void displayStocks(boolean asc) {
        //if ascending
        if (asc) {
            System.out.println("Stock prices in ascending order are: ");
            for(int i = 0; i < sortedStockPrices.length; i++) {
                System.out.print(sortedStockPrices[i] + " ");
            }
        }
        //if descending
        else {
            System.out.println("Stock prices in descending order are: ");
            for(int i = (sortedStockPrices.length - 1); i >= 0; i--) {
                System.out.print(sortedStockPrices[i] + " ");
            }
        }
        System.out.println();
    }

    //show the no. of companies whose stock price rose
    public void showNoOfCompaniesStockRose() {
        System.out.println("Total no of companies whose stock price rose today: " + stockIncreased);
    }

    //show the no. of companies whose stock price declined
    public void showNoOfCompaniesStockDeclined() {
        System.out.println("Total no of companies whose stock price declined today: " + stockDecreased);
    }

    //to search a specific stock in the array
    public void searchStock(double value) {
        int index = SearchServicer.searchValue(sortedStockPrices, value);

        if (index == -1) {
            System.out.println("Value not found");
        }
        else {
            System.out.println("Stock of value " + value + " is present.");
        }
    }

}
