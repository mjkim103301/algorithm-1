import java.util.*;

public class BOJ18222_투에모스문자열 {
    static long K;
    static long before;
    static long[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        K = scan.nextLong();
        arr = new long[61];
        for (int i = 0; i < 61; i++) { 
            arr[i] = (long) Math.pow(2, i);
        }
        System.out.println(solution(K));
    }

    static long solution(long x) {
        if (x == 1) {
            return 0;
        }
        for (int i = 0; i < 61; i++) {
            if (arr[i] < x) {
                before = arr[i];
            } else {
                break;
            }
        }
        return 1 - solution(x - before);
    }
}
