import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int whiteAnswer = findPaper(0,0,N,N,0);
        int blueAnswer = findPaper(0,0,N,N,1);
        System.out.println(whiteAnswer);
        System.out.println(blueAnswer);
    }

    private static int findPaper(int sr, int sc, int er, int ec, int color) {
        if (check(sr, sc, er, ec, color)) {
           return 1;
        }

        if (er - sr == 1 && ec - sc == 1) {
            return 0;
        }


        int midR = (sr + er) / 2;
        int midC = (sc + ec) / 2;
        int answer = 0;
        answer += findPaper(sr, sc, midR, midC, color);
        answer += findPaper(sr, midC, midR, ec, color);
        answer += findPaper(midR, sc, er, midC, color);
        answer += findPaper(midR, midC, er, ec, color);

        return answer;
    }

    private static boolean check(int sr, int sc, int er, int ec, int color) {
        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                if (map[i][j] != color) return false;
            }
        }
        return true;
    }


}
