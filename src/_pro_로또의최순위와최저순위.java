import java.util.Arrays;
import java.util.HashMap;

public class _pro_로또의최순위와최저순위 {
  public static void main(String[] args) {
//    int[] lottos = {44, 1, 0, 0, 31, 25};
//    int[] wins_number = {31, 10, 45, 1, 6, 19};

    int[] lottos = {45, 4, 35, 20, 3, 9};
    int[] wins_number = {20, 9, 3, 45, 4, 35};
    int[] solution = solution(lottos, wins_number);
    System.out.println(solution[0] + " " + solution[1]);
  }

  public static int[] solution(int[] lottos, int[] win_nums) {
    final int N = 46;
    int statusCount = 0;
    int zeroCount = 0;
    int magicNumber = 7;
    boolean[] check = new boolean[N];
    for(int val : win_nums) check[val] = true;
    for(int val : lottos) {
      if(check[val]) statusCount++;
      if(val == 0) zeroCount++;
    }
    int min = magicNumber - statusCount;
    if(min == 7) min = 6;
    int max = magicNumber - statusCount - zeroCount;
    if(max == 7) max = 6;
    int[] answer = {max, min};
    return answer;
  }
}
