package ait.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {
    public static int getAge(String birthDate) {
        LocalDate date = parseDate(birthDate);
        return (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public static String[] sortStringDates(String[] dates) {
        Arrays.sort(dates, (d1, d2) -> parseDate(d1).compareTo(parseDate(d2)));
        return dates;
    }

    private static LocalDate parseDate(String date) {
        String[] formates = {"dd/MM/yyyy", "yyyy-MM-dd" };
        for (int i = 0; i < formates.length; i++) {
            try {
                DateTimeFormatter df = DateTimeFormatter.ofPattern(formates[i]);
                return LocalDate.parse(date, df);
            } catch (DateTimeParseException e) {
                System.out.println("Date parsing error");
            }
        }
        return null;
    }
}
