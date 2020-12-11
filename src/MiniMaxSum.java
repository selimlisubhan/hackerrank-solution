import java.util.Scanner;

public class MiniMaxSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        long[] arr = new long[5];
        System.out.println("Zəhmət olmazsa 5 rəqəm daxil edin");
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextLong();
        }

/*        if sortArray() function use

        int[] arrSort = sortArray(arr);
        String sum = minMax(arrSort);
*/
        String sum = minMax(arr);

        System.out.println(sum);
    }

    private static String minMax(long[] arrSort) {
        /* if sortArray() function use

        int first = arrSort[0];
        int last = arrSort[arrSort.length - 1];
        */

        long sum = 0;
        long first = arrSort[0];
        long last = arrSort[0];

        for (int i = 0; i < arrSort.length; i++) {
            sum += arrSort[i];
            // if if sortArray() function not use
            if (arrSort[i] < first) {
                first = arrSort[i];
            }
            if (arrSort[i] > last) {
                last = arrSort[i];
            }
        }
        return (sum - last) + " " + (sum - first);
    }

    private static long[] sortArray(long[] arr) {
        boolean sorted = false;
        long temp;
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
