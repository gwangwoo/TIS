import java.io.*;
import java.util.StringTokenizer;

public class _boj_25285 {
  static int T;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int height = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      double bmi = weight / Math.pow(height / 100d , 2);
      int answer = 0;
      if(height <= 140) {
        answer = 6;
      }else if(height < 146) {
        answer = 5;
      }else if(height < 159) {
        answer = 4;
      }else if(height < 161) {
        if(16.0 <= bmi && bmi < 35.0) answer = 3;
        else answer = 4;
      }else if(height < 204) {
        if(20.0 <= bmi && bmi < 25.0) answer = 1;
        else if((18.5 <= bmi && bmi < 20.0) || (25.0 <= bmi && bmi < 30.0)) answer = 2;
        else if((16.0 <= bmi && bmi < 18.5) || (30.0 <= bmi && bmi < 35.0)) answer = 3;
        else answer = 4;
      }else {
        answer = 4;
      }
      bw.write(answer+"\n");
    }
    bw.flush();
    bw.close();
  }
}
