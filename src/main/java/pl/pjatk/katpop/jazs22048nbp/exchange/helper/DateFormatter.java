package pl.pjatk.katpop.jazs22048nbp.exchange.helper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault() );

    public static String formatDateTime(Instant instant) {
        return DATE_TIME_FORMAT.format(instant);
    }

    private DateFormatter() {
    }
}
