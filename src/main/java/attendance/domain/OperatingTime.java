package attendance.domain;

import static attendance.exception.ErrorMessage.NOT_OPERATING_TIME;

import java.time.LocalTime;

public enum OperatingTime {
    OPERATING_TIME(LocalTime.parse("08:00"), LocalTime.parse("23:00"));

    private final LocalTime startTime;
    private final LocalTime endTime;

    OperatingTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static void validateInputTime(LocalTime inputTime) {
        if (!inputTime.isBefore(OPERATING_TIME.startTime) && !inputTime.isAfter(OPERATING_TIME.endTime)) {
            return;
        }
        throw new IllegalArgumentException(NOT_OPERATING_TIME.getMessage());
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
