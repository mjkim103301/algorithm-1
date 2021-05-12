import java.util.*;
import java.io.*;

public class BOJ20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String key = input.substring(input.indexOf('.') + 1);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((k1, k2) -> k1.compareTo(k2));

        for (String key : keyList) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
