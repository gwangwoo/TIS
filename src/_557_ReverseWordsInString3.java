import java.util.StringTokenizer;

public class _557_ReverseWordsInString3 {
  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    System.out.println(reverseWords(s));
  }

  public static String reverseWords(String s) {
    StringTokenizer st = new StringTokenizer(s);
    StringBuilder answer = new StringBuilder();
    int N = st.countTokens();
    while(N-- > 0) {
      StringBuilder sb = new StringBuilder(st.nextToken());
      answer.append(sb.reverse()+" ");
    }
    answer = answer.delete(answer.length()-1, answer.length());
    return answer.toString();
  }
}
