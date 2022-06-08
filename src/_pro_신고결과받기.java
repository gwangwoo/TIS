import java.util.*;

public class _pro_신고결과받기 {

  public static void main(String[] args) {
//    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//    String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//    int k = 2;

    String[] id_list = {"con", "ryan"};
    String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
    int k = 3;

    System.out.println(solution(id_list,report,k));
  }

  public static int[] solution(String[] id_list, String[] report, int k) {
    int N = id_list.length;
    int[] answer = new int[N];
    List<Integer> reverse[] = new ArrayList[N];
    for(int i = 0 ; i < N ; i++) reverse[i] = new ArrayList<>();
    Map<String, Integer> hm = new HashMap<>();
    Map<String,Boolean> reportHistory = new HashMap<>();
    int num = 0;
    for (String s : id_list) {
      hm.put(s, num++);
    }
    int[] cnt = new int[N];

    for(String line : report) {
      if(reportHistory.containsKey(line)) continue;
      reportHistory.put(line, true);
      String[] idList = line.split(" ", 0);
      int firstId = hm.get(idList[0]);
      int lastId = hm.get(idList[1]);
      cnt[lastId]++;
      reverse[lastId].add(firstId);
    }

    for(int i = 0 ; i < N ; i++) {
      if(cnt[i] >= k) reverse[i].stream().forEach(firstId -> answer[firstId]+=1);
    }

    Arrays.stream(answer).forEach(System.out::println);

    return answer;
  }
}
