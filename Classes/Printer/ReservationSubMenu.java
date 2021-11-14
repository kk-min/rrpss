package Classes.Printer;

import Classes.Reservation.ReservationManager;
import java.util.InputMismatchException;

/**
 * The OrderSubMenu Class
 * Implements printing functinality for Reservation sub-menus
 * extends UserInterfacePrinter
 * @author  Erli
 * @author  Her Huey
 * @author  Min
 * @version 2.0
 * @since   2021-11-12
 */
public class ReservationSubMenu extends UserInterfacePrinter {
    /**
     * Prints the reservation submenu and calls the respective ReservationManager methods based on the user's choice
     * @return an integer flag indicating whether to exit the the application
     */
    public static int print(){
        while (true) {
            System.out.printf("-".repeat(rowLength));
            System.out.println();
            System.out.println("Reservation Booking\nSelect an option:\n");
            System.out.println("1) Create a new reservation booking");
            System.out.println("2) Check reservation booking");
            System.out.println("3) Remove a reservation booking");
            System.out.println("4) List all reservation bookings");
            System.out.println("5) Back to main menu");
            System.out.println("0) Exit Application");
            System.out.printf("-".repeat(rowLength));
            System.out.println();
            int choice = -1;
            boolean validChoice = false;
            while(!validChoice){
                try{
                    choice = input.nextInt(); input.nextLine();
                }
                catch(InputMismatchException e){
                    System.out.println("Please enter a valid entry.");
                    input.nextLine();
                }
                validChoice = true;
            }
            
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
                    ReservationManager.printAllReservations();
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
