import java.io.*;
import java.util.*;

public class BOJ9327_상근이의여행 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int test=1;test<=T;test++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());

            for(int i=0;i<M;i++){
                st=new StringTokenizer(br.readLine());
            }
            sb.append((N-1)+"\n");
        }
        System.out.print(sb);
    }
}
