import java.util.*;

public class CrosswordPuzzle {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int size = 10;
    private static final char cover = '-';
    private static String[] words;

    public static void main(String[] args) {

        char[][] puzzle = new char[size][size];
        for (int v = 0; v < size; v++) {
            String line = scanner.next();
            for (int h = 0; h < size; h++) {
                puzzle[v][h] = line.charAt(h);
            }
        }

        words = scanner.next().split(";");

        solve(puzzle);


    }

    private static void solve(char[][] puzzle) {
        Map<Integer, List<Integer>> horizontalWordsPoint = new HashMap<>();
        Map<Integer, List<Integer>> verticalWordsPoint = new HashMap<>();
        Map<Integer, Integer> verticalHorizontalWordsPoint = new HashMap<>();

        int sizeMinWord = getSizeMinWords();

        for (int i = 0; i < size; i++) {
            int x = 0;
            int y = 0;
            List<Integer> h = new ArrayList<>();
            List<Integer> v = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (puzzle[i][j] == cover) {
                    h.add(j);
                    x++;
                }
                if (puzzle[j][i] == cover) {
                    v.add(j);
                    y++;
                }
            }
            if (x >= sizeMinWord) {
                horizontalWordsPoint.put(i, h);
            } else if (y >= sizeMinWord) {
                verticalWordsPoint.put(i, v);
            }
        }

        for (Integer kh : horizontalWordsPoint.keySet()) {
            for (Integer vh : horizontalWordsPoint.get(kh)) {
                for (Integer kv : verticalWordsPoint.keySet()) {
                    for (Integer vv : verticalWordsPoint.get(kv)) {
                        if (kh.equals(vv) && vh.equals(kv)) {
                            verticalHorizontalWordsPoint.put(kh, vh);
                        }
                    }
                }
            }
        }

        compateAndSort(horizontalWordsPoint, verticalWordsPoint, verticalHorizontalWordsPoint);
    }

    private static void compateAndSort(
            Map<Integer, List<Integer>> horizontalWordsPoint,
            Map<Integer, List<Integer>> verticalWordsPoint,
            Map<Integer, Integer> verticalHorizontalWordsPoint
    ) {
        List<String> horizontalWords = new ArrayList<>();
        List<String> verticalWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (List<Integer> list : horizontalWordsPoint.values()) {
                if (words[i].length() == list.size()) {
                    horizontalWords.add(words[i]);
                }
            }
            for (List<Integer> list : verticalWordsPoint.values()) {
                if (words[i].length() == list.size()) {
                    verticalWords.add(words[i]);
                }
            }
        }

        List<String> newHorizontalWords = horizontalWords;
        List<String> newVerticalWords = verticalWords;
        int i = 0;
        for (Integer key : verticalHorizontalWordsPoint.keySet()) {
            while (i < newHorizontalWords.size()) {
                if (newHorizontalWords.get(i).length() > verticalHorizontalWordsPoint.get(key) - 1) {
                    char x = newHorizontalWords.get(i).charAt(verticalHorizontalWordsPoint.get(key) - 1);
                    int j = 0;
                    while (j < newVerticalWords.size()) {
                        if (newVerticalWords.get(j).charAt(key - 1) == x) {
                            horizontalWords.remove(verticalWords.get(j));
                            verticalWords.remove(horizontalWords.get(i));
                        }
                        j++;
                    }
                }
                i++;
            }
        }


    }

    private static int getSizeMinWords() {
        int minSize = words[0].length();
        for (int i = 0; i < words.length; i++) {
            if (minSize > words[i].length()) {
                minSize = words[i].length();
            }
        }
        return minSize;
    }



}
