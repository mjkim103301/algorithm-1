import java.io.*;

public class BOJ17609_회문 {
    static int N; // 문장 개수
    static boolean change; // 문자 1개를 삭제했는지
    static boolean stop; // 재귀 종료할건지
    static int answer;
    static boolean checkLeft; // 왼쪽 문자 1개 삭제했는지
    static String input; //검사할 문장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            answer = 0;
            change = false;
            checkLeft = false;
            stop = false;

            // left=0, right=문장길이-1
            check(0, input.length() - 1);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void check(int left, int right) {
        if (left >= right) {
            if (checkLeft) answer = 1;
            stop = true; // 재귀 종료
            return;
        }
        if (input.charAt(left) == input.charAt(right)) { // 다음 문자 검사
            check(left + 1, right - 1);
        } else if (change) { // 이전에 문자 1개 없앴는데도 문자가 다를 때
            answer = 2;
            return;
        } else if (checkLeft) {// left 1개 없앴는데도 문자가 다를 때 right 1개 없애는 시도하러 감
            return;
        } else {
            checkLeft = true;
            check(left + 1, right); //left 1개 없앰
            if (stop) return;
            change = true;
            answer=1;
            check(left, right - 1); // right 1개 없앰
        }
    }
}
