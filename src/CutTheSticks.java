import java.util.Scanner;

public class CutTheSticks {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int a = scanner.nextInt();

        int[] array = new int[a];
        for (int i = 0; i < a; i++) {
            array[i] = scanner.nextInt();
        }

        int[] sorted = sortedArray(array);
        int start = 0;
        while (a != 0) {
            System.out.println(a);
            int count = solution(sorted, start);
            start += count;
            a -= count;
        }
    }

    private static int[] sortedArray(int[] arr) {
        boolean sorted = true;
        int temp;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = true;
                }
            }
        }
        return arr;
    }

    private static int solution(int[] array, int start) {
        int value = array[start];
        for (int i = 1; start + i < array.length; ++i) {
            if (value != array[start + i]) {
                return i;
            }
        }
        return array.length - start;
    }


}
