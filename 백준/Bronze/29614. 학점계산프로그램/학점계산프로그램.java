import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Character, Double> scoreMap = new HashMap<>();
        scoreMap.put('A', 4.0d);
        scoreMap.put('B', 3.0d);
        scoreMap.put('C', 2.0d);
        scoreMap.put('D', 1.0d);
        scoreMap.put('F', 0.0d);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        StringTokenizer st = new StringTokenizer(original, "+");
        int N = st.countTokens();
        int plusCount = original.charAt(original.length()-1) == '+' ? N : N-1;
        int scoreCount = 0;
        double sum = 0d;
        for(int i = 0 ; i < N ; i++) {
            String str = st.nextToken();
            for(int j = 0 ; j < str.length() ; j++) {
                char ch = str.charAt(j);
                sum += scoreMap.get(ch);
                scoreCount++;
            }
        }
        sum += plusCount * 0.5d;
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format(sum / scoreCount));
    }
}
