package Mod4PA.Program4;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/01/2020
 *
 * StockTransactionHistory.java
 */
public class StockTransactionHistory {

    public static void main(String[] args) {

        StockTransaction<Stock> portfolio = new StockTransaction<>();

        portfolio.buy(new Stock(25, 120));

        portfolio.buy(new Stock(30, 50));

        portfolio.sell(new Stock(55, 20));

        portfolio.sell(new Stock(75, 10));

        portfolio.buy(new Stock(10, 100));

        portfolio.buy(new Stock(4, 130));

        portfolio.buy(new Stock(16, 200));

        portfolio.sell(new Stock(65, 10));

        portfolio.sell(new Stock(65, 150));



        System.out.println("\nDONE!!!");


    }
}
