import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Stream;

public class _boj_25243 {
  static int C, H;
  static Station station[] = new Station[9];
  static PriorityQueue<Train> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {
    station[0] = new Station(1, "부발역");
    station[1] = new Station(7, "부발 ~ 가남");
    station[2] = new Station(1, "가남역");
    station[3] = new Station(7, "가남 ~ 감곡장호원");
    station[4] = new Station(1, "감곡장호원역");
    station[5] = new Station(8, "감곡장호원 ~ 앙성온천");
    station[6] = new Station(1, "양성온천역");
    station[7] = new Station(10, "앙성온천 ~ 충주");
    station[8] = new Station(1, "충주역");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    C = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    for (int i = 0; i < C; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      st = new StringTokenizer(st.nextToken(), ":");
      int hour = Integer.parseInt(st.nextToken());
      int minute = Integer.parseInt(st.nextToken());
      Train train = new Train();
      train.name = Integer.parseInt(name);
      train.startTime = LocalTime.of(hour, minute);
      train.isTop = false;
      pq.add(train);
    }

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      st = new StringTokenizer(st.nextToken(), ":");
      int hour = Integer.parseInt(st.nextToken());
      int minute = Integer.parseInt(st.nextToken());
      Train train = new Train();
      train.name = Integer.parseInt(name);
      train.startTime = LocalTime.of(hour, minute);
      train.isTop = true;
      pq.add(train);
    }
    List<Train> answer = new ArrayList<>();
    LocalTime time = pq.peek().startTime;

    while (true) {
      if (answer.size() == (H + C)) break;

      while (!pq.isEmpty() && pq.peek().startTime.equals(time)) {
        Train train = pq.poll();
        if (train.isTop) station[8].waitTrain.add(train);
        else station[0].waitTrain.add(train);
      }

      // 운행중인 애들 체크.
      for (int i = 1; i <= 8; i += 2) {
        if (station[i].useTrain.isEmpty()) continue;
        Train train = station[i].useTrain.poll();
        train.count++;
        if (train.count == station[i].takeTime) {
          train.count = -1;
          if (train.isTop) station[i - 1].waitTrain.add(train);
          else station[i + 1].waitTrain.add(train);
        } else station[i].useTrain.add(train);
      }

      // 시발역, 종점역에 도착한애들 빼주기.
      getGoal(time, answer, station[0], true);
      getGoal(time, answer, station[8], false);

      // 역에 대기중인 애들 체크.
      for (int i = 0; i <= 8; i += 2) {
        List<Train> trainList = new ArrayList<>();
        PriorityQueue<Train> waitTrain = station[i].waitTrain;
        int waitTrainSize = waitTrain.size();
        while (waitTrainSize-- > 0) {
          Train train = waitTrain.poll();
          train.count++;
          if (train.count == station[i].takeTime) {
            train.count = 0;
            if (train.isTop) station[i - 1].waitTrain.add(train);
            else station[i + 1].waitTrain.add(train);
          } else {
            trainList.add(train);
          }
        }
        station[i].waitTrain.clear();
        station[i].waitTrain.addAll(trainList);
      }
      // 대기중인 애들 운행으로 바꿔주기.
      for (int i = 1; i <= 8; i += 2) {
        if (!station[i].useTrain.isEmpty()) continue;
        if (station[i].waitTrain.isEmpty()) continue;
        Train train = station[i].waitTrain.poll();
        train.count = 0;
        station[i].useTrain.add(train);
      }
      time = time.plusMinutes(1);
    }

    Stream<Train> answerSorted = answer.stream().sorted(Comparator.comparing(Train::getName).thenComparing(Train::getEndTime));
    answerSorted.forEach(train -> System.out.println(train.endTime));
  }

  private static void getGoal(LocalTime now, List<Train> answer, Station station, boolean isTop) {
    PriorityQueue<Train> tmpQueue = new PriorityQueue<>();
    PriorityQueue<Train> waitTrain = station.waitTrain;
    int waitTrainSize = waitTrain.size();;
    while(waitTrainSize-- > 0) {
      Train train = waitTrain.poll();
      if (train.isTop == isTop) {
        train.endTime = now;
        answer.add(train);
        return;
      }
      tmpQueue.add(train);
    }
    station.waitTrain.clear();
    station.waitTrain.addAll(tmpQueue);
  }


  static class Train implements Comparable<Train> {
    public int name;
    public LocalTime startTime, endTime;
    public boolean isTop, isStop;
    public int count;

    public Train() {
    }

    public Train(int name, LocalTime startTime, LocalTime endTime, boolean isTop, boolean isStop, int count) {
      this.name = name;
      this.startTime = startTime;
      this.endTime = endTime;
      this.isTop = isTop;
      this.isStop = isStop;
      this.count = count;
    }

    public int getName() {
      return name;
    }

    public LocalTime getEndTime() {
      return endTime;
    }

    @Override
    public int compareTo(Train target) {
      if (this.startTime.compareTo(target.startTime) == 0) {
        return this.name - target.name;
      } else return this.startTime.compareTo(target.startTime);
    }
  }

  static class Station {
    public int takeTime, wantUse;
    public String name;
    public PriorityQueue<Train> waitTrain;
    public Queue<Train> useTrain;

    public Station(int takeTime, String range) {
      this.takeTime = takeTime;
      this.name = range;
      this.waitTrain = new PriorityQueue<>();
      this.useTrain = new LinkedList<>();
      this.wantUse = 0;
    }
  }
}
