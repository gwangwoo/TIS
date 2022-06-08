public class _pro_신규아이디추천 {
  public static void main(String[] args) {
    String new_id = "abcdefghijklmn.p";
//    String new_id = "z-+.^.";
    System.out.println(solution(new_id));

  }
  public static String solution(String new_id) {
    new_id = new_id.toLowerCase();
    String tmp = "";
    for(int i = 0 ; i < new_id.length() ; i++) {
      if(String.valueOf(new_id.charAt(i)).matches("[a-z0-9._-]")) {
        tmp += new_id.charAt(i);
      }
    }
    new_id = tmp;
    new_id = transPointString(new_id);
    System.out.println(new_id);
    if(new_id.length() == 0) new_id = "a";
    if(new_id.length() >= 16) {
      new_id = new_id.substring(0, 15);
      new_id = transPointString(new_id);

    }
    if(new_id.length() <= 2) while(new_id.length() <= 2) new_id += new_id.charAt(new_id.length()-1);
    return new_id;
  }

  private static String transPointString(String new_id) {
    for(int i = 0; i < new_id.length() ; i++) {
      if(new_id.charAt(i) == '.') {
        int endIdx = findPoint(new_id,i);
        if(endIdx == i) continue;
        new_id = new_id.substring(0, i) + "." + new_id.substring(endIdx+1, new_id.length());
      }
    }
    if(new_id.length() > 0 && new_id.charAt(0) == '.') new_id = new_id.substring(1);
    if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
    return new_id;
  }

  public static int findPoint(String str, int index) {
    while(index < str.length() && str.charAt(index) == '.') {
      index += 1;
      continue;
    }
    return index-1;
  }
}
