package attendance.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public enum Day {

    MONDAY("월요일", LocalTime.of(13,00), LocalTime.of(18,00)),
    TUESDAY("화요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    WEDNESDAY("수요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    THURSDAY("목요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    FRIDAY("금요일", LocalTime.of(10,00), LocalTime.of(18,00));

    private static final int LATE_STANDARD = 5;
    private static final int ABSENT_STANDARD = 30;

    private final String day;
    private final LocalTime startTime;
    private final LocalTime endTime;

    Day(String day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Status decideAttendanceStatus(LocalDateTime now, LocalTime inputTime) {
        Day day = findDay(now);
        LocalTime startTime = day.startTime;
        int hour = startTime.getHour();
        int inputHour = inputTime.getHour();
        int inputMinute = inputTime.getMinute();
        int lateHour = inputHour - hour;
        if (lateHour >= 1 || inputMinute > ABSENT_STANDARD) {
            return Status.결석;
        }
        if (inputTime.getMinute() > LATE_STANDARD) {
            return Status.지각;
        }
        return Status.출석;
    }

    private static Day findDay(LocalDateTime now) {
        String inputDay = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA);
        return Arrays.stream(Day.values())
                .filter(day -> day.day.equals(inputDay))
                .findFirst()
                .orElse(null);
    }

}
