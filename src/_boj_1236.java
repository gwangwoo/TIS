
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_1236 {
    static int N,M;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int col = calcCol();
        int row = calcRow();
        System.out.println(Math.max(col, row));
    }

    private static int calcCol() {
        int answer = 0;
        for(int i = 0 ; i < N ; i++) {
            boolean flag = false;
            for(int j = 0 ; j < M ; j++) {
                char ch = map[i][j];
                if(ch == 'X') flag = true;
            }
            if(!flag) answer++;
        }
        return answer;
    }
    private static int calcRow() {
        int answer = 0;
        for(int i = 0 ; i < M ; i++) {
            boolean flag = false;
            for(int j = 0 ; j < N ; j++) {
                char ch = map[j][i];
                if(ch == 'X') flag = true;
            }
            if(!flag) answer++;
        }
        return answer;
    }
}
