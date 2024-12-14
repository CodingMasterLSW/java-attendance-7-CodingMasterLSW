package attendance.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class OutputView {

    private static final String ATTENDANCE_INFO_MESSAGE = "%s월 %s일 %s %s %s";
    private static final String BLANK = "";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    public void printAttendanceTime(LocalDateTime now, LocalTime time, boolean isNotLate) {
        LocalDate localDate = now.toLocalDate();
        String day = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA);
        if (isNotLate) {
            System.out.printf(ATTENDANCE_INFO_MESSAGE,
                    localDate.getMonth().getValue(), localDate.getDayOfMonth(), day, time, "(출석)");
            printMessage(BLANK);
            return;
        }
        System.out.printf(ATTENDANCE_INFO_MESSAGE,
                localDate.getMonth().getValue(), localDate.getDayOfMonth(), day, time, "(지각)");
        printMessage(BLANK);

    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
