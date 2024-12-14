package attendance.controller;

import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Supplier;

public class AttendanceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final AttendanceService attendanceService;

    public AttendanceController(InputView inputView, OutputView outputView,
            AttendanceService attendanceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.attendanceService = attendanceService;
    }

    public void start() {
        attendanceService.initAttendance();
        while (true) {
            LocalDateTime now = DateTimes.now();
            inputView.printDateInfo(now);

            String functionChoice = inputView.inputFunction(now);
            if (functionChoice.equals("Q")) {
                break;
            } else {
                String nickName = inputView.inputNickName();
                attendanceService.validateInputNickName(nickName);

                LocalTime inputTime = inputView.inputTime();
                attendanceService.createAttendance(nickName, now, inputTime);
            }
        }
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
