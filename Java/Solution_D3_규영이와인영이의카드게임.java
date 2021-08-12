import java.io.*;
import java.util.StringTokenizer;

public class Solution_D3_규영이와인영이의카드게임 {
	static int[] gue = new int[9];
	static int[] inyeong = new int[9];
	static int[] candidate = new int[9];
	static int[] result;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			boolean []checknum = new boolean[19];
			result = new int[3];
			for(int i=0;i<9;i++) {
				gue[i] = Integer.parseInt(st.nextToken());
				checknum[gue[i]] = true;
			}
			int cidx = 0;
			for(int i = 1;i<=18;i++) {
				if(checknum[i] == false) {
					candidate[cidx++] = i;
				}
			}
			perm(0,0);
			
			sb.append(result[1]+" ").append(result[2]).append("\n");
			
		}
		System.out.println(sb.toString());
		
		
	}
	private static void perm(int cnt, int check) {
		if(cnt == 9) { 
			result[calc()]++;
			
			
			return;
		}
		for(int i = 0;i<9;i++) {
			if((check&(1<<i)) == 0) {
				inyeong[cnt] = candidate[i];
				perm(cnt+1,check|(1<<i));
				
			}
		}
		
	}
	private static int calc() {
		int guesum = 0;
		int insum = 0;
		for(int i=0;i<9;i++) {
			if(gue[i] > inyeong[i])
				guesum += gue[i]  + inyeong[i];
			else
				insum += gue[i]  + inyeong[i];
		}
		if(guesum > insum)
			return 1;
		else if(guesum < insum)
			return 2;
		else
			return 0;
	}

}
