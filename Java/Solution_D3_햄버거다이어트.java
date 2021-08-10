import java.io.*;
import java.util.StringTokenizer;

public class Solution_D3_햄버거다이어트 {
	static int N,L;
	static int maxscore;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			int[][] grocery =  new int[20][2];
			
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L  = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine()," ");
				grocery[i][0] = Integer.parseInt(st.nextToken());
				grocery[i][1] = Integer.parseInt(st.nextToken());
			}
			maxscore = 0;
			go(grocery, 0 , 0,0);
			sb.append(maxscore);
			sb.append("\n");
			
			
		}
		System.out.println(sb.toString());
	}
	private static void go(int[][] grocery ,int idx, int sumcal, int sumscore) {
		if(maxscore < sumscore) {
			maxscore = sumscore;
		}
		if(idx == N )
			return;
		
		if(sumcal + grocery[idx][1] <= L)
			go(grocery,idx + 1, sumcal + grocery[idx][1], sumscore + grocery[idx][0]);
		go(grocery,idx + 1, sumcal, sumscore);
		
		
	}

}
