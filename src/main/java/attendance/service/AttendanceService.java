package attendance.service;

import static attendance.exception.ErrorMessage.NOT_EXIST_NICKNAME;

import attendance.domain.Attendance;
import attendance.domain.AttendanceRepository;
import attendance.utils.FileLoader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public void initAttendance() {
        List<String> loadFiles = FileLoader.loadFile();
        for (String loadFile : loadFiles) {
            List<String> crewInfo = List.of(loadFile.split(",| "));
            String nickName = crewInfo.get(0);
            LocalDate date = LocalDate.parse(crewInfo.get(1));
            LocalTime time = LocalTime.parse(crewInfo.get(2));
            Attendance attendance = Attendance.of(nickName, date, time);
            attendanceRepository.add(attendance);
        }
    }

    public void createAttendance(String nickName, LocalDateTime now, LocalTime inputTime) {
        Attendance attendance = Attendance.of(nickName, now.toLocalDate(), inputTime);
        attendanceRepository.add(attendance);
    }

    public void validateInputNickName(String nickName) {
        boolean hasNickName = attendanceRepository.hasNickName(nickName);
        if(hasNickName) {
            return;
        }
        throw new IllegalArgumentException(NOT_EXIST_NICKNAME.getMessage());
    }

}
