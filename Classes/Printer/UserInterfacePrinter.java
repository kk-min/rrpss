package Classes.Printer;

import java.util.Scanner;
/**
 * The UserInterfacePrinter Abstract Class
 * implements Printer and contains a Scanner for UserInterface classes to use
 * @author  Her Huey
 * @version 1.0
 * @since   2021-11-12
 */
public abstract class UserInterfacePrinter implements Printer {
    /**
     * Scanner object for taking in user input
     */
    protected static Scanner input = new Scanner(System.in);
}
