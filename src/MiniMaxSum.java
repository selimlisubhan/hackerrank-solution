import java.sql.SQLOutput;
import java.util.Scanner;

public class MiniMaxSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = new int[5];
        System.out.println("Z");
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }

/*        if sortArray() function use

        int[] arrSort = sortArray(arr);
        String sum = minMax(arrSort);
*/
        String sum = minMax(arr);

        System.out.println(sum);
    }

    private static String minMax(int[] arrSort) {
        /* if sortArray() function use

        int first = arrSort[0];
        int last = arrSort[arrSort.length - 1];
        */

        int sum = 0;
        int first = arrSort[0];
        int last = arrSort[0];

        for (int i = 0; i < arrSort.length; i++) {
            if (arrSort[i] < first) {
                first = arrSort[i];
            }
            if (arrSort[i] > last) {
                last = arrSort[i];
            }
            sum += arrSort[i];
        }
        return (sum - last) + " " + (sum - first);
    }

    private static int[] sortArray(int[] arr) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }

}
