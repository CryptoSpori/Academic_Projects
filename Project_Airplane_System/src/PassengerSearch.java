import java.util.Scanner;
class PassengerSearch {
     static void passengerSearchByPhone(Reservation somePlaneTicket) {
         Scanner keyboard = new Scanner(System.in);
         boolean menuReturn = false;
         do {
             System.out.println("Enter passenger phone number: ");
             String phone = keyboard.nextLine();
             System.out.println("PASSENGER SEARCH RESULTS:");
             Airplane[] tempAirplane = somePlaneTicket.getAirplaneFleet();
             for (int i = 0; i < tempAirplane.length; i++) {
                 Passenger[] tempPassengers = tempAirplane[i].getPassengerSeats();
                 for (int j = 0; j < tempPassengers.length; j++) {
                     if (tempPassengers[j] != null && tempPassengers[j].getPhoneNumber().equals(phone)) {
                         System.out.println(somePlaneTicket.getReservationNumber());
                         System.out.println("NAME: " + tempPassengers[j].getPassengerName());
                         System.out.println("AGE: " + tempPassengers[j].getAge());
                         System.out.println("GENDER: " + tempPassengers[j].getGender());
                         System.out.println("PHONE: " + tempPassengers[j].getPhoneNumber());
                         System.out.println("CARRY ON: " + tempPassengers[j].isCarryOn());
                         System.out.println("BAGS: " + tempPassengers[j].getNumberOfBags());
                         System.out.println("FLIGHT: " + tempAirplane[i].getTailNumber());
                         System.out.println("SEAT: " + j);
                         System.out.println("DESTINATION: " + tempAirplane[i].getDestinationCode());
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
