package com.company.stockerapp;

import com.company.stockerapp.StockerHelper;

import java.util.Scanner;

public class StockServicer {
    private Scanner sc = new Scanner(System.in);
    private int NUM_COMPANIES;
    private double[] stockPrices;
    private boolean[] priceStatuses;

    //main method to run the app
    public void runStockerApp() {
        //get no. of companies
        System.out.print("Enter the number of companies: ");
        NUM_COMPANIES = sc.nextInt();

        //initializing the arrays
        stockPrices = new double[NUM_COMPANIES];
        priceStatuses = new boolean[NUM_COMPANIES];

        //get the stock prices of the companies
        getStockInformation();

        //calling helper class
        StockerHelper stockerHelper = new StockerHelper(stockPrices, priceStatuses);

        //run the application
        runOperations(stockerHelper);
    }

    //displays options to user and run respective operations
    private void runOperations(StockerHelper stockerHelper) {
        //run the application while not exited
        while (true) {
            //display options
            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println("Enter the operation that you want to perform");
            System.out.println("1. Display the companies stock prices in ascending order");
            System.out.println("2. Display the companies stock prices in descending order");
            System.out.println("3. Display the total no of companies for which stock prices rose today");
            System.out.println("4. Display the total no of companies for which stock prices declined today");
            System.out.println("5. Search a specific stock price");
            System.out.println("6. Press 0 to exit");
            System.out.println("---------------------------------------------");

            int choice = sc.nextInt();

            //exit application
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    //display stocks in ascending order
                    stockerHelper.displayStocks(true);
                    break;
                case 2:
                    //display stocks in descending order
                    stockerHelper.displayStocks(false);
                    break;
                case 3:
                    //display the total no. of company stocks rose today
                    stockerHelper.showNoOfCompaniesStockRose();
                    break;
                case 4:
                    //display the total no. of company stocks declined today
                    stockerHelper.showNoOfCompaniesStockDeclined();
                    break;
                case 5:
                    //search specific stock
                    System.out.print("Enter the key value: ");
                    double value = sc.nextDouble();
                    stockerHelper.searchStock(value);
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }
        System.out.println("Exited successfully");
    }

    //get stock information from user
    private void getStockInformation() {
        for(int i = 0; i < NUM_COMPANIES; i++) {
            System.out.print("Enter current stock price of the company " + (i + 1) + ": ");
            stockPrices[i] = sc.nextDouble();
            System.out.print("Whether company's stock price rose today compare to yesterday?: ");
            priceStatuses[i] = sc.nextBoolean();
        }
    }
}
