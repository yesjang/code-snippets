import java.util.HashMap;
import java.util.Map;

public class FloodFill {

    //https://programmers.co.kr/learn/courses/30/lessons/1829?language=java

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = solution(6, 4, picture);
        System.out.println("numberOfArea=" + answer[0]);
        System.out.println("maxSizeOfOneArea=" + answer[1]);
    }

    public static int go(int m, int n, int i, int j, int[][] picture, int value) {
        if (picture[j][i] == 0 || picture[j][i] != value)
            return 0;

        int cnt = 1;
        picture[j][i] = 0;

        if (j < m - 1)
            cnt += go(m, n, i, j + 1, picture, value);
        if (i < n - 1)
            cnt += go(m, n, i + 1, j, picture, value);
        if (j > 0)
            cnt += go(m, n, i, j - 1, picture, value);
        if (i > 0)
            cnt += go(m, n, i - 1, j, picture, value);
        return cnt;
    }

    public static void printMap(int m, int n, int[][] picture) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(Integer.valueOf(picture[j][i]));
            }
            System.out.println("");
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

//        printMap(m, n, picture);
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[j][i] != 0) {
                    int value = picture[j][i];
                    int cnt = 1;
                    picture[j][i] = 0;

                    if (j < m - 1)
                        cnt += go(m, n, i, j + 1, picture, value);
                    if (i < n - 1)
                        cnt += go(m, n, i + 1, j, picture, value);
                    if (j > 0)
                        cnt += go(m, n, i, j - 1, picture, value);
                    if (i > 0)
                        cnt += go(m, n, i - 1, j, picture, value);

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    numberOfArea++;
//                    printMap(m, n, picture);
                }

            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

}
