package by.bookStore.jdbc.util.timeUtil;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

public class TimeFormatter {
    public static String fromDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", myDateFormatSymbols);
        return sdf.format(date);
    }

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){

        @Override
        public String[] getMonths() {
            return new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                    "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        }

    };
}
