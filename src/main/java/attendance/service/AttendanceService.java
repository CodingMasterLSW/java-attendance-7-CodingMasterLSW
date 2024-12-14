package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.AttendanceRepository;
import attendance.utils.FileLoader;
import java.util.List;

public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public void initAttendance() {
        List<String> loadFiles = FileLoader.loadFile();
        String nickName = loadFiles.get(0);
        String date = loadFiles.get(1);
        String time = loadFiles.get(2);
        Attendance attendance = Attendance.of(nickName, date, time);
        attendanceRepository.add(attendance);
    }

}
