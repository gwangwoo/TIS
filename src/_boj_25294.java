import java.io.*;
import java.util.StringTokenizer;

public class _boj_25294 {
  static int Q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Q = Integer.parseInt(br.readLine());
    StringTokenizer st;
    while (Q-- > 0) {
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      if (command == 1) {
        int n = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        int result = calc(n, y, x);
        bw.write(result + 1 + "\n");
      } else {
        int n = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken()) - 1;
        Pair pair = find(n, val);
        bw.write((pair.x + 1) + " " + (pair.y + 1) + "\n");
      }
    }
    bw.flush();
    bw.close();
  }

  private static Pair find(int n, int val) {
    for (int i = 0; i < n - 1; i++) {
      int left = calc(n, i, i);
      int right = calc(n, i + 1, i + 1);
      if (!(left <= val && val <= right)) continue;
      int y = i;
      int x = i;
      int depth = Math.min(i, n - 1 - i);
      int cnt = n - 2 * depth - 1;
      int temp = cnt;
      while(temp-- > 0) {
        x++;
        if(check(n, val, y, x)) return new Pair(y, x);
      }
      temp = cnt;
      while(temp-- > 0) {
        y++;
        if(check(n, val, y, x)) return new Pair(y, x);
      }
      temp = cnt;
      while (temp-- > 0) {
        x--;
        if(check(n, val, y, x)) return new Pair(y, x);
      }
      temp = cnt;
      while (temp-- > 0) {
        y--;
        if(check(n, val, y, x)) return new Pair(y, x);
      }
      return new Pair(i+1, i+1);
    }
    return null;
  }

  private static boolean check(int n, int val, int y, int x) {
    return calc(n, y, x) == val;
  }

  static class Pair {
    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int calc(int n, int x, int y) {
    int result = 0;
    int depth = Math.min(x, Math.min(y, Math.min(n - 1 - x, n - 1 - y)));
    if (y >= x) {
      result = x + y - 2 * depth;
    } else {
      result = 4 * (n - 1 - 2 * depth) - (x + y - 2 * depth);
    }
    result += 4 * ((depth * n) - Math.pow(depth, 2));
    return result;
  }
}
