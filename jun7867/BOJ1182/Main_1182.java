import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] numbers;
	static boolean[] isSelected;
	static int total=0;

	private static void subset(int idx) {
		if(idx==N) {
			int sum=0;
			int selectedCnt=0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					sum+=numbers[i];
					selectedCnt++;
				}
			}
			
			if(sum==S && selectedCnt >0)
				total++;
			return;
		}
		isSelected[idx]=true;
		subset(idx+1);
		isSelected[idx]=false;
		subset(idx+1);

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		subset(0);
		System.out.println(total);
	}

}
