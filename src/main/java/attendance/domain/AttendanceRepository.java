package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Attendance> getAttendancesByName(String nickName) {
        return attendances.stream()
                .filter(attendance -> attendance.getNickName().equals(nickName))
                .collect(Collectors.toList());
    }

    public void modifyAttendance(String nickName, String date, LocalTime inputTime) {
        LocalDate localDate = LocalDate.parse(date);
        Attendance findAttendance = attendances.stream()
                .filter(attendance -> attendance.getNickName().equals(nickName) &&
                        attendance.getDate().equals(localDate))
                .findFirst()
                .orElse(null);
        findAttendance.modifyTime(inputTime);
    }

}
