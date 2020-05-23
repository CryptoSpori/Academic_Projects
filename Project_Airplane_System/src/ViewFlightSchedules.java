import java.util.Scanner;
class ViewFlightSchedules {
    static void viewFlightSchedules(Reservation somePlaneTicket) {
        Scanner keyboard = new Scanner(System.in);
        boolean menuReturn = false;
        do {
            System.out.println("AIRPORT FLIGHT SCHEDULE:");
            System.out.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < somePlaneTicket.getTheFlightSchedule().size(); i++) {
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("Airport Code: " + somePlaneTicket.getTheFlightSchedule().get(i).getAirportCode());
                System.out.print("Destination: " + somePlaneTicket.getTheFlightSchedule().get(i).getServiceCity());
                System.out.print(" State:" + somePlaneTicket.getTheFlightSchedule().get(i).getServiceState());
                System.out.println("   Flight Cost: $" + somePlaneTicket.getTheFlightSchedule().get(i).getAirportCost());
                System.out.println("Airport:" + somePlaneTicket.getTheFlightSchedule().get(i).getAirportCode() +
                        "-" + somePlaneTicket.getTheFlightSchedule().get(i).getAirportName());
                System.out.print("Flight Date: " + somePlaneTicket.getTheFlightSchedule().get(i).getFlightDate());
                System.out.print(" Departure Time: " + somePlaneTicket.getTheFlightSchedule().get(i).getDepartureTime());
                System.out.println(" Arrival Time: " +  somePlaneTicket.getTheFlightSchedule().get(i).getArrivalTime());
                //System.out.println(somePlaneTicket.getTheFlightSchedule());
            }
            System.out.println("\n\nWOULD YOU LIKE TO RETURN TO THE MENU (YES or NO)?");
            String menuChoose = keyboard.nextLine();
            if (menuChoose.equalsIgnoreCase("yes") || menuChoose.equalsIgnoreCase("y")) {
                menuReturn = true;
            }
        }
        while (!menuReturn);
    }
}

