package SmiteFLame.BOJ_1793;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class BOJ_1793 {
	static int max;
	static String X;
	static ArrayList<Integer> data = new ArrayList<>();
	static BigInteger[] fibonacci;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ot = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void init() throws IOException {

		while ((X = in.readLine()) != null) {
			data.add(Integer.parseInt(X));
			max = max > Integer.parseInt(X) ? max : Integer.parseInt(X);
		}
		fibonacci = new BigInteger[max + 1];
	}

	private static void implement() {
		fibonacci[0] = BigInteger.valueOf(1);
		fibonacci[1] = BigInteger.valueOf(1);
		for (int i = 2; i <= max; i++) {
			fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2].multiply(BigInteger.valueOf(2)));
		}
	}

	private static void print() throws IOException {
		for (int i = 0, end = data.size(); i < end; i++) {
			ot.write(fibonacci[data.get(i)] + "\n");
		}

		ot.flush();
		ot.close();
	}

	public static void main(String[] args) throws IOException {
		init();
		implement();
		print();
	}
}
