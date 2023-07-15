import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int N = str.length();
        int answer = 0;
        for(int i = N-1 ; i >= 0 ; i--) {
            char ch = str.charAt(i);
            int val = 0;
            if('0' <= ch && ch <= '9') val = ch -'0';
            else val = ch - 'A' + 10;
            answer += Math.pow(b,N-i-1) * val;
        }
        System.out.println(answer);
    }
}
