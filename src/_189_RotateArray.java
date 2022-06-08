import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class _189_RotateArray {
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;
    rotate(nums, k);
  }

  public static void rotate(int[] nums, int k) {
    Deque<Integer> q = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) q.add(nums[i]);
    k %= nums.length;
    while(k-- > 0) q.addFirst(q.pollLast());
    int size = q.size();
    for(int i = 0 ; i < size ; i++) nums[i] = q.poll();
  }
}
