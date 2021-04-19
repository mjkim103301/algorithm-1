import java.io.*;
import java.util.*;

public class BOJ1327_소트게임 {
    static class Node {
        StringBuilder s; // 문자열
        int cnt; // 변경 횟수
        int changedIndex; // reverse한 index

        Node(StringBuilder s, int cnt, int changedIndex) {
            this.s = s;
            this.cnt = cnt;
            this.changedIndex = changedIndex;
        }
    }
    static int N, K;
    static int min = -1;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sbReverse;
    static Queue<Node> queue = new ArrayDeque<>();
    static Set<String> set = new HashSet<>();
    static int[] arr;
    static String target="";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String temp = st.nextToken();
            sb.append(temp);
            arr[i] = Integer.parseInt(temp);
        }

        // 정렬한 순열을 target에 저장
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            target += arr[i];
        }
        solution();
        System.out.println(min);
    }

    static void solution() {
        //처음에는 뒤집은 index가 없으므로 changedIndex = -1 저장
        queue.offer(new Node(sb, 0, -1));

        //중복체크하기 위해 set에 문자열 저장
        set.add(sb.toString());

        if (sb.toString().equals(target)) { // target과 일치하는지 체크
            min = 0;
            return;
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i <= N - K; i++) {
                if (now.changedIndex == i) continue; //전에 뒤집었던 index면 continue
                sb = new StringBuilder();
                sbReverse = new StringBuilder((now.s).substring(i, i + K));
                sb.append(now.s.substring(0, i)).append(sbReverse.reverse()).append(now.s.substring(i + K));

                //변경한 문자열이 set에 이미 저장된 문자열이면 continue
                if (set.contains(sb.toString())) continue;

                if (sb.toString().equals(target)) { // target과 일치하는지 체크
                    min = now.cnt + 1;
                    return;

                }
                set.add(sb.toString());
                queue.offer(new Node(sb, now.cnt + 1, i));
            }
        }
    }
}
