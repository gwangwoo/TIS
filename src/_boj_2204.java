import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _boj_2204 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String count = "";
    while(!(count = (br.readLine())).equals("0")) {
      List<String> list = new ArrayList<>();
      int N = Integer.parseInt(count);
      String str;
      while(N-- > 0) {
        str = br.readLine();
        list.add(str);
      }
      list.sort(Comparator.comparing(String::toLowerCase));
      System.out.println(list.get(0));
    }
  }
}
