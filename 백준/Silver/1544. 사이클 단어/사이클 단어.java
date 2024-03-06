import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] parents;
    static String[] strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N];
        strs = new String[N];
        int answer = 1;
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }
        for (int i = 1; i < N; i++) {
            String str = strs[i];
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                String target = strs[j];
                if (str.length() != target.length()) {
                    continue;
                }
                int flagCount = 0;
                for (int k = 0; k < str.length(); k++) {
                    if (str.charAt(k) != target.charAt(0)) {
                        flagCount++;
                        continue;
                    }
                    if (flagCount == str.length()) {
                        break;
                    }
                    int n = target.length();
                    for (int l = 0; l < n; l++) {
                        if (str.charAt((k + l) % n) != target.charAt(l)) {
                            break;
                        }
                        if (l == n - 1) {
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
