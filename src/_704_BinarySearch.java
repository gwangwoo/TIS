public class _704_BinarySearch {
  public static void main(String[] args) {
    int[] nums = {-1,0,3,5,9,12};
    int target = 9;
    int search = search(nums, target);
    System.out.println(search);
  }

  public static int search(int[] nums, int target) {
    return binarySearch(nums, target);
  }

  public static int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length-1;
    int answer = -1;
    while(left <= right) {
      int mid = (left + right) >> 1;
      if(nums[mid] < target) {
        left = mid+1;
      }else if(nums[mid] == target){
        answer = mid;
        break;
      }else  {
        right = mid-1;
      }
    }
    return answer;
  }
}
