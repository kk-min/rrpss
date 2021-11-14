package Classes.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;
import Classes.Table.TableManager;
/**
 * The DateTimeFormatHelper Class
 * Helps format date and time and manage manually advanced time
 * 
 * @version 1.0
 */
public class DateTimeFormatHelper {
    /**
     * Scanner object for taking user input
     */
    private static Scanner input = new Scanner(System.in);
    /**
     * Final long to help convert between milliseconds and days.
     */
    private final static long MILLIS_TO_DAYS = 1000 * 60 * 60 * 24;
    /**
     * Final long to help adjust to SG time zone
     */
    private final static long TO_UTC_8 = 28800000;
    /**
     * Global variable to manually advance time in program in minutes. The value represents how much the program time
     * is ahead of the real system time in minutes.
     */
    private static long TIME_MODIFIER = 0;
    /**
     * Method to convert a LocalDate entry into a string representing date in the format dd/mm/yyyy.
     * @param date Input date to be converted
     * @return Converted result string
     */
    public static String formatToStringDate(LocalDate date) {
        String year = date.getYear() + "";
        String month = date.getMonthValue() + "";
        String day = date.getDayOfMonth() + "";
        return day + "/" + month + "/" + year;
    }
    /**
     * Method to convert a LocalTime entry into a string representing time in the formate HH:mm.
     * @param time Input time to be converted
     * @return Converted result string
     */
    public static String formatToStringTime(LocalTime time) {
        String hour = time.getHour() + "";
        String minute = "";
        if (time.getMinute() == 0) {
            minute = "00";
        } else {
            minute = time.getMinute() + "";
        }
        return hour + ":" + minute;
    }
    /**
     * Method to convert a string entry in dd/mm/yyyy format into a LovalDate data. Throws DateTimeParseException if errors occur.
     * @param date Input formatted string to be converted
     * @return Converted result LocalDate data
     * @throws DateTimeParseException exception to be thrown if the input string is incorrectly formatted.
     */
    public static LocalDate formatToLocalDate(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(date, formatter);
    }
    /**
     * Method to convert a string entry in HH:mm into a LocalTime data. Throws DateTimeParseException if errors occur.
     * @param time Input formatted string to be converted
     * @return Converted result LocalTime data
     * @throws DateTimeParseException exception to be thrown if the input string is incorrectly formatted
     */
    public static LocalTime formatToLocalTime(String time) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }
    /**
     * Calculate and return the difference in two time stamps in minutes.
     * @param time1 the first time entry
     * @param time2 the second time entry
     * @return the difference of the two time entries in minutes
     */
    public static long getTimeDifferenceMinutes(LocalTime time1, LocalTime time2) {
        return time1.until(time2, ChronoUnit.MINUTES);
    }
    /**
     * Compare if an input date is before the date of today. Return true if the input is before today.
     * @param inputDate the input date for comparison
     * @return the comparison result. true if the input date is before today.
     */
    public static boolean compareIfBeforeToday(LocalDate inputDate) {
        return inputDate.isBefore(DateTimeFormatHelper.inbuiltDate());
    }
    /**
     * Check if an input time is within a certain operation session of restaurant. Return true if yes.
     * @param resvTime input time to be compared with restaurant operation sessions
     * @param sessionStart start time of the operation session
     * @param sessionEnd end time of the operation session
     * @return the return boolean value. True if the input time is within the operation session.
     */
    public static boolean checkResvTimeSession(LocalTime resvTime, LocalTime sessionStart, LocalTime sessionEnd) {
        return ((resvTime.isAfter(sessionStart) && resvTime.isBefore(sessionEnd)) ||
                resvTime.equals(sessionStart) || resvTime.equals(sessionEnd));
    }
    /**
     * Take an input string and validate if the string is correctly formatted, and if the string represents a meaningful date.
     * Validate for the following:
     * 1.Months with 30 days.
     * 2.Febrarys with 28 or 29 days.
     * 3.Validate months and days input.
     * Return boolean true if the string is correctedly formatted and represents a valid date, and return false otherwise.
     * @param date input string to be verified
     * @return return true if the string is correctly formatted, and represents a valid date
     * @throws InputMismatchException Thrown if the string cannot be parsed to integer
     * @throws NumberFormatException Thrown if string input is received
     * @throws ArrayIndexOutOfBoundsException Thrown if the format of input string is incorrect
     */
    public static boolean validateDate(String date) throws InputMismatchException, NumberFormatException, ArrayIndexOutOfBoundsException {
        try {
            String[] dateSplit = date.split("/");
            int d = Integer.parseInt(dateSplit[0]);
            int m = Integer.parseInt(dateSplit[1]);
            int y = Integer.parseInt(dateSplit[2]);

            if ((((m == 4) || (m == 6)) || ((m == 9) || (m == 11))) && (d > 30)) {
                System.out.println("Invalid date!");
                return false;
            } else if (((y % 4 == 0) || ((y % 100 == 0) && (y % 400 == 0))) && ((m == 2) && (d >= 30))) {
                System.out.println("Invalid date!");
                return false;
            } else if (((y % 4 != 0) || ((y % 100 == 0) && (y % 400 != 0))) && ((m == 2) && (d >= 29))) {
                System.out.println("Invalid date!");
                return false;
            } else if (m < 1 || m > 12) {
                System.out.println("Invalid date!");
                return false;
            } else if (d < 1 || d > 31) {
                System.out.println("Invalid date!");
                return false;
            } else {
                return true;
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR! Date has an invalid input!");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Error! Invalid input!");
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR! Date has wrong format!");
            return false;
        }
    }
    /**
     * Return the program date and time with the modifier.
     * Note: the modified program time is ahead of real system time.
     * @returnv return the program date and time
     */
    public static LocalDateTime inbuiltDateTime() {
    	return LocalDateTime.now().plus(TIME_MODIFIER,ChronoUnit.MINUTES);
    }
    /**
     * Return the program date with the modifier.
     * @return return the program date
     */
    public static LocalDate inbuiltDate() {
    	return inbuiltDateTime().toLocalDate();
    }
    /**
     * Return the program time with the modifier
     * @return return the program time
     */
    public static LocalTime inbuiltTime() {
    	return inbuiltDateTime().toLocalTime();
    }
    /**
     * Return the operation session the input time is in. Return null if the input time is not in an operation session.
     * @param time input time to be checked
     * @return the session the input time is in. Null if the input time is not in a session.
     */
    public static Reservation.ReservationSession inbuiltSession(LocalTime time){
        if(time.compareTo(LocalTime.of(10, 0)) > 0 && time.compareTo(LocalTime.of(16, 00)) < 0) {
            return Reservation.ReservationSession.AM;
        } else if (time.compareTo(LocalTime.of(18, 0)) > 0 && time.compareTo(LocalTime.of(23, 59)) < 0) {
            return Reservation.ReservationSession.PM;
        }
        return null;
    }
    /**
     * Function for manually advance program time. The global variable TIME_MODIFIER is incremented. Options are provided to 
     * advance time in days, hours or minutes.
     */
    public static void advanceTime() {
    	System.out.print("Advance Time Options:\n"
    			+ "1. In days\n"
    			+ "2. In hours\n"
    			+ "3. In minutes\n");
        System.out.print("Your choice: ");
    	int choice;
    	int amount;
    	do {
    		choice = input.nextInt(); input.nextLine();
        	switch(choice) {
                case (1):{
                    System.out.println("Enter number of days:");
                    amount = input.nextInt(); input.nextLine();
                    while (amount < 0) {
                        System.out.println("Time must not be negative. Re-enter:");
                        amount = input.nextInt(); input.nextLine();
                    }
                    incrementModifier(24*60*amount);
                    break;
                }
                case (2):{
                    System.out.println("Enter number of hours:");
                    amount = input.nextInt(); input.nextLine();
                    while (amount < 0) {
                        System.out.println("Time must not be negative. Re-enter:");
                        amount = input.nextInt(); input.nextLine();
                    }
                    incrementModifier(60*amount);
                    break;
                }
                case (3):{
                    System.out.println("Enter number of minutes:");
                    amount = input.nextInt(); input.nextLine();
                    while (amount < 0) {
                        System.out.println("Time must not be negative. Re-enter:");
                        amount = input.nextInt(); input.nextLine();
                    }
                    incrementModifier(amount);
                    break;
                }
                default:{
                    System.out.println("Invalid choice. Re-enter: ");
                }
        	}
    	} while (choice < 0 || choice > 3);
        System.out.println("Time has been advanced, it is now " + formatToStringDate(inbuiltDate()) + " " + formatToStringTime(inbuiltTime()) + ".");
    	synchronize();
    }
    /**
     * The mutator for the global variable TIME_MODIFIER called by advanceTIme().
     * @param minute the amoount in minutes the program time to be advanced.
     */
    private static void incrementModifier(int minute) {
    	TIME_MODIFIER += minute;
    }
    /**
     * Synchronize the program. Check for any expired reservations and update table status if applicable.
     */
    public static void synchronize() {
    	ReservationManager.checkExpiredReservations();
    	TableManager.updateTableStatus();
    }
}
