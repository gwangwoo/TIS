import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _283_MoveZeroes {
  public static void main(String[] args) {
    int[] nums = {0,1,0,3,12};
    moveZeroes(nums);
  }

  public static void moveZeroes(int[] nums) {
    int arr[] = new int[nums.length];
    int i = 0, j = nums.length-1;
    for(int k = 0; k < nums.length; k++) {
      if(nums[k] != 0) arr[i++] = nums[k];
    }
    for(int k = 0; k < nums.length ; k++) nums[k] = arr[k];
  }
}
