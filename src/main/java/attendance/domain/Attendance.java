package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    private final String nickName;
    private final LocalDate date;
    private final LocalTime time;

    private Attendance(String nickName, LocalDate date, LocalTime time) {
        this.nickName = nickName;
        this.date = date;
        this.time = time;
    }

    public static Attendance of(String name, LocalDate date, LocalTime time) {
        return new Attendance(name, date, time);
    }

    public String getNickName() {
        return nickName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
