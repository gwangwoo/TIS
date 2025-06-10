import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        int N = 20;
        double totalScore = 0.0;
        double totalSubjectScore = 0.0;
        while(N-- > 0)  {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            double subjectScore = map.getOrDefault(st.nextToken(), -1.0);
            if (subjectScore == -1.0) {
                continue;
            }
            totalScore += score;        // 총 학점
            totalSubjectScore += score * subjectScore;      // 학점 * 성적의 합
        }
        System.out.println(totalSubjectScore / totalScore);
    }
}
