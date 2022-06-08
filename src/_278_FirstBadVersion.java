public class _278_FirstBadVersion {
  public static void main(String[] args) {
    int n = 5;
    System.out.println(firstBadVersion(n));
  }

  public static int firstBadVersion(int n) {
    long left = 1;
    long right = n;
    long answer = -1;
    while(left <= right) {
      long mid = (left + right) >> 1;
      if(!isBadVersion((int)mid)) {
        left = mid+1;
      }else {
        right = mid-1;
        answer = mid;
      }
    }
    return (int)answer;
  }

  public static boolean isBadVersion(int version) {
    return false;
  }
}
