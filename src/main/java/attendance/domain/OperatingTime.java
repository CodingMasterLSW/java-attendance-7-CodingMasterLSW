package attendance.domain;

import static attendance.exception.ErrorMessage.NOT_OPERATING_TIME;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public enum OperatingTime {

    MONDAY("월요일", LocalTime.of(13,00), LocalTime.of(18,00)),
    TUESDAY("화요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    WEDNESDAY("수요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    THURSDAY("목요일", LocalTime.of(10,00), LocalTime.of(18,00)),
    FRIDAY("금요일", LocalTime.of(10,00), LocalTime.of(18,00));

    private final String day;
    private final LocalTime startTime;
    private final LocalTime endTime;

    OperatingTime(String day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static void validateInputTime(LocalDateTime now, LocalTime localTime) {
        OperatingTime day = findDay(now);
        if (!localTime.isBefore(day.startTime) && !localTime.isAfter(day.endTime)) {
            return;
        }
        throw new IllegalArgumentException(NOT_OPERATING_TIME.getMessage());
    }

    //public Status decideAttendanceStatus(LocalDateTime now, LocalTime localTime) {
        //OperatingTime day = findDay(now);
        //if (localTime)
   // }

    private static OperatingTime findDay(LocalDateTime now) {
        String inputDay = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA);
        return Arrays.stream(OperatingTime.values())
                .filter(operatingTime -> operatingTime.day.equals(inputDay))
                .findFirst()
                .orElse(null);
    }

    public String getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}
