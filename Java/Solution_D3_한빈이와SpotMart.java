import java.io.*;
import java.util.*;

public class Solution_D3_한빈이와SpotMart {
	static List<Integer> list = new ArrayList<Integer>();
	static int maxsum;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			list.clear();
			maxsum = -1;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M =Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i < N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(list.get(i) + list.get(j)<=M && list.get(i) + list.get(j) > maxsum) {
						maxsum = list.get(i) + list.get(j);
					}
				}
			}
			//recur(0,0,M,0);
			sb.append(maxsum).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void recur(int idx, int sum, int M, int cnt) {
		if(cnt == 2 && sum > maxsum) {
			maxsum = sum;
			return;
		}
		if(idx == N)
			return;
		if(sum + list.get(idx) <= M)
			recur(idx + 1, sum + list.get(idx), M, cnt + 1);
		recur(idx + 1, sum, M, cnt);
		
	}
	
}
