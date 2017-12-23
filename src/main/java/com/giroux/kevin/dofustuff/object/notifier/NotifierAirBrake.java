package com.giroux.kevin.dofustuff.object.notifier;

import io.airbrake.javabrake.Notice;
import io.airbrake.javabrake.Notifier;

public class NotifierAirBrake {

    private static Notifier notifier;
    private static Integer projectId = 168529;
    private static String projectKey = "b463c4d80175e332e3ff658b17d2c476";

    public static Notifier getInstance() {

        if(NotifierAirBrake.notifier == null) {
            NotifierAirBrake.notifier =  new Notifier(NotifierAirBrake.projectId, NotifierAirBrake.projectKey);

            NotifierAirBrake.notifier.addFilter(
                    (Notice notice) -> {
                        notice.setContext("environment", "production");
                        return notice;
                    });
        }
        return NotifierAirBrake.notifier;
    }
}
