import java.util.Scanner;
class PassengerList {
    static void getPassengerList(Reservation somePlaneTicket) {
         Scanner keyboard = new Scanner(System.in);
         boolean menuReturn = false;
         do {
             Airplane[] tempAirplaneFleet = somePlaneTicket.getAirplaneFleet();
             System.out.println("Enter flight Code: ");
             String flightCode = keyboard.nextLine();
             for (int i = 0; i < tempAirplaneFleet.length; i++) {
                 if (flightCode.equalsIgnoreCase(tempAirplaneFleet[i].getDestinationCode())) {
                     System.out.println("PASSENGER LIST FOR FLIGHT " + tempAirplaneFleet[i].getTailNumber() + " TO " + tempAirplaneFleet[i].getDestinationCode());
                     Passenger[] passengers;
                     passengers = tempAirplaneFleet[i].getPassengerSeats();
                     for (int j = 0; j < passengers.length; j++) {
                         if (passengers[j] != null) {
                             System.out.print("[SEAT: " + j);
                             System.out.print(" Name: " + passengers[j].getPassengerName());
                             System.out.print(" AGE: " + passengers[j].getAge());
                             System.out.print(" GENDER: " + passengers[j].getGender());
                             System.out.print(" PHONE: " + passengers[j].getPhoneNumber());
                             System.out.print(" NO. BAGS: " + passengers[j].getNumberOfBags());
                             System.out.print(" CARRY ON: " + passengers[j].isCarryOn());
                             System.out.println("]");
                         }
                     }
                 }
             }
             System.out.println("\n\nWOULD YOU LIKE TO RETURN TO THE MENU (YES or NO)?");
             String menuChoose = keyboard.nextLine();
             if (menuChoose.equalsIgnoreCase("yes") || menuChoose.equalsIgnoreCase("y")) {
                 menuReturn = true;
             }
         }
         while(!menuReturn);
    }
}