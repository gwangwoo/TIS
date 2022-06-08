import java.io.*;
import java.util.StringTokenizer;

public class _boj5549 {
  static int N, M, K;
  static int psum[][][];
  static int arr[][][];
  static char map[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());

    psum = new int[3][N + 1][M + 1];
    arr = new int[3][N][M];
    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j);
        if(map[i][j] == 'J') arr[0][i][j] = 1;
        else if(map[i][j] == 'O') arr[1][i][j] = 1;
        else arr[2][i][j] = 1;
      }
    }
    for (int k = 0; k < 3; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
          psum[k][i][j] = psum[k][i-1][j] + psum[k][i][j-1] - psum[k][i-1][j-1] + arr[k][i-1][j-1];
        }
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 0 ; i < K ; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int nr = Integer.parseInt(st.nextToken());
      int nc = Integer.parseInt(st.nextToken());
      for(int k = 0 ; k < 3 ; k++) {
        bw.write(psum[k][nr][nc] - psum[k][nr][c-1] - psum[k][r-1][nc] + psum[k][r-1][c-1] + " ");
      }
      bw.write("\n");
    }
    bw.flush();
    bw.close();
  }
}
