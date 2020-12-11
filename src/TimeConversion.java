import java.util.Scanner;

public class TimeConversion {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String time = scanner.next();
        String thisTime = timeConversion(time);
        System.out.println(thisTime);
    }

    private static String timeConversion(String time) {
        String[] listTime = time.split(":");
        String hours = listTime[0];
        int hour = Integer.parseInt(hours);
        String minutes = listTime[1] + ":" + listTime[2].substring(0, 2);
        String period = listTime[2].substring(2, 4);

        if (period.equals("AM") && hour == 12) {
            hours = "00";
        } else if (period.equals("PM") && hour < 12) {
            hour = hour + 12;
            hours = "" + hour;
        }

        return hours + ":" + minutes;
    }

}
