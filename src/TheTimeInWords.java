import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheTimeInWords {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, String> hours;
    private static final Map<Integer, String> minutes;

    static {
        hours = new HashMap<>();
        hours.put(1, "one");
        hours.put(2, "two");
        hours.put(3, "three");
        hours.put(4, "four");
        hours.put(5, "five");
        hours.put(6, "six");
        hours.put(7, "seven");
        hours.put(8, "eighth");
        hours.put(9, "nine");
        hours.put(10, "ten");
        hours.put(11, "eleven");
        hours.put(12, "twelve");

        minutes = new HashMap<>();
        minutes.put(1, "one");
        minutes.put(2, "two");
        minutes.put(3, "three");
        minutes.put(4, "four");
        minutes.put(5, "five");
        minutes.put(6, "six");
        minutes.put(7, "seven");
        minutes.put(8, "eighth");
        minutes.put(9, "nine");
        minutes.put(10, "ten");
        minutes.put(11, "eleven");
        minutes.put(12, "twelve");
        minutes.put(13, "thirteen");
        minutes.put(14, "fourteen");
        minutes.put(15, "fifteen");
        minutes.put(16, "sixteen");
        minutes.put(17, "seventeen");
        minutes.put(18, "eighteen");
        minutes.put(19, "nineteen");
        minutes.put(20, "twenty");
        minutes.put(21, "twenty one");
        minutes.put(22, "twenty two");
        minutes.put(23, "twenty three");
        minutes.put(24, "twenty four");
        minutes.put(25, "twenty five");
        minutes.put(26, "twenty six");
        minutes.put(27, "twenty seven");
        minutes.put(28, "twenty eighth");
        minutes.put(29, "twenty nine");

    }

    public static void main(String[] args) {
        int h = scanner.nextInt();
        int m = scanner.nextInt();

        String time = solution(h, m);

        System.out.println(time);
    }

    private static String solution(int h, int m) {
        String hours = m > 30 ? hours((h + 1 > 13) ? 1 : h) : hours(h);
        String minutes = minutes(m);

        String timeInWord;
        if (m == 0)
            timeInWord = hours + " o' clock";
        else if (m == 1)
            timeInWord = minutes + " minute past " + hours;
        else if (m == 15)
            timeInWord = "quarter past " + hours;
        else if (m == 45)
            timeInWord = "quarter to " + hours;
        else if (m == 30)
            timeInWord = "half past " + hours;
        else if (m > 1 && m < 30)
            timeInWord = minutes + " minutes past " + hours;
        else
            timeInWord = minutes + " minutes to " + hours;
        return timeInWord;
    }

    private static String minutes(int m) {
        if (m < 30)
            return minutes.get(m);
        else
            return minutes.get(60 - m);
    }

    private static String hours(int h) {
        return hours.get(h);
    }
}
