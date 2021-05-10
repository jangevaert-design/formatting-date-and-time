package edu.cnm.deepdive;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class FormattingDateAndTime {

  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2010, Month.APRIL, 15);
    LocalTime time = LocalTime.of(11, 22, 33);
    LocalDateTime dateTime = LocalDateTime.of(date, time);

    System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
    System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));

    DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    System.out.println();
    System.out.println(shortFormatter.format(dateTime));//ignores the time. However .format(time) will not work.
    System.out.println(mediumFormatter.format(date));

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy, hh:mm");
    System.out.println();
    System.out.println(formatter.format(dateTime));
    System.out.println(dateTime.format(formatter));

    //before Java 8
    SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss:ms");
    System.out.println();
    System.out.println(sf.format(new Date()));

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
    System.out.println();
    System.out.println(dtf.format(dateTime));
    //System.out.println(dtf.format(date));will not work because this is date only.
    System.out.println(dtf.format(time));
   }

}
