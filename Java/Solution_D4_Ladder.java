import java.io.*;
import java.util.StringTokenizer;

public class Solution_D4_Ladder {
	
	static int[][]ladder = new int[100][100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new StringReader(str));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			in.readLine(); //testcase idx 의미없음
			int ex = 0,ey = 0;
			for(int i=0;i<100;i++) {//사다리 입력
				StringTokenizer st= new StringTokenizer(in.readLine(), " ");
				for(int j = 0;j<100;j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {//최종x기억
						ex = i;
						ey = j;
					}
				}
			}
			int result = go(ex,ey);
			
			
			
			
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	static public int go(int x, int y) {
		while(x != 0) {
			if((y+1 < 100 ) && ladder[x][y + 1]== 1) {
				while( (y+1 < 100 )&&ladder[x][y+1] == 1) y++;
				
			}else if((y -1 >= 0 )&& ladder[x][y - 1]== 1) {
				while( (y -1 >= 0 )&&ladder[x][y-1] == 1) y--;
				
			}
			if(x ==0) {
				int z = 51;
			}
				
			x--;
		}
		
		
		return y;
	}
}
