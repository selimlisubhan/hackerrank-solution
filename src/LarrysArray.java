import java.util.Scanner;

public class LarrysArray {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int a = scanner.nextInt();

            int[] array = new int[a];
            for (int i = 0; i < a; i++) {
                array[i] = scanner.nextInt();
            }
            stringBuilder.append(larrysArray(array)).append("\n");
            n--;
        }
        System.out.println(stringBuilder);

    }

    private static String larrysArray(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            int minIndex = getMinIndex(array, i);
            while (minIndex != i) {
                rotate(array, (minIndex < array.length - 1) ? minIndex - 1 : minIndex - 2);
                minIndex -= 1;
            }
        }
        return (array[array.length - 2] < array[array.length - 1]) ? "YES" : "NO";
    }

    private static void rotate(int[] array, int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = array[index + 2];
        array[index + 2] = temp;
    }

    private static int getMinIndex(int[] array, int start) {
        int minIndex = start;
        for (int i = start; i < array.length; i++) {
            minIndex = (array[minIndex] > array[i]) ? i : minIndex;
        }
        return minIndex;
    }

}
