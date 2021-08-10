import java.io.*;
import java.util.StringTokenizer;

public class Main_2578_빙고 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] bingo = new int[25][2];
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<5;j++) {
				int n = Integer.parseInt(st.nextToken());
				bingo[n - 1][0] = i;
				bingo[n - 1][1] = j;
			}
		}
		int[] rowP = {0,0,0,0,0};
		int[]colP = {0,0,0,0,0};
		int[] crossP = {0,0};
		boolean []isrow = {false,false,false,false,false};
		boolean []iscol = {false,false,false,false,false};
		boolean []iscross = {false,false};
		int cnt = 0;
		int success = 0;
		boolean isfinish = false;
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<5;j++) {
				int a;
				if(cnt == 12)
					a=0;
				cnt++;
				int n = Integer.parseInt(st.nextToken()) - 1;
				int r = bingo[n][0];
				int c = bingo[n][1];
				rowP[r]++;
				colP[c]++;
				if(r == c)
					crossP[0]++;
				if(r+c == 4)
					crossP[1]++;
				if(rowP[r] == 5 && isrow[r] == false) {
					isrow[r] = true;
					success++;
				}
					
				if(colP[c] == 5&& iscol[c] == false) {
					iscol[r] = true;
					success++;
				}
					
				if(crossP[0] == 5&&iscross[0] == false) {
					iscross[0] = true;
					success++;
				}
					
				if(crossP[1] == 5&& iscross[1] == false) {
					iscross[1] = true;
					success++;
				}
					
				if(success >= 3) {
					isfinish = true;
					break;
				}
			}
			if(isfinish == true)
				break;
		}
		System.out.println(cnt);
	}	

}
