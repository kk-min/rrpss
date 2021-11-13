package Classes.Printer;

import java.util.Scanner;

/**
 * Superclass with an initialized Scanner object.
 * @version 1.0
 */
public abstract class UserInterfacePrinter implements Printer {
    /**
     * Scanner object for taking user input
     */
    protected static Scanner input = new Scanner(System.in);

}
