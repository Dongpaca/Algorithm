import java.io.*;
import java.util.*;

public class SWEA_요리사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int bit[] = new int[N];
			int[][] score = new int [N][N];
			List<Integer> food1 = new ArrayList<Integer>(),food2 = new ArrayList<Integer>();
			for(int i =0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j=0;j<N;j++)
					score[i][j] = Integer.parseInt(st.nextToken());
			}
			int p = N-1;
			int cnt = 0;
			int result = Integer.MAX_VALUE;
			while(++cnt <= N/2) bit[N -cnt] = 1; 
			do {
				food1.clear();food2.clear();
				for(int i = 0;i<N;i++) {
					if(bit[i] == 1)
						food1.add(i);
					else
						food2.add(i);
				}
				int tmp = calc(score,food1,food2);
				if(result > tmp)
					result = tmp;
			}while(np(bit));
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int calc(int[][] score, List<Integer> food1, List<Integer> food2) {
		int sum1 = 0, sum2 = 0;
		for(int i = 0;i<food1.size();i++) {
			for(int j = 0;j<food1.size(); j++) {
				if(i == j) continue;
				sum1 += score[food1.get(i)][food1.get(j)];
			}
		}
		for(int i = 0;i<food2.size();i++) {
			for(int j = 0;j<food2.size(); j++) {
				if(i == j) continue;
				sum2 += score[food2.get(i)][food2.get(j)];
			}
		}
		
		
		
		return Math.abs(sum1 - sum2);
	}


	private static boolean np(int[] bit) {
		int i = bit.length - 1;
		while(i > 0 && bit[i - 1] >= bit[i]) i--;
		if(i == 0) return false;
		int j = bit.length - 1;
		while(bit[i - 1] >= bit[j]) j--;
		
		int tmp = bit[i-1];
		bit[i-1] = bit[j];
		bit[j] = tmp;
		
		int k = bit.length - 1;
		while(i<k) {
			tmp = bit[i];
			bit[i] = bit[k];
			bit[k] = tmp;
			i++;k--;
		}
		
		return true;
	}

}
