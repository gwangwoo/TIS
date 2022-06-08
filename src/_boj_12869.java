import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _boj_12869 {
  static int N;
  static int arr[];
  static boolean visited[][][] = new boolean[61][61][61];
  static int answer;
  static int[][] mutal = {
      {9, 1, 3},
      {9, 3, 1},
      {3, 9, 1},
      {3, 1, 9},
      {1, 3, 9},
      {1, 9, 3}
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    answer = (int) 1e9;
    dfs(arr, 0);
    System.out.println(answer);
  }

  private static void dfs(int[] arr, int cnt) {
    if (check(arr)) {
      answer = Math.min(answer, cnt);
      return;
    }
    if (cnt >= answer) return;

    int hp1;
    int hp2 = 0;
    int hp3 = 0;
    if (N == 3) {
      hp1 = arr[0];
      hp2 = arr[1];
      hp3 = arr[2];
    } else if (N == 2) {
      hp1 = arr[0];
      hp2 = arr[1];
    } else {
      hp1 = arr[0];
    }

    if (visited[hp1][hp2][hp3]) return;
//    System.out.println(hp1 + " " + hp2 + " " + hp3);
    visited[hp1][hp2][hp3] = true;

    int tmp[] = Arrays.copyOf(arr, N);

    for (int i = 0; i < 6; i++) {
      attack(tmp, i);
      dfs(tmp, cnt + 1);
      tmp = Arrays.copyOf(arr, N);
    }
  }

  private static void attack(int[] tmp, int index) {

    for (int j = 0; j < N; j++) {
      if (tmp[j] - mutal[index][j] >= 0) {
        tmp[j] -= mutal[index][j];
      } else {
        tmp[j] = 0;
      }
    }
  }

  private static boolean check(int[] arr) {
    for (int i = 0; i < N; i++) {
      if (arr[i] > 0) return false;
    }
    return true;
  }
}