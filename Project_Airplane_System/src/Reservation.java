import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Reservation {
    private Airplane[] airplaneFleet;
    private ArrayList<FlightSchedule> theFlightSchedule;
    private int reservationNumber;
    private String destinationCode;
    private FlightSchedule departingFlight;
    private FlightSchedule returnFlight;
    private int flightType;

    Reservation() { }
    void makeReservation() {
        boolean loadPlane;
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboardInt = new Scanner(System.in);
        do {
            System.out.println("ENTER FLIGHT RESERVATIONS");
            System.out.println("ENTER TRIP TYPE: ");
            System.out.println("1 - One-way Flight");
            System.out.println("2 - Round Trip Flight");
            setFlightType(keyboardInt.nextInt());
            if (flightType == 2) {
                System.out.println("Enter Flight Destination Code: ");
                setDestinationCode(keyboard.nextLine());
                for (int i = 0; i < airplaneFleet.length; i++) {
                    if (destinationCode.equalsIgnoreCase(airplaneFleet[i].getDestinationCode()) &&
                            airplaneFleet[i].getPlaneStatus()) {
                        setDepartingFlight(theFlightSchedule.get(i));
                        airplaneFleet[i].loadAirPlane(departingFlight.getAirportCost());
                    }
                    else if (!airplaneFleet[i].getPlaneStatus()) {
                        if (destinationCode.equalsIgnoreCase(airplaneFleet[i].getDestinationCode())) {
                            System.out.println("NO SEATS AVAILABLE FOR FLIGHT");
                        }
                    }
                }
                System.out.println("Enter Return Flight Destination Code: ");
                String tempDestinationCode2 = keyboard.nextLine();
                setDestinationCode(tempDestinationCode2);
                for (int i = 0; i < airplaneFleet.length; i++) {
                    if (tempDestinationCode2.equalsIgnoreCase(airplaneFleet[i].getDestinationCode())&&
                            airplaneFleet[i].getPlaneStatus()) {
                        setReturnFlight(theFlightSchedule.get(i));
                        airplaneFleet[i].loadAirPlane(returnFlight.getAirportCost());
                    }
                    else if (!airplaneFleet[i].getPlaneStatus()) {
                        if (tempDestinationCode2.equalsIgnoreCase(airplaneFleet[i].getDestinationCode())) {
                            System.out.println("NO SEATS AVAILABLE FOR FLIGHT");
                        }
                    }
                }
                setReservationNumber();
            }
            else {
                System.out.println("Enter Flight Destination Code: ");
                setDestinationCode(keyboard.nextLine());
                for (int i = 0; i < airplaneFleet.length; i++) {
                    if (destinationCode.equalsIgnoreCase(airplaneFleet[i].getDestinationCode()) &&
                            airplaneFleet[i].getPlaneStatus()) {
                        setDepartingFlight(theFlightSchedule.get(i));
                        airplaneFleet[i].loadAirPlane(departingFlight.getAirportCost());
                    }
                    else if (!airplaneFleet[i].getPlaneStatus()) {
                        if (destinationCode.equalsIgnoreCase(airplaneFleet[i].getDestinationCode())) {
                            System.out.println("NO SEATS AVAILABLE FOR FLIGHT");
                        }
                    }
                }
                setReservationNumber();
            }
            System.out.println("\nDo you have another Reservation (Y or N)");
            String status = keyboard.nextLine();
            if (status.equalsIgnoreCase("y")) {
                loadPlane = false;
            }
            else {
                loadPlane = true;
            }
        }
        while (!loadPlane);
    }

    void buildFlightScheduleList() {
        String fileName = "C:\\temp\\FlightSchedule.txt";
        int count = 0;
        try {
            File theFile = new File(fileName);
            ArrayList<FlightSchedule> tempArrayList = new ArrayList<>();
            Scanner inputStream = new Scanner(theFile);
            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                String[] ary = line.split(",");
                String airportState = ary[0];
                String airportCode = ary[1];
                String departureTime = ary[2];
                String arrivalTime = ary[3];
                String airportCost = ary[4];
                String airportName = ary[5];
                String serviceCity = ary[6];
                String flightDate = "";
                FlightSchedule tempAirport = new FlightSchedule(airportState, airportCode, Double.parseDouble(airportCost),
                        airportName, serviceCity, departureTime, arrivalTime, flightDate);
                tempArrayList.add(count,tempAirport);
                count++;
            }
            inputStream.close();
            setTheFlightSchedule(tempArrayList);
            createAirplanes();
        }
        catch(FileNotFoundException e) {
            System.out.println("ERROR: Flight List Not Found!");
        }
    }

    private void createAirplanes() {
        Airplane[] tempAirplaneFleet = new Airplane[getTheFlightSchedule().size()];
        for (int i = 0; i < getTheFlightSchedule().size(); i++) {
            Airplane tempAirplane = new Airplane();
            tempAirplaneFleet[i] = tempAirplane;
            tempAirplaneFleet[i].setIdNumber(i);
            String someNumber = getTheFlightSchedule().get(i).getAirportCode();
            tempAirplaneFleet[i].setDestinationCode(someNumber);
        }
        setAirplaneFleet(tempAirplaneFleet);
    }

    private void setReservationNumber() {
        this.reservationNumber++;
    }

    private void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    private void setDepartingFlight(FlightSchedule departingFlight) {
        this.departingFlight = departingFlight;
    }

    private void setReturnFlight(FlightSchedule returnFlight) {
        this.returnFlight = returnFlight;
    }

    private void setFlightType(int flightType) {
        this.flightType = flightType;
    }

    private void setAirplaneFleet(Airplane[] airplaneFleet) {
        this.airplaneFleet = airplaneFleet;
    }

    private void setTheFlightSchedule(ArrayList<FlightSchedule> theFlightSchedule) {
        this.theFlightSchedule = theFlightSchedule;
    }

    int getReservationNumber() {
        return reservationNumber;
    }

    String getDestinationCode() {
        return destinationCode;
    }

    FlightSchedule getDepartingFlight() {
        return departingFlight;
    }

    FlightSchedule getReturnFlight() {
        return returnFlight;
    }

    int getFlightType() {
        return flightType;
    }

    Airplane[] getAirplaneFleet() {
        return airplaneFleet;
    }

    ArrayList<FlightSchedule> getTheFlightSchedule() {
        return theFlightSchedule;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "airplaneFleet=" + Arrays.toString(airplaneFleet) +
                ", theFlightSchedule=" + getTheFlightSchedule() +
                ", reservationNumber=" + reservationNumber +
                ", destinationCode='" + destinationCode + '\'' +
                ", departingFlight=" + departingFlight +
                ", returnFlight=" + returnFlight +
                ", flightType=" + flightType +
                '}';
    }
}


