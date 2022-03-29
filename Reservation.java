/**
 * A Class for Reservations for Flights, Rooms, and Car Rentals
 * @author rcd1
 */

public class Reservation {
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;

    /**
     * Sets local variables to passed in parameters
     * @param start date for the date
     * @param end date for the date
     * @param start time for the time
     * @param end time for the time
     */
    public Reservation(Date startDate, Date endDate, Time startTime, Time endTime) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Reservation(String startDate, String endDate, String startTime, String endTime) {
        this.startDate = new Date(startDate);
        this.endDate = new Date(endDate);
        this.startTime = new Time(startTime);
        this.endTime = new Time(endTime);
    }
    //Getters
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public Time getStartTime() {
        return startTime;
    }
    public Time getEndTime() {
        return endTime;
    }
    //Setters
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    //Other Methods
    public String toString() {
        return startDate.toString() + ": " + startTime.toString() +
        "\n" + endDate.toString() + ": " + endTime.toString(); 
    }
}
