import java.io.*;
import java.util.*;

public class _boj_25240 {
  static int U,F,Q;
  static Map<String, User> users = new HashMap<>();
  static Map<String, File> files = new HashMap<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    U = Integer.parseInt(st.nextToken());
    F = Integer.parseInt(st.nextToken());

    for(int i = 0 ; i < U ; i++) {
      st = new StringTokenizer(br.readLine());
      if(st.countTokens() <= 1) {
        String name = st.nextToken();
        users.put(name, new User(name, Arrays.asList(name)));
      }else {
        String name = st.nextToken();
        st = new StringTokenizer(st.nextToken(), ",");
        int groupCount = st.countTokens();
        User user = new User(name, new ArrayList<>());
        user.group.add(name);
        while(groupCount-- > 0) {
          String groupName = st.nextToken();
          user.group.add(groupName);
        }
        users.put(name, user);
      }
    }

//    users.forEach((s, user) -> System.out.println(s + " " + user));

    for(int i = 0 ; i < F ; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String permission = st.nextToken();
      String owner = st.nextToken();
      String ownedGroup = st.nextToken();
      files.put(name, new File(name, permission, owner, ownedGroup));
    }

    Q = Integer.parseInt(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = 0 ; i < Q ; i++) {
      st = new StringTokenizer(br.readLine());
      String userName = st.nextToken();
      String fileName = st.nextToken();
      char action = st.nextToken().charAt(0);
      bw.write(doAction(userName, fileName, action)+"\n");
    }
    bw.flush();
    bw.close();
  }

  private static int doAction(String userName, String fileName, char action) {
    File file = files.get(fileName);
    User user = users.get(userName);
    // OWNER, GROUP, OTHER check
    if(file.owner.equals(userName)) {
      return permissionCheck(file.permission.charAt(0), action);
    }else if(user.group.contains(file.ownedGroup)) {
      return permissionCheck(file.permission.charAt(1), action);
    }else {
      return permissionCheck(file.permission.charAt(2), action);
    }
  }

  private static int permissionCheck(char filePermission, char action) {
    if(filePermission == '0') return 0;
    String permission = char2Binary(filePermission-'0');
//    System.out.println("permission = " + permission + " " + "filePermission : " + filePermission);
    switch (action) {
      case 'X':
        if(permission.charAt(2) == '1') return 1;
        return 0;
      case 'W':
        if(permission.charAt(1) == '1') return 1;
        return 0;
      default:
        if(permission.charAt(0) == '1') return 1;
        return 0;
    }
  }

  private static String char2Binary(int filePermission) {
    String permission = Integer.toBinaryString(filePermission);
    while(permission.length() < 3) {
      permission = "0"+permission;
    }
    return permission;
  }

  static class File {
    private String name, permission, owner, ownedGroup;

    public File(String name, String permission, String owner, String ownedGroup) {
      this.name = name;
      this.permission = permission;
      this.owner = owner;
      this.ownedGroup = ownedGroup;
    }
  }

  static class User {
    private String name;
    private List<String> group;

    public User(String name, List<String> group) {
      this.name = name;
      this.group = group;
    }
  }
}
