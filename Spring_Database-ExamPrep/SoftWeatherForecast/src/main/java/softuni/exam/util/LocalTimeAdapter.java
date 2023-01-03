package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

    private final DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_TIME;

    @Override
    public LocalTime unmarshal(String time) throws Exception {
        return LocalTime.parse(time, dtf);
    }

    @Override
    public String marshal(LocalTime localTime) throws Exception {
        return localTime.format(dtf);
    }
}
