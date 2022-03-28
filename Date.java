public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int month, int day, int year) {
        this.month= month;
        this.day = day;
        this.year = year;
    }
    /**
     * Alternative Constructor
     * Builds from a String
     * @param date The date in format ("mm/dd/yy")
     */
    public Date(String date) {
        String[] strToInt = date.split("/");
        this.month = Integer.parseInt(strToInt[0]);
        this.day = Integer.parseInt(strToInt[1]);
        this.year = Integer.parseInt(strToInt[2]);
    }
/*------------------------------------------Getters----------------------------------------*/
    public int getDay() {
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
/*----------------------------------------Other Methods--------------------------------------*/
    public String toString() {
        return makeDateString(month, day, year);
    }
    /**
     * For the sake of printing to the terminal: 
     * figure out if a number will need a 0 before it
     * @param number the month, day, or year in question
     * @return Whether a 0 should be added before the number in the print string
     */
    private boolean checkBelow10(int number) {
        return number < 10;
    }
    /**
     * Express Date as a String in every case
     * @param month the month of Date
     * @param day the day of Date
     * @param year the year of Date
     * @return a String representation of the Date
     */
    private String makeDateString(int month, int day, int year) {
        boolean monthCheck = checkBelow10(month);
        boolean dayCheck = checkBelow10(day);
        boolean yearCheck = checkBelow10(year);

        if (monthCheck && dayCheck && yearCheck) {
            return "0" + month + "/0" + day + "/0" + year;
        }
        else if (monthCheck && dayCheck && !yearCheck) {
            return "0" + month + "/0" + day + "/" + year;
        }
        else if(monthCheck && !dayCheck && yearCheck)  {
            return "0" + month + "/" + day + "/0" + year;
        }
        else if (monthCheck && !dayCheck && !yearCheck) {
            return "0" + month + "/" + day + "/" + year;
        }
        else if (!monthCheck && dayCheck && yearCheck) {
            return month + "/0" + day + "/0" + year;
        }
        else if (!monthCheck && dayCheck && !yearCheck) {
            return month + "/0" + day + "/" + year;
        }
        else if (!monthCheck && !dayCheck && yearCheck) {
            return month + "/" + day + "/0" + year;
        }
        else if (!monthCheck && !dayCheck && !yearCheck) {
            return month + "/" + day + "/" + year;
        }
        return "Invalid Date";
    }
    /**
     * Compare Two Dates
     * @param compDate the Date being compared to
     * @return whether or not the Dates are the same
     */
    public boolean checkDate(Date compDate) {
        
        return month == compDate.getMonth() && day == compDate.getDay() && year == compDate.getYear();
    }
}
