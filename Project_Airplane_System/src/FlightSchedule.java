public class FlightSchedule {

    private String serviceState;
    private String airportCode;
    private double airportCost;
    private String airportName;
    private String serviceCity;
    private String departureTime;
    private String ArrivalTime;
    private String flightDate;

    public FlightSchedule() { }

    public FlightSchedule(String serviceState, String airportCode, double airportCost,
                          String airportName, String serviceCity, String departureTime, String arrivalTime, String flightDate) {
        this.serviceState = serviceState;
        this.airportCode = airportCode;
        this.airportCost = airportCost;
        this.airportName = airportName;
        this.serviceCity = serviceCity;
        this.departureTime = departureTime;
        ArrivalTime = arrivalTime;
        this.flightDate = "Daily";
    }

    void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    void setAirportCost(double airportCost) {
        this.airportCost = airportCost;
    }

    void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    String getServiceState() {
        return serviceState;
    }

    String getAirportCode() {
        return airportCode;
    }

    double getAirportCost() {
        return airportCost;
    }

     String getAirportName() {
        return airportName;
    }

    String getServiceCity() {
        return serviceCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public String getFlightDate() {
        return flightDate;
    }

    @Override
    public String toString() {
        return "FlightSchedule{" +
                "serviceState='" + serviceState + '\'' +
                ", airportCode='" + airportCode + '\'' +
                ", airportCost=" + airportCost +
                ", airportName='" + airportName + '\'' +
                ", serviceCity='" + serviceCity + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", ArrivalTime='" + ArrivalTime + '\'' +
                ", flightDate='" + flightDate + '\'' +
                '}';
    }
}
