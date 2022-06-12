import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class _boj_25239 {
  static int L;
  static final int MAX = 6;
  static int arr[] = new int[MAX+1];
  static boolean closed[] = new boolean[MAX+1];
  public static void main(String[] args) throws IOException {
    LocalTime range[] = {
        LocalTime.of(0, 0),
        LocalTime.of(2,0),
        LocalTime.of(4,0),
        LocalTime.of(6,0),
        LocalTime.of(8,0),
        LocalTime.of(10,0),
        LocalTime.of(12,0)
    };
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), ":");
    LocalTime time = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    st = new StringTokenizer(br.readLine());
    for(int i = 1 ; i <= MAX ; i++) arr[i] = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(br.readLine());
    while(L-- > 0) {
      st = new StringTokenizer(br.readLine());
      double eventTime = Double.parseDouble(st.nextToken());
      if(check()) {
        System.out.println(0);
        return;
      }
      if(eventTime >= 60.0) break;
      String action = st.nextToken();

      if(action.equals("^")) {
        int direction = find(time, range);
        if(noCheck(time, range)) continue;
        closed[direction] = true;
      }else if(action.contains("MIN")) {
        int minute = Integer.parseInt(action.substring(0,2));
        time = time.plusMinutes(minute);
        if(time.isAfter(range[MAX])) time = time.minusHours(12);
      }else {
        int hour = action.charAt(0)-'0';
        time = time.plusHours(hour);
        if(time.isAfter(range[MAX])) time = time.minusHours(12);
      }
    }
    int answer = 0;
    for(int i = 1 ; i <= MAX ; i++) {
      if(!closed[i]) answer += arr[i];
    }
    System.out.println(answer >= 100 ? 100 : answer);
  }

  private static boolean noCheck(LocalTime time, LocalTime[] range) {
    for(int i = 0 ; i <= MAX ; i++) {
      if(time.equals(range)) return true;
    }
    return false;
  }

  private static boolean check() {
    for(int i = 1 ; i <= MAX ; i++) if(!closed[i]) return false;
    return true;
  }

  private static int find(LocalTime time, LocalTime[] range) {
    int answer = -1;
    for(int i = MAX ; i >= 1 ; i--) {
      if(time.isBefore(range[i]) && time.isAfter(range[i-1])) return i;
    }
    return 0;
  }
}