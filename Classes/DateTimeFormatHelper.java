import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.InputMismatchException;

public class DateTimeFormatHelper {

    private final static long MILLIS_TO_DAYS = 1000 * 60 * 60 * 24;
    private final static long TO_UTC_8 = 28800000;

    public static String formatToStringDate(LocalDate date) {
        String day, month, year;
        year = date.getYear() + "";
        month = date.getMonthValue() + "";
        day = date.getDayOfMonth() + "";
        return day + "/" + month + "/" + year;
    }

    public static String formatToStringTime(LocalTime time) {
        String hour, minute;
        hour = time.getHour() + "";
        minute = ((time.getMinute() == 0) ? "00" : time.getMinute()) + "";
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

    public static LocalDate getTodayDate(boolean getNextMonth) {
        if (!getNextMonth)
            return LocalDate.ofEpochDay(getSysTimeMillisWithSGTimeZone() / MILLIS_TO_DAYS);
        else {
            return LocalDate.ofEpochDay(getSysTimeMillisWithSGTimeZone() / MILLIS_TO_DAYS + 30);
        }
    }

    public static LocalTime getTimeNow() {
        return LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public static long getTimeDifferenceMinutes(LocalTime time1, LocalTime time2) {
        return time1.until(time2, ChronoUnit.MINUTES);
    }

    public static boolean compareIfBeforeToday(LocalDate inputDate) {
        return inputDate.isBefore(LocalDate.ofEpochDay(getSysTimeMillisWithSGTimeZone() / MILLIS_TO_DAYS));
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
            }
            else if (((y % 4 != 0) || ((y % 100 == 0) && (y % 400 != 0))) && ((m == 2) && (d >= 29))) {
                System.out.println("Invalid date!");
                return false;
            }
            else if (((y % 4 == 0) || ((y % 100 == 0) && (y % 400 == 0))) && ((m == 2) && (d >= 30))) {
                System.out.println("Invalid date!");
                return false;
            }
            else if (m < 1 || m > 12) {
                System.out.println("Invalid date!");
                return false;
            }
            else if (d < 1 || d > 31) {
                System.out.println("Invalid date!");
                return false;
            }
            else {
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

    public static long getTimeWithSGTimeZone() {
        return System.currentTimeMillis() + TO_UTC_8;
    }
}