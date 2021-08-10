import java.io.*;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	static int[] nan = new int[9];
	static boolean[] isselected = new boolean[9];
	static boolean[] perfect = new boolean[9];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<9;i++) {
			nan[i] = Integer.parseInt(in.readLine());
		}
		go(0,0,0);
		int[] result = new int[7];
		int j = 0;
		for(int i=0;i<9;i++) {
			if(perfect[i] == true) {
				result[j++] = nan[i];
			}
		}
		Arrays.sort(result);
		for(int i=0;i<7;i++)
			System.out.println(result[i]);
	}
	private static void go(int idx, int cnt, int sum) {
		
		if(cnt == 7) {
			if(sum == 100) {
				for(int i=0;i<9;i++)
					perfect[i] = isselected[i];
			}
			return;
		}
		
		if(idx == 9)
			return;
		
		if(sum + nan[idx] <= 100) {
			isselected[idx] = true;
			go(idx + 1,cnt + 1,sum + nan[idx]);
		}
		isselected[idx] = false;
		go(idx + 1,cnt,sum);
	}

}
