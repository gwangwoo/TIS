import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _boj_27724 {
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int sCnt = getCnt(K);
        int totalCnt = getCnt(N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Math.min(totalCnt, sCnt+M)+"\n");
        bw.flush();
        bw.close();
    }

    static int getCnt(int value) {
        int cnt = 0;
        while(value >> 1 > 0) {
            value >>= 1;
            cnt++;
        }
        return cnt;
    }
}
