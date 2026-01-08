import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N = 5;
    static int[][] map;
    static Map<Integer, Point> cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];
        cache = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cache.put(map[i][j], new Point(i, j));
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                Point point = cache.get(number);
                map[point.r][point.c] = 0;
                answer++;
                if (scanMap()) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    private static boolean scanMap() {
        int bingoCount = 0;
        for (int i = 0; i < N; i++) {
            int sum = Arrays.stream(map[i])
                            .sum();
            if (sum == 0) {
                bingoCount++;
            }
        }
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += map[j][i];
            }
            if (sum == 0) {
                bingoCount++;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += map[i][i];
        }
        bingoCount += sum == 0 ? 1 : 0;
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += map[i][N - i - 1];
        }
        bingoCount += sum == 0 ? 1 : 0;
        return bingoCount >= 3;
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
