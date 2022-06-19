import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class _boj_25286 {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      int year = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      LocalDate date = LocalDate.of(year, m, m);
      date = date.minusDays(m);
      System.out.println(date.getYear() + " " + date.getMonthValue() + " " + date.getDayOfMonth());
    }
  }
}
