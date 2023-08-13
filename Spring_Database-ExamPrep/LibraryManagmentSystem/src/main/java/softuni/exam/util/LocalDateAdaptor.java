package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdaptor extends XmlAdapter<String, LocalDate> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date, dateTimeFormatter);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.format(dateTimeFormatter);
    }
}
