import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> arl = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        int count = kmp(text, pattern);
        System.out.println(count);
        arl.forEach(val -> System.out.print(val + " "));
    }

    public static int kmp(String text, String pattern) {
        int[] pi = getPi(pattern);
        int N = text.length();
        int M = pattern.length();
        int j = 0;
        int answer = 0;
        for (int i = 0 ; i  < N ; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == M - 1) {
                    answer++;
                    arl.add(i - M + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return answer;
    }


    public static int[] getPi(String pattern) {
        int N = pattern.length();
        int[] pi = new int[N];
        int j = 0;

        for (int i = 1 ; i < N ; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
