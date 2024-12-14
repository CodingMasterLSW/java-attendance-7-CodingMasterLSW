package attendance.view;

import attendance.domain.Attendance;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class OutputView {

    private static final String ATTENDANCE_INFO_MESSAGE = "%s월 %s일 %s %s (%s)";
    private static final String BLANK = "";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    public void printAttendanceTime(Attendance attendance) {
        LocalDate date = attendance.getDate();
        LocalTime time = attendance.getTime();
        String day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA);
        System.out.printf(ATTENDANCE_INFO_MESSAGE,
                date.getMonth().getValue(), date.getDayOfMonth(), day, time, attendance.getStatus());
        printMessage(BLANK);
    }

    public void printAllAttendanceInfo(List<Attendance> attendances) {
        for (Attendance attendance : attendances) {
            LocalDate date = attendance.getDate();
            LocalTime time = attendance.getTime();
            String day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA);
            System.out.printf(ATTENDANCE_INFO_MESSAGE,
                    date.getMonth().getValue(), date.getDayOfMonth(), day, time, attendance.getStatus());
            printMessage(BLANK);
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
