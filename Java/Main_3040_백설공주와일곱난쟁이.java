import java.io.*;
import java.util.StringTokenizer;

public class Main_3040_백설공주와일곱난쟁이 {
	static int nan[] = new int[9];
	static int num[] = new int[7];
	static int isvisited[] = new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<9;i++) {
			nan[i] = Integer.parseInt(in.readLine());
		}
		
		combination(0,0,0);
	}
	private static void combination(int cnt, int start, int sum) {
		if(cnt == 7 ) {
			if(sum == 100) {
				for(int n : num)
					System.out.println(n);
			}
			
			return;
		}
		
		for(int i = start; i <9;i++) {
			num[cnt] = nan[i];
			combination(cnt + 1, i + 1, sum + nan[i]);
		}
	}

}
