import java.math.BigDecimal;
import java.util.Scanner;

public class TranslateAmount {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] one = new String[]{"", " bir", " iki", " üç", " dörd", " beş", " altı", " yeddi", " səkkiz", " doqquz"};
    private static final String[] ten = new String[]{"", " on", " iyirmi", " otuz", " qırx", " əlli", " altmış", " yetmiş", " səksən", " doxsan"};

    public static String numberToword(int n, String ch) {
        StringBuilder result = new StringBuilder();
        if (n > 100) {
            result.append(one[n / 100]).append(" yuz").append(ten[n / 10 % 10]).append(" ").append(one[n % 10]);
        } else if (n > 10) {
            result.append(ten[n / 10]).append(" ").append(one[n % 10]);
        } else {
            result.append(one[n]);
        }
        if (n > 0) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.print("Sıfırdan böyük rəqəm əlavə edin: ");

        BigDecimal amount = scanner.nextBigDecimal();
        int manat = Integer.parseInt(amount.toString().split("\\.")[0]);
        int coins = Integer.parseInt(amount.toString().split("\\.")[0]);

        StringBuilder amounts = new StringBuilder();

        if (manat <= 0) {
            System.out.print("Sıfırdan böyük rəqəm əlavə edin !");
        } else {
            System.out.print("After conversion number in words is :");
            amounts.append(numberToword((manat / 1000), " min"));
            amounts.append(numberToword(((manat / 100) % 10), " yuz"));
            amounts.append(numberToword((manat % 100), " manat"));
        }

        amounts.append(numberToword((coins % 100), " qəpik"));
        System.out.println(amounts);
    }


}
