
public class Time {
    private int hour;
    private int minute;

    /**
    * Sets the local variables to their passed in parameters
    * @param hour for the time
    * @param minute for the time
    */
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
    * Sets the local variables to their passed in parameters
    * @param hour for the time
    * @param minute set to 0
    */
    public Time(int hour) {
        this.hour = hour;
        this.minute = 0;
    }
    /**
     * Alternative Constructor for Time
     * @param time in the format of ("hh:mm am") 
     * or ("hh:mm pm")
     */
    public Time(String time) {
        //If we get "9:34 am", get {"9", "34 am"}
        String[] firstCut = time.split(":");
        //In our example this will have {"34", "am"}
        String[] secondCut = firstCut[1].split(" ");
        this.hour = Integer.parseInt(firstCut[0]);
        this.minute = Integer.parseInt(secondCut[0]);
        if (secondCut[1].equalsIgnoreCase("pm") && hour < 12 || 
        (hour == 12 && secondCut[1].equalsIgnoreCase("am"))) {
            this.hour += 12;
        }
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
    static boolean checkAMHour(int hour) {
        return hour < 12 || hour == 24;
    }
    /**
     * For the sake of printing to the terminal: 
     * figure out if a number will need a 0 before it
     * @param number the hour or minute in question
     * @return Whether a 0 should be added before the number in the print string
     */
    static boolean checkBelow10(int number) {
        return number < 10;
    }
    /**
     * Express Time as a string to be printed
     * @param hour the hour from Time
     * @param minute the minute from Time
     * @return a string representation of the Time object
     */
    static String makeTimeString(int hour, int minute) {
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
