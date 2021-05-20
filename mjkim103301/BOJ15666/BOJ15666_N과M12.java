import java.util.*;
import java.io.*;

public class BOJ15666_N과M12 {
    static Set<String> set = new HashSet<>();
    static int N, M;
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        combination(0, 0);
    }

    static void combination(int level, int start) {
        if (level == M) {
            if (set.contains(Arrays.toString(temp))) return;
            set.add(Arrays.toString(temp));
            for (int i = 0; i < M; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            temp[level] = arr[i];
            combination(level + 1, i);
        }
    }

}
