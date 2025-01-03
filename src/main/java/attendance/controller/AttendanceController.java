package attendance.controller;

import attendance.domain.Attendance;
import attendance.domain.OperatingTime;
import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
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
            if (handleProcess(functionChoice, now)) {
                break;
            }
        }
    }

    private boolean handleProcess(String functionChoice, LocalDateTime now) {
        if (functionChoice.equals("Q")) {
            return true;
        }
        String nickName = inputView.inputNickName();
        attendanceService.validateInputNickName(nickName);
        if (functionChoice.equals("1")) {
            handleCheckAttendance(nickName, now);
        }
        if (functionChoice.equals("2")) {
        }
        if (functionChoice.equals("3")) {
            handleModifyAttendance(nickName);
        }
        return false;
    }

    private void handleModifyAttendance(String nickName) {
        List<Attendance> attendances = attendanceService.getAttendances(nickName);
        outputView.printAllAttendanceInfo(attendances);
    }

    private void handleCheckAttendance(String nickName, LocalDateTime now) {
        LocalTime inputTime = inputView.inputTime();
        OperatingTime.validateInputTime(inputTime);
        Attendance attendance = attendanceService.createAttendance(nickName, now,
                inputTime);
        outputView.printAttendanceTime(attendance);
    }

}
