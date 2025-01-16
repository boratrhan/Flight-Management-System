import java.sql.Time;
import java.util.Date;

public class CustomSchedule {
    private Date customDate;
    private Time departureTime;

    public CustomSchedule(Date customDate, Time departureTime) {
        this.customDate = customDate;
        this.departureTime = departureTime;
    }

    public Date getCustomDate() {
        return customDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }
}

