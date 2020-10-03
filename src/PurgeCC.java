import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class PurgeCC {
    public void printTimeDelta() {
        ZoneId zoneId = ZoneId.of("UTC");
        long now = 1583265042l;
        long last = 0l;
        int minute = -6;
        for(int year = 2015; year <= 2017; year++) {
            for (int month = 1; month <=12; month++) {
                LocalDate initial = LocalDate.of(year, month, 1);
                long epochStart = initial.atStartOfDay(zoneId).toEpochSecond();
                long current = now - epochStart;
//                System.out.println("start of month " + year + "," + month + ": " + (now - epochStart));
//                System.out.println("for month of "+ initial.minusMonths(1).getYear() + "," +initial.minusMonths(1).getMonthValue()  + ": " + "php content/index.php cron/purgeCCDataWithDateLimit/" + current + "/" + last + "/10000");
                System.out.println("  # To purge credit card data for the month of "+ initial.minusMonths(1).getYear() + "/" +initial.minusMonths(1).getMonthValue()  + ", run this job every hour\n" +
                        "  - kohana_56: cron/purgeCCDataWithDateLimit/" + current + "/" + last + "/10000\n" +
                        "    minute: " + minute + "\n" );
                minute += 2;
                last = current;
            }
        }
    }
}
