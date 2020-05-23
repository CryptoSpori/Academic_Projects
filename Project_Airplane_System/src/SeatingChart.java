import java.util.Scanner;
class SeatingChart {
    static  void showSeatingChart(Reservation somePlaneTicket) {
        Scanner keyboard = new Scanner(System.in);
        boolean menuReturn = false;
        do {

            String takenSeat = "[TAKEN]";
            String openSeat = "[OPEN ]";

            System.out.println("ENTER FLIGHT DESTINATION CODE FOR CHART");
            String flight = keyboard.nextLine();


            Airplane[] tempAirplane = somePlaneTicket.getAirplaneFleet();
            String[] seatLayout;
            for (int i = 0; i < tempAirplane.length; i++) {
                if (tempAirplane[i].getDestinationCode().equalsIgnoreCase(flight)) {
                    System.out.println("\n--------------------------------------------------------------------------------------------------------");
                    System.out.println("SEATING CHART FOR FLIGHT " + tempAirplane[i].getTailNumber() + " TO " + tempAirplane[i].getDestinationCode());
                    Passenger[] tempPassengers = tempAirplane[i].getPassengerSeats();
                    seatLayout = new String[tempPassengers.length];
                    System.out.println("AIRCRAFT: " + tempAirplane[i].getManufacturerName() +" "
                            + tempAirplane[i].getModelName()  + " MAX AIR SPEED: " + tempAirplane[i].getMaxAirSpeed()
                            + " km/h SEATING CAPACITY: " + tempAirplane[i].getSeatingCapacity() );
                    System.out.println("--------------------------------------------------------------------------------------------------------\"\n");
                    for (int j = 0; j < tempPassengers.length; j++) {
                        if (tempPassengers[j] == null) {
                            seatLayout[j] = openSeat;
                        } else {
                            seatLayout[j] = takenSeat;
                        }
                    }
                    cockpit();
                    for (int k = 0; k < seatLayout.length; k++) {
                        if (1 == k % 2) {
                            System.out.println("  " +seatLayout[k]);
                        } else {
                            System.out.print(" " + seatLayout[k] + " ");
                        }
                    }
                    tail();
                }
            }
            System.out.println(" ");
            System.out.println("\n\nWOULD YOU LIKE TO RETURN TO THE MENU (YES or NO)?");
            String menuChoose = keyboard.nextLine();
            if (menuChoose.equalsIgnoreCase("yes") || menuChoose.equalsIgnoreCase("y")) {
                menuReturn = true;
            }
        }
        while (!menuReturn) ;
    }
    private static void cockpit() {
        System.out.println("         ^        ");
        System.out.println("        / \\        ");
        System.out.println("       /   \\        ");
        System.out.println("      /     \\        ");
        System.out.println("     / __ __ \\        ");
        System.out.println("    / /_| |_\\ \\        ");
        System.out.println("   /           \\        ");
        System.out.println("  /             \\        ");
        System.out.println(" |               |        ");
        System.out.println(" |               |        ");


    }
    private static void tail() {
        System.out.println(" |               |         ");
        System.out.println(" |               |         ");
        System.out.println(" \\               /        ");
        System.out.println("  \\             /        ");
        System.out.println("   \\           /        ");
        System.out.println("    \\         /        ");
        System.out.println("     \\       /        ");
        System.out.println("      \\     /        ");
        System.out.println("      /\\   /\\        ");
        System.out.println("     |__\\ /__|      ");
        System.out.println("         V            ");




    }
}
