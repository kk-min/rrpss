package Classes.Printer;

import Classes.Reservation.ReservationManager;

/**
 * Implements printing functionality for Reservation sub-menus
 * @version 1.0
 */
public class ReservationSubMenu extends UserInterfacePrinter {
    /**
     * Prints the reservation submenu
     * @return an integer flag indicating whether to exit the the application (1) or go to previous menu (-1)
     */
    public static int print(){
        while (true) {
            System.out.printf("-".repeat(rowLength));
            System.out.println();
            System.out.println("Reservation Booking\nSelect an option:\n");
            System.out.println("1) Create a new reservation booking");
            System.out.println("2) Check reservation booking");
            System.out.println("3) Remove a reservation booking");
            System.out.println("4) Back to main menu");
            System.out.println("0) Exit Application");
            System.out.printf("-".repeat(rowLength));
            System.out.println();
            int choice = input.nextInt(); input.nextLine();
            
            switch (choice) {
                case 1:
                    ReservationManager.createReservationBooking();
                    break;
                case 2:
                    ReservationManager.checkReservationBooking();
                    break;
                case 3:
                    ReservationManager.removeReservationBooking();
                    break;
                case 4:
                    return -1;
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
    }
}
