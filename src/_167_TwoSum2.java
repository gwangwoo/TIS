public class _167_TwoSum2 {
  public static void main(String[] args) {

//    int[] nums = {2,7,11,15};
//    int target = 9;
    int[] nums = {2,3,4};
    int target = 6;
    int[] ans = twoSum(nums, target);
    System.out.println(ans[0] + " " + ans[1]);
  }

  public static int[] twoSum(int[] numbers, int target) {
    int answer[] = new int[2];
    for(int i = 0 ; i < numbers.length; i++) {
      int select = binarySearch(numbers, i, target);
      if(select == -1) continue;
      answer[0] = i+1;
      answer[1] = select+1;
      break;
    }
    return answer;
  }

  private static int binarySearch(int[] nums, int i, int target) {
    int left = i+1;
    int right = nums.length-1;
    int answer = -1;
    while(left <= right) {
      int mid = (left + right) >> 1;
      System.out.println(left + " " + right);
      if(nums[mid]+nums[i] == target) return mid;
      else if(nums[mid]+nums[i] < target) {
        left = mid+1;
      }else {
        right = mid-1;
      }
    }
    return answer;
  }
}
