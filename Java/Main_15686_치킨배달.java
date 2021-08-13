import java.io.*;
import java.util.*;

public class Main_15686_치킨배달 {
	static int N,M;
	static int[][] map;
	static int chickencnt;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		List<int[]> house = new ArrayList<int[]>();
		List<int[]> chicken = new ArrayList<int[]>();
		chickencnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j< N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					house.add(new int[] {i,j});
				}
				else if(tmp == 2) {
					chickencnt++;
					chicken.add(new int[] {i,j});
				}
			}
		}
		int[] checkbit = new int[chickencnt];
		int j = 0;
		while(++j <= M) checkbit[chickencnt - j] = 1;
		
		int result = -1;
		int sum;
		do {
			sum = 0;
			for(int w = 0; w<house.size();w++) {
				int tmpmin = -1;
				for(int i=0;i<chickencnt;i++) {
					if(checkbit[i] == 1) {
						int sx = chicken.get(i)[0] - house.get(w)[0];
						int sy = chicken.get(i)[1] - house.get(w)[1];
						sx = sx >= 0 ? sx : -sx;
						sy = sy >= 0 ? sy : -sy;
						if(tmpmin == -1 || tmpmin > (sx+sy)) {
							tmpmin = sx+sy;
						}
					}
				}
				sum+= tmpmin;
			}
			if(result == -1 || result > sum)
				result = sum;
			
		}while(next_permutation(checkbit));
		
		System.out.println(result);
	}
	private static boolean next_permutation(int[] checkbit) {
		int i=chickencnt - 1;
		while(i > 0 && checkbit[i-1] >= checkbit[i]) --i;
		
		if(i == 0) return false;
		
		int j = chickencnt - 1;
		while(checkbit[i-1] >= checkbit[j]) j--;
		
		int tmp = checkbit[i-1];
		checkbit[i-1] = checkbit[j];
		checkbit[j] = tmp;
		
		int k = chickencnt-1;
		while(i<k) {
			tmp = checkbit[i];
			checkbit[i] = checkbit[k];
			checkbit[k] = tmp;
			k--;
			i++;
		}
		return true;
	}

}
