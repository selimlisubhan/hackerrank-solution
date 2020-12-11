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
        String hour = listTime[0];
        String minutes = listTime[1] + listTime[2].substring(0, 2);
        String period = listTime[2].substring(2, 4);
        if (period.equals("AM")) {
            if (hour.equals("12"))
                hour = "00";

        } else {
            if (!hour.equals("12")) {
                int h = Integer.parseInt(hour);
                h = h + 12;
                hour = "" + h;
            }
        }
        return hour + ":" + minutes;
    }

}
