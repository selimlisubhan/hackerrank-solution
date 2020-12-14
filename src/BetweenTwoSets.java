import java.util.Scanner;

public class BetweenTwoSets {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = new int[m];
        for (int j = 0; j < m; j++) {
            b[j] = scanner.nextInt();
        }

        System.out.println(solution(a, b));
    }

    private static int solution(int[] a, int[] b) {
        int result = 0;
        for (int i = a[a.length - 1]; i <= b[0]; i++) {
            boolean check = true;
            for (int j = 0; j < a.length; j++) {
                if (i % a[j] != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                for (int j = 0; j < b.length; j++) {
                    if (b[j] % i != 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check)
                result++;

        }
        return result;
    }
}
