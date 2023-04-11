package tester;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class test1 {
    public static void main(String[] args ){
        LocalDate t=LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String s=t.format(dateFormatter);
        System.out.println(s);
    }
}
