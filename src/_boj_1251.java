import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _boj_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        int len = str.length();
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                StringBuilder first = new StringBuilder(str.substring(0, i)).reverse();
                StringBuilder middle = new StringBuilder(str.substring(i, j)).reverse();
                StringBuilder last = new StringBuilder(str.substring(j, len)).reverse();
                String target = first.append(middle).append(last).toString();
                if(answer.length() == 0) {
                    answer = target;
                }else {
                    if(answer.compareTo(target) > 0) {
                        answer = target;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
