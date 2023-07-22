import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _boj_1308 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> yearMap = new HashMap() {{
            put(1, 31);
            put(2, 28);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int lastYear = Integer.parseInt(st.nextToken());
        int lastMonth = Integer.parseInt(st.nextToken());
        int lastDay = Integer.parseInt(st.nextToken());
        if (checkGG(year, month, day, lastYear, lastMonth, lastDay)) {
            return;
        }
        int answer = 0;
        boolean flag = false;
        for (int i = year; i <= lastYear; i++) {
            for (int j = month; j <= 12; j++) {
                if (i == lastYear && j == lastMonth) {
                    answer += lastDay-day;
                    flag = true;
                    break;
                }
                if (j == 2 && isLeapYear(i)) {
                    answer += yearMap.get(j) + 1;
                } else {
                    answer += yearMap.get(j);
                }
            }
            month = 1;
            if (flag) {
                break;
            }
        }
        System.out.println("D-" + answer);
    }

    private static boolean checkGG(int year, int month, int day, int lastYear, int lastMonth, int lastDay) {
        if (year + 1000 < lastYear) {
            System.out.println("gg");
            return true;
        } else if (year + 1000 == lastYear) {
            if (month < lastMonth) {
                System.out.println("gg");
                return true;
            } else if (month == lastMonth) {
                if (day <= lastDay) {
                    System.out.println("gg");
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) ||  year % 400 == 0;
    }
}
