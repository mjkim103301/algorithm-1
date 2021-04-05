import java.util.PriorityQueue;
import java.util.Scanner;

// 틀린 풀이
public class BOJ1300_K번째수_2 {
    static int N, K;
    static long answer;
    static PriorityQueue<Long> minHeap;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        minHeap = new PriorityQueue<>();
        solution();
        System.out.println(answer);
        scan.close();

//      테스트 코드
//        for(int i=1;i<=64;i++){
//            N=8;
//            K=i;
//            minHeap = new PriorityQueue<>();
//            solution();
//            System.out.println(answer);
//
//        }
    }

    private static void solution() {
        //K가 1일땐 1, 2or 3일땐 2를 answer에 저장 -> return;
        if (K == 1) {
            answer = 1;
            return;
        } else if (K <= 3) {
            answer = 2;
            return;
        }

        // 1행, 1열의 수가 작으므로 먼저 넣기
        // (인덱스 1부터 시작)
        minHeap.offer((long) 1);
        for (int i = 2; i <= N; i++) { //2줄 넣기
            minHeap.offer((long) i);
            minHeap.offer((long) i);
        }

        // '/' 대각선 방향으로 1000000 줄 넣기
        int y = 2;
        int x = 2;
        int limit = 2; // N줄까지는 1행 1열을 미리 넣었으므로 limit=2
        for (int i = 0; i < 1000000; i++) {

            push(y, x, limit);
            y++;

            // y가 N을 넘어가면 x의 값이 1씩 증가함
            // x가 증가함에 따라 limit 값도 증가함 (limit=x)
            if (y > N) {
                y = N;
                x++;
                limit++;

            }
            if (x > N) {
                break;
            }
        }


        // K번째까지 minHeap의 값을 버리고 답 구하기
        int out = 0;
        long min = 0;
        while (!minHeap.isEmpty() && out < K) {
            out++;
            min = minHeap.poll();

            // minHeap을 N의 배수만큼 버렸으면 1줄씩 넣기
            if (out % N == 0 && x <= N) {

                push(y, x, limit);

                y++;
                if (y > N) {
                    y = N;
                    x++;
                    limit++;
                }
            }
        }
        answer = min;
        return;
    }

    static void push(int y, int x, int limit) {
        int yy = y;
        int xx = x;
        while (yy >= limit) {
            minHeap.offer((long) (yy * xx));
            yy--;
            xx++;
        }

    }
}
