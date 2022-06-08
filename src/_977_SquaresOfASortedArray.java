import java.util.Arrays;
import java.util.stream.IntStream;

public class _977_SquaresOfASortedArray {
  public static void main(String[] args) {
    int[] nums = {-4,-1,0,3,10};
    sortedSquares(nums);
  }

  public static int[] sortedSquares(int[] nums) {
    for(int i = 0 ; i < nums.length; i++) {
      nums[i] *= nums[i];
    }
    return Arrays.stream(nums).sorted().toArray();
  }
}
