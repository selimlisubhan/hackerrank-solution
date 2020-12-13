import java.util.Scanner;

public class HackerrankInAString {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scanner.next();
        System.out.println(solution(str) ? "YES" : "NO");
    }

    private static boolean solution(String str) {
        String hackerrank = "hackerrank";
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == hackerrank.charAt(size)) {
                size++;
            }
            if (size == hackerrank.length()) {
                return true;
            }
        }
        return false;
    }

}
