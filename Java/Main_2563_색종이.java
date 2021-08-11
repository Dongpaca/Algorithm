import java.io.*;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		boolean[][]map = new boolean[100][100];
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			for(int i = r;i<r + 10;i++) {
				for(int j = c;j < c+ 10;j++) {
					map[i][j] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0;i<100;i++) {
			for(int j = 0;j < 100;j++) {
				if(map[i][j] == true) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
