import java.util.Scanner;
public class FlightSystem {
    public static void main(String[] args) {
        introScreenTitle();
        Reservation somePlaneTicket = new Reservation();
        somePlaneTicket.buildFlightScheduleList();
        Scanner keyboard = new Scanner(System.in);
        int item;
        boolean operating = true;
        do {
            menuItems();
            System.out.println("\nENTER MENU ITEM AND PRESS ENTER:");
            item = keyboard.nextInt();
                    switch (item) {
                        case 1: somePlaneTicket.makeReservation(); break;
                        case 2: PassengerList.getPassengerList(somePlaneTicket);break;
                        case 3: SeatingChart.showSeatingChart(somePlaneTicket);break;
                        case 4: PassengerFees.showPassengerFee(somePlaneTicket);break;
                        case 5: PassengerSearch.passengerSearchByPhone(somePlaneTicket);break;
                        case 6: ViewFlightSchedules.viewFlightSchedules(somePlaneTicket); break;
                        default: operating = false; break;
                    }
            } while(operating);
            System.out.println("System Exit, Good by!!!");
            System.exit(0);
    }
    private static void menuItems() {
        System.out.println(" AIRLINE FLIGHT BOOKING SYSTEM MENU");
        System.out.println("--------------------------------------------------");
        System.out.println("1. BOOK FLIGHT RESERVATION");
        System.out.println("2. DISPLAY PASSENGER LIST");
        System.out.println("3. DISPLAY SEATING CHART");
        System.out.println("4. DISPLAY PASSENGER CHARGES");
        System.out.println("5. SEARCH FOR PASSENGER BY PHONE NUMBER");
        System.out.println("6. VIEW AVAILABLE AIRPORTS");
        System.out.println("7. EXIT SYSTEM");
    }
    private static void introScreenTitle() {

            System.out.println("          _____________                     _______________                 ");
            System.out.println("         /************/     _______________ \\**************\\_______                ___________________    _____________________");
            System.out.println("        /************/      \\**************\\ |*********************\\               /******************\\   \\*******************/ ");
            System.out.println("       /************/______ |***************||***************|\\*****\\             /***********/|*******\\   |*****************/ ");
            System.out.println("      /*****/|******|\\*****||***************||*****|   |*****| \\****|            /*****/|*****||********\\  |****||****|\\****/  ");
            System.out.println("     /*****/ |******|______ |*****|   |*****||*****|   |*****| |****|           /*****/ |*****||*********\\ |****||****|");
            System.out.println("    /*****/__|******|\\*****||*****|   |*****/|*****|   |*****| |****|          /*****/  |*****||****|\\****\\|****||*******\\");
            System.out.println("   /****************||****| |*************<  |***************| |****|_______  /***************||****| \\*********||*******/");
            System.out.println("  /*****************||****| |**************\\ |**************/  |************|/****************||****|  \\********||****| _______");
            System.out.println(" /*****/      |******||****| |*****|    \\***********|           |****************/      |******||****|    \\******||**************\\");
            System.out.println(" \\*****\\______|******\\|*****\\|*****|____/***********|__________/****************/_______|******|/****|_____\\*****||***************\\");
            System.out.println("  \\               ** *  *   *    * F  L  I  G  H  T  -  B  O  O  K  I  N  G  -  S  Y  S  T  E  M *    *   *  * **                  \\");
            System.out.println("   \\--------------------------------------------------------------------------------------------------------------------------------\\");
            System.out.println("    \\                       F  O  R   +  S  O  M  E  S  M  A  L  L  +  A  I  R  L  I  N  E  +  L  L  C                               \\");
            System.out.println("     \\________________________________________________________________________________________________________________________________\\");

    }
}
