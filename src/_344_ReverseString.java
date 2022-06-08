public class _344_ReverseString {
  public static void main(String[] args) {
    char s[] = {'h','e','l','l','o'};
    reverseString(s);
  }

  public static void reverseString(char[] s) {
    char[] answer = new char[s.length];
    for(int i = 0 ; i < s.length ; i++) answer[s.length-i-1] = s[i];
    for(int i = 0 ; i < s.length ; i++) s[i] = answer[i];
  }
}
