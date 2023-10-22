import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _boj_20529 {
    static int N, T;
    static List<String> mbti = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            mbti.clear();
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti.add(st.nextToken());
            }
            if(N > 32) {
                bw.write("0\n");
                continue;
            }
            int answer = 1987654321;
            for(int i = 0; i < N-2 ; i++) {
                String strA = mbti.get(i);
                for(int j = i+1 ; j < N-1 ; j++) {
                    String strB = mbti.get(j);
                    int firstSum = calc(strA, strB);
                    for(int k = j+1 ; k < N ; k++) {
                        String strC = mbti.get(k);
                        int sum = firstSum;
                        sum += calc(strB, strC);
                        sum += calc(strC, strA);
                        answer = Math.min(sum, answer);
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static int calc(String strA, String strB) {
        int result = 0;
        for(int i = 0 ; i < 4 ; i++) {
            if(strA.charAt(i) != strB.charAt(i)) result++;
        }
        return result;
    }
}
