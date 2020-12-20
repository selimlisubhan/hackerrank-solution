import java.util.Arrays;
import java.util.Scanner;

public class ClimbingTheLeaderboard {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] ranked = new int[n];
        for (int i = 0; i < n; i++) {
            ranked[i] = scanner.nextInt();
        }

        int[] player = new int[m];
        for (int j = 0; j < m; j++) {
            player[j] = scanner.nextInt();
        }

        int[] rankedSort = returnSortArrayRanked(ranked);
        int[] finalScores = climbingLeaderboard(rankedSort, player);
        for (int i = 0; i < finalScores.length; i++) {
            System.out.println(finalScores[i]);
        }

    }

    private static int[] returnSortArrayRanked(int[] ranked) {
        int x = 0;
        for (int i = 0; i < ranked.length; i++) {
            if (ranked[x] != ranked[i]) {
                ranked[++x] = ranked[i];
            }
        }

        int[] sortedArray = new int[x + 1];
        for (int i = 0; i <= x; i++) {
            sortedArray[i] = ranked[i];
        }
        return sortedArray;
    }

    private static int[] climbingLeaderboard(int[] ranked, int[] player) {

        for (int i = 0; i < player.length; i++) {

            if (player[i] < ranked[player.length - 1]) {
                player[i] = ranked.length + 1;
                continue;
            }
            if (player[i] >= ranked[0]) {
                player[i] = 1;
                continue;
            }
            for (int j = ranked.length - 1; j >= 1; j--) {
                if (player[i] >= ranked[j] && player[i] < ranked[j - 1]) {
                    player[i] = j + 1;
                    break;
                }
            }

        }

        return player;
    }

}
