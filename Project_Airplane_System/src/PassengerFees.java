
import java.util.Scanner;
class PassengerFees {

    static void showPassengerFee(Reservation somePlaneTicket) {
        Scanner keyboard = new Scanner(System.in);
        boolean menuReturn = false;
        double flightSum = 0;
        double tempCost = 0;
        do {
            System.out.println("Enter passenger phone number: ");
            String phone = keyboard.nextLine();
            System.out.println("PASSENGER FEES:");
            Airplane[] tempAirplane = somePlaneTicket.getAirplaneFleet();
            for (int i = 0; i < tempAirplane.length; i++) {
                Passenger[] tempPassengers = tempAirplane[i].getPassengerSeats();
                for (int j = 0; j < tempPassengers.length; j++) {
                    if (tempPassengers[j] != null && tempPassengers[j].getPhoneNumber().equals(phone)) {
                        System.out.print("NAME: " + tempPassengers[j].getPassengerName());
                        System.out.println(" PHONE: " + tempPassengers[j].getPhoneNumber());
                        System.out.print("DESTINATION: " + tempAirplane[i].getDestinationCode());
                        System.out.print(" FLIGHT: " + tempAirplane[i].getTailNumber());
                        System.out.print(" CARRY ON: " + tempPassengers[j].isCarryOn());
                        System.out.print(" BAGS: " + tempPassengers[j].getNumberOfBags());
                        for (int k = 0; k < somePlaneTicket.getTheFlightSchedule().size(); k++) {
                            if (tempAirplane[i].getDestinationCode().equalsIgnoreCase(
                                    somePlaneTicket.getTheFlightSchedule().get(k).getAirportCode())) {
                                tempCost = somePlaneTicket.getTheFlightSchedule().get(k).getAirportCost();
                                flightSum = flightSum + tempCost;
                            }
                        }
                        System.out.println(" COST: $" + tempCost);
                    }
                }
            }
            System.out.println("\nTOTAL COST FOR FLIGHT: $" + flightSum);
            System.out.println("\n\nWOULD YOU LIKE TO RETURN TO THE MENU (YES or NO)?");
            String menuChoose = keyboard.nextLine();
            if (menuChoose.equalsIgnoreCase("yes") || menuChoose.equalsIgnoreCase("y")) {
                menuReturn = true;
            }
        }
        while (!menuReturn);
    }
}
