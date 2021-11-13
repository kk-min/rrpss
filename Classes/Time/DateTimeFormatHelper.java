package Classes.Time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Classes.Reservation.Reservation;
import Classes.Reservation.ReservationManager;
import Classes.Table.TableManager;

public class DateTimeFormatHelper {

    private final static long MILLIS_TO_DAYS = 1000 * 60 * 60 * 24;
    private final static long TO_UTC_8 = 28800000;
    private static long TIME_MODIFIER = 0;

    public static String formatToStringDate(LocalDate date) {
        String year = date.getYear() + "";
        String month = date.getMonthValue() + "";
        String day = date.getDayOfMonth() + "";
        return day + "/" + month + "/" + year;
    }

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
    
    public static LocalDate formatToLocalDate(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalTime formatToLocalTime(String time) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }

    public static LocalDate getTodayDate() {
        return LocalDate.ofEpochDay(SGTimeZone() / MILLIS_TO_DAYS);
    }

    public static LocalTime getTimeNow() {
        return LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public static long getTimeDifferenceMinutes(LocalTime time1, LocalTime time2) {
        return time1.until(time2, ChronoUnit.MINUTES);
    }

    public static boolean compareIfBeforeToday(LocalDate inputDate) {
        return inputDate.isBefore(LocalDate.ofEpochDay(SGTimeZone() / MILLIS_TO_DAYS));
    }

    public static String formatMillisToDateTime(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy HH:mm");
        return sdf.format(new Date(millis));
    }

    public static boolean checkResvTimeSession(LocalTime resvTime, LocalTime sessionStart, LocalTime sessionEnd) {
        return ((resvTime.isAfter(sessionStart) && resvTime.isBefore(sessionEnd)) ||
                resvTime.equals(sessionStart) || resvTime.equals(sessionEnd));
    }

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

    public static long SGTimeZone() {
        return System.currentTimeMillis() + TO_UTC_8;
    }
    
    public static LocalDateTime inbuiltDateTime() {
    	return LocalDateTime.now().plus(TIME_MODIFIER,ChronoUnit.MINUTES);
    }
    
    public static LocalDate inbuiltDate() {
    	return inbuiltDateTime().toLocalDate();
    }
    public static LocalTime inbuiltTime() {
    	return inbuiltDateTime().toLocalTime();
    }

    public static Reservation.ReservationSession inbuiltSession(LocalTime time){
        if(time.compareTo(LocalTime.of(10, 0)) > 0 && time.compareTo(LocalTime.of(16, 00)) < 0) {
            return Reservation.ReservationSession.AM;
        } else if (time.compareTo(LocalTime.of(18, 0)) > 0 && time.compareTo(LocalTime.of(23, 59)) < 0) {
            return Reservation.ReservationSession.PM;
        }     
        return null;
    }

    public static void advanceTime() {
    	System.out.print("Advance Time Options:\n"
    			+ "1. In days\n"
    			+ "2. In hours\n"
    			+ "3. In minutes\n");
    	Scanner sc = new Scanner(System.in);
    	int choice;
    	int amount;
    	do {
    		choice = sc.nextInt();
        	switch(choice) {
        	case (1):{
        		System.out.println("Enter number of days:");
        		amount = sc.nextInt();
        		while (amount < 0) {
        			System.out.println("Time must not be negative. Reenter:");
        			amount = sc.nextInt();
        		}
        		incrementModifier(24*60*amount);
        		break;
        	}
        	case (2):{
        		System.out.println("Enter number of hours:");
        		amount = sc.nextInt();
        		while (amount < 0) {
        			System.out.println("Time must not be negative. Reenter:");
        			amount = sc.nextInt();
        		}
        		incrementModifier(60*amount);
        		break;
        	}
        	case (3):{
        		System.out.println("Enter number of minutes:");
        		amount = sc.nextInt();
        		while (amount < 0) {
        			System.out.println("Time must not be negative. Reenter:");
        			amount = sc.nextInt();
        		}
        		incrementModifier(amount);
        		break;
        	}
        	default:{
        		System.out.println("Invalid choice.");
        	}
        	}
    	}while(choice < 0 || choice > 3);
        synchronize();
    	sc.close();
    }
    
    private static void incrementModifier(int minute) {
    	TIME_MODIFIER += minute;
    }
    
    private static void synchronize() {
    	ReservationManager.checkExpiredReservations();
    	TableManager.updateTableStatus();
    }
}
