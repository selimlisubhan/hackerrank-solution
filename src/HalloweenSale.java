import java.util.Scanner;

public class HalloweenSale {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int priceOfTheFirstGame = scanner.nextInt();
        int discount = scanner.nextInt();
        int minimumCost = scanner.nextInt();
        int budget = scanner.nextInt();

        int buy = howManyGames(priceOfTheFirstGame, discount, minimumCost, budget);
        System.out.println(buy);

    }

    private static int howManyGames(int p, int d, int m, int b) {

        if ((b - p) < 0) return 0;

        int buy = 0;
        while (b >= p) {
            b -= p;
            buy++;
            if ((p - d) <= m) {
                p = m;
            } else {
                p -= d;
            }
        }

        return buy;
    }

}
