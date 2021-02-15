package Mod4PA.Program4;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/01/2020
 *
 * Stock.java
 */
public class Stock {

    private double cost;
    private int shares;

    Stock() {
        this.cost = 0;
    }

    Stock(double cost, int shares) {
        this.cost = cost;
        this.shares = shares;

    }

    Stock(double cost) {
        this.cost = cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }


    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getShares() {
        return shares;
    }

    public double returnTotal() {
        return cost * shares;
    }


}
