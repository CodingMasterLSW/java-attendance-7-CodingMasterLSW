package attendance.view;

import static attendance.exception.ErrorMessage.INVALID_FORMAT;
import static attendance.exception.ErrorMessage.INVALID_INPUT;
import static attendance.exception.ErrorMessage.NOT_BLANK_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class InputView {

    private static final String FUNCTION_CHOICE_MESSAGE = "오늘은 %s월 %s일 %s입니다. 기능을 선택해 주세요.";
    private static final String FUNCTION = "1. 출석 확인\n" +
            "2. 출석 수정\n" +
            "3. 크루별 출석 기록 확인\n" +
            "4. 제적 위험자 확인\n" +
            "Q. 종료";
    private static final String INPUT_NICKNAME_MESSAGE = "닉네임을 입력해 주세요.";
    private static final String INPUT_ATTENDANCE_TIME_MESSAGE = "등교 시간을 입력해 주세요.";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String inputFunction() {
        printMessage(FUNCTION);
        String userInput = userInput();
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

    public String inputTime() {
        printMessage(INPUT_ATTENDANCE_TIME_MESSAGE);
        String userInput = userInput();
        validateTimeFormat(userInput);
        return userInput;
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

}
