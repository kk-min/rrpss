package Classes.Printer;

/**
 * Implements printing functionality for Reservation sub-menus
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
            System.out.println("4) Check for expired reservations");
            System.out.println("5) Back to main menu");
            System.out.println("0) Exit Application");

            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    Classes.Reservation.ReservationManager.createReservationBooking();
                    break;
                case 2:
                    Classes.Reservation.ReservationManager.checkReservationBooking();
                    break;
                case 3:
                    Classes.Reservation.ReservationManager.removeReservationBooking();
                    break;
                case 4:
                    Classes.Reservation.ReservationManager.checkExpiredReservations();
                    break;
                case 5:
                    return -1;
                case 0:
                    return 1;
                default:
                    return -1;
            }
        }
    }
}
