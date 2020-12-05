import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareTheTriplets {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        System.out.println("First 3 number: ");
        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();
            first.add(n);
        }

        System.out.println("Second 3 number: ");
        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();
            second.add(n);
        }

        List<Integer> result = compareTriplets(first, second);

        System.out.println(result);
    }

    private static List<Integer> compareTriplets(List<Integer> first, List<Integer> second) {
        int f = 0;
        int s = 0;
        for (int i = 0; i < first.size(); i++) {
            if (first.get(i) > second.get(i)) {
                f++;
            } else if(first.get(i) < second.get(i)) {
                s++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(f);
        result.add(s);

        return result;
    }

}
