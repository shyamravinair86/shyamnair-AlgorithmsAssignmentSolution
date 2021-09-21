package com.company.main;

import com.company.stockerapp.StockServicer;

public class Main {

    public static void main(String[] args) {
        //calling Stocker Services class and running the app
        StockServicer stockServicer = new StockServicer();
        stockServicer.runStockerApp();
    }
}
