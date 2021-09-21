package com.company.main;

import com.company.stockerapp.service.StockServicer;

public class Main {

    public static void main(String[] args) {
        //calling Stocker Services class and running the app
        StockServicer stockServicer = new StockServicer();
        stockServicer.runStockerApp();
    }
}
