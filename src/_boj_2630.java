import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_2630 {
    static int N;
    static int[][] map;
    static int w_cnt, b_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0, N-1, N-1);
        System.out.println(w_cnt);
        System.out.println(b_cnt);
    }

    private static void go(int sr, int sc, int tr, int tc) {
        if (check(sr, sc, tr, tc)) {
            if(map[sr][sc] == 0) {
                w_cnt++;
                return;
            }else {
                b_cnt++;
                return;
            }
        }
        int div_r = (sr+tr) / 2;
        int div_c = (sc+tc) / 2;

        go(sr,sc, div_r, div_c);
        go(sr, div_c+1, div_r, tc);
        go(div_r+1, sc, tr, div_c);
        go(div_r+1, div_c+1, tr,tc);
    }

    private static boolean check(int sr, int sc, int tr, int tc) {
        boolean flag = true;
        int color = map[sr][sc];
        for (int i = sr; i <= tr; i++) {
            for (int j = sc; j <= tc; j++) {
                if (map[i][j] != color) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }
}
