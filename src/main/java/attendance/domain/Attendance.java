package attendance.domain;

public class Attendance {

    private final String nickName;
    private final String date;
    private final String time;

    private Attendance(String nickName, String date, String time) {
        this.nickName = nickName;
        this.date = date;
        this.time = time;
    }

    public static Attendance of(String name, String date, String time) {
        return new Attendance(name, date, time);
    }

    public String getNickName() {
        return nickName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
