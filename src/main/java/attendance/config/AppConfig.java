package attendance.config;

import attendance.controller.AttendanceController;
import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static AttendanceController createController() {
        return new AttendanceController(InputView.create(), OutputView.create(), createService());
    }

    public static AttendanceService createService() {
        return new AttendanceService();
    }

}
