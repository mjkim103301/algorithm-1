import java.util.*;

public class BOJ2251_물통 {
    static int A, B, C;
    static boolean[] water;
    static Queue<int[]> queue = new ArrayDeque<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        water = new boolean[201];
        queue.offer(new int[]{0, 0, C});
        solution();
        for (int i = 0; i <= 200; i++) {
            if (water[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static void solution() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            //중복체크
            if (set.contains(Arrays.toString(now))) continue;
            set.add(Arrays.toString(now));

            // A물통이 비었을 때 
            if (now[0] == 0) {
                water[now[2]] = true;
            }

            //A->B
            if (B - now[1] >= now[0]) {
                queue.add(new int[]{0, now[1] + now[0], now[2]});
            } else {
                queue.add(new int[]{now[0] - (B - now[1]), B, now[2]});
            }

            //A->C
            if (C - now[2] >= now[0]) {
                queue.add(new int[]{0, now[1], now[2] + now[0]});
            } else {
                queue.add(new int[]{now[0] - (C - now[2]), now[1], C});
            }

            //B->A
            if (A - now[0] >= now[1]) {
                queue.add(new int[]{now[0] + now[1], 0, now[2]});
            } else {
                queue.add(new int[]{A, now[1] - (A - now[0]), now[2]});
            }

            //B->C
            if (C - now[2] >= now[1]) {
                queue.add(new int[]{now[0], 0, now[2] + now[1]});
            } else {
                queue.add(new int[]{now[0], now[1] - (C - now[2]), C});
            }

            //C->A
            if (A - now[0] >= now[2]) {
                queue.add(new int[]{now[0] + now[2], now[1], 0});
            } else {
                queue.add(new int[]{A, now[1], now[2] - (A - now[0])});
            }

            //C->B
            if (B - now[1] >= now[2]) {
                queue.add(new int[]{now[0], now[1] + now[2], 0});
            } else {
                queue.add(new int[]{now[0], B, now[2] - (B - now[1])});
            }
        }

    }
}
