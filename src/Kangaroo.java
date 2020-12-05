import java.util.Scanner;

public class Kangaroo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);

    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {

        while (x1 <= x2) {
            if (x1 == x2) {
                return "YES";
            }
            x1 += v1;
            x2 += v2;
        }

        return "NO";
    }

}
