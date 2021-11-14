package Classes.Printer;

/**
 * Printer Interface
 * to be implemented by Submenu and other forms of printing.
 * @author  Min
 * @author  Her Huey
 * @version 1.0
 * @since   2021-11-12
 */
public interface Printer {
    /**
     * Maximum row length of the printing on the console
     */
    public static int rowLength = 63;
    /**
     * Name of the Restaurant
     */
    public static String restaurantName = "Happy Chicken Diner";

    /**
     * Abstract print function to be implemented by inheritors
     */
    public static void print(){};
}
