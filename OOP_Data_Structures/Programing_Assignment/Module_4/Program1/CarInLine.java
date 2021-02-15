package Mod4PA.Program1;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 11/01/2020
 *
 * CarInLin.java
 */
public class CarInLine {

    protected int arrivalTime;
    protected int serviceTime;
    protected int departureTime = 0;
    protected int serviceStartTime;
    protected int line;

    public CarInLine() {
        this.arrivalTime = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
    }

    public CarInLine(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = 0;
        this.departureTime = 0;
    }

    public CarInLine(int arrivalTime, int serviceTime, int departureTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.departureTime = departureTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setLine(int lineNumber) {
        this.line = lineNumber;
    }

    public void setServiceStartTime(int serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
        //setDepartureTime(serviceStartTime);

    }

    public void setDepartureTime(int departureTime) {
        if(serviceStartTime == 0)
            this.departureTime = 90;
        else
            this.departureTime = serviceStartTime + 90;
    }

    public int getLine() {
        return line;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }


    public int getServiceTime() {
        return departureTime - serviceStartTime;
    }


    public  int getDepartureTime() { return departureTime; }

    public  int getWaitTime() {
        return  (departureTime - arrivalTime - 90);
    }

    public  int getProcessTime() {
        return  (departureTime - arrivalTime);
    }

}
