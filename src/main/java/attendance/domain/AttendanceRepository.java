package attendance.domain;

import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository {

    private final List<Attendance> attendances = new ArrayList<>();

    private AttendanceRepository() {
    }

    public static AttendanceRepository create() {
        return new AttendanceRepository();
    }

    public void add(Attendance attendance) {
        attendances.add(attendance);
    }

    public boolean hasNickName(String nickName) {
        Attendance hasNickName = attendances.stream()
                .filter(attendance -> attendance.getNickName().equals(nickName))
                .findFirst()
                .orElse(null);
        if (hasNickName == null) {
            return false;
        }
        return true;
    }

}
