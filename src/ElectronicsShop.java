import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectronicsShop {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int budget = scanner.nextInt();
        int keyboard = scanner.nextInt();
        int drive = scanner.nextInt();
        List<Integer> keyboards = new ArrayList<>();
        List<Integer> drivers = new ArrayList<>();

        for (int i = 0; i < keyboard; i++) {
            keyboards.add(scanner.nextInt());
        }

        for (int i = 0; i < drive; i++) {
            drivers.add(scanner.nextInt());
        }
        int result = getMoneySpent(budget, keyboards, drivers);
        System.out.println(result);
    }

    public static int getMoneySpent(int budget, List<Integer> keyboards, List<Integer> drivers) {
        int max = -1;
        for (int i = 0, j = 0; i < keyboards.size(); i++) {
            for (; j < drivers.size(); j++) {
                if (keyboards.get(i) + drivers.get(j) > budget) break;
                if (keyboards.get(i) + drivers.get(j) > max)
                    max = keyboards.get(i) + drivers.get(j);
            }
        }
        return max;
    }

}
