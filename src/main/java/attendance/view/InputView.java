package attendance.view;

import static attendance.exception.ErrorMessage.INVALID_FORMAT;
import static attendance.exception.ErrorMessage.INVALID_INPUT;
import static attendance.exception.ErrorMessage.NOT_ATTENDANCE_DAY;
import static attendance.exception.ErrorMessage.NOT_BLANK_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;

public class InputView {

    private static final String BLANK = "";
    private static final String FUNCTION = "1. 출석 확인\n" +
            "2. 출석 수정\n" +
            "3. 크루별 출석 기록 확인\n" +
            "4. 제적 위험자 확인\n" +
            "Q. 종료";
    private static final String INPUT_NICKNAME_MESSAGE = "닉네임을 입력해 주세요.";
    private static final String INPUT_ATTENDANCE_TIME_MESSAGE = "등교 시간을 입력해 주세요.";
    private static final String DATE_INFO_MESSAGE = "오늘은 %s월 %s일 %s입니다. 기능을 선택해 주세요.";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String inputFunction(LocalDateTime now) {
        printMessage(FUNCTION);
        String userInput = userInput();
        validateDay(userInput, now);
        validateFunction(userInput);
        return userInput;
    }

    public String userInput() {
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public String inputNickName() {
        printMessage(INPUT_NICKNAME_MESSAGE);
        return userInput();
    }

    public LocalTime inputTime() {
        printMessage(INPUT_ATTENDANCE_TIME_MESSAGE);
        String userInput = userInput();
        LocalTime localTime = validateTimeFormat(userInput);
        return localTime;
    }

    public void printDateInfo(LocalDateTime now) {
        System.out.printf(DATE_INFO_MESSAGE, now.getMonth().getValue(),
                now.getDayOfMonth(),
                now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA));
        printMessage(BLANK);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void validateInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(NOT_BLANK_INPUT.getMessage());
        }
    }

    private void validateFunction(String userInput) {
        if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3")
                || userInput.equals("4") || userInput.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    private LocalTime validateTimeFormat(String userInput) {
        try {
            LocalTime localTime = LocalTime.parse(userInput);
            return localTime;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private void validateDay(String userInput, LocalDateTime now) {
        if (!userInput.equals("1")) {
            return;
        }
        String day = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREA);
        if (day.equals("토요일") || day.equals("일요일")) {
            throw new IllegalArgumentException(
                    String.format(
                            NOT_ATTENDANCE_DAY.getMessage(),
                            now.getMonth().getValue(),
                            now.getDayOfMonth(),
                            day
                    )
            );
        }
    }
}
