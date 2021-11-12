package Classes.Time;

public class Clock {
    private static int clockValue = 0; // Tracked in seconds

    public Clock(){}

    public static void advanceTime(int period, String interval){

        switch(interval){
            case "second":
                clockValue += period;
                break;
            case "minute":
                clockValue += 60*period;
                break;
            case "hour":
                clockValue += 60*60*period;
            break;
            case "day":
                clockValue += 24*60*60*period;
                break;
            case "month":
                clockValue += 30*24*60*60*period; // Assume every month has 30 days
                break;
            case "year":
                clockValue += 12*30*24*60*60*period;
                break;
            default:
                break;
        }
    }

    public static int getTime(){
        return clockValue;
    }
}
