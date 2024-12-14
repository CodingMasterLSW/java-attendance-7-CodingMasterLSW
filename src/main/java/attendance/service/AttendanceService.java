package attendance.service;

import attendance.utils.FileLoader;
import java.util.List;

public class AttendanceService {

    public List<String> readFile() {
        return FileLoader.loadFile();
    }

}
