
public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Time(int hour) {
        this.hour = hour;
        this.minute = 0;
    }
    //Getters
    public int getHour() {
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    //Setters
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    //Other Methods
    public String toString() {
        //If AM Time
        if (checkAMHour(hour)) {
            return makeTimeString(hour, minute) + " am";
        }
        else {
            return makeTimeString(hour, minute) + " pm";
            
        }
    }
    /**
     * Check which period of the day the hour falls into
     * @param hour the hour of time
     * @return Whether the time falls in am (T) or pm (F)
     */
    private boolean checkAMHour(int hour) {
        return hour < 12 || hour == 24;
    }
    /**
     * For the sake of printing to the terminal: 
     * figure out if a number will need a 0 before it
     * @param number the hour or minute in question
     * @return Whether a 0 should be added before the number in the print string
     */
    private boolean checkBelow10(int number) {
        return number < 10;
    }
    /**
     * Express Time as a string to be printed
     * @param hour the hour from Time
     * @param minute the minute from Time
     * @return a string representation of the Time object
     */
    private String makeTimeString(int hour, int minute) {
        hour %= 12;
        if (hour == 0) {
            hour = 12;
        }
        if (checkBelow10(hour) && checkBelow10(minute)){
            return "0" + hour + ":0" + minute;
        }
        else if (checkBelow10(hour) && !checkBelow10(minute)) {
            return "0" + hour + ":" + minute;
        }
        else if (!checkBelow10(hour) && checkBelow10(minute)) {
            return hour + ":0" + minute;
        }
        else {
            return hour + ":" + minute;
        }
    }
}
