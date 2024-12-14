package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    private final String nickName;
    private final LocalDate date;
    private LocalTime time;
    private final Status status;

    private Attendance(String nickName, LocalDate date, LocalTime time, Status status) {
        this.nickName = nickName;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public static Attendance of(String name, LocalDate date, LocalTime time, Status status) {
        return new Attendance(name, date, time, status);
    }

    public void modifyTime(LocalTime changeTime) {
        this.time = changeTime;
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

    public Status getStatus() {
        return status;
    }
}
