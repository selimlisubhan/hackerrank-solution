import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grading {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int gradesCount = scanner.nextInt();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            grades.add(scanner.nextInt());
        }

        List<Integer> result = gradingStudents(grades);
        System.out.println(result);
    }


    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();
        for (Integer grade : grades) {
            if (grade >= 38) {
                if (5 - (grade % 5) < 3) {
                    int x = (5 - grade % 5) + grade;
                    result.add(x);
                } else {
                    result.add(grade);
                }
            } else {
                result.add(grade);
            }
        }
        return result;
    }


}
