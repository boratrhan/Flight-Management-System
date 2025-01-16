import java.sql.Time;

public class WeeklySchedule {
    private int dayOfWeek;
    private Time departureTime;

    public WeeklySchedule(int dayOfWeek, Time departureTime) {
        this.dayOfWeek = dayOfWeek;
        this.departureTime = departureTime;
    }

    public int getDayOfWeek() {

        return dayOfWeek;
    }

    public Time getDepartureTime() {

        return departureTime;
    }
}
