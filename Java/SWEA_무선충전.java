import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_무선충전 {

	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, 	-1 };
	static int[][][] map;
	static int[] personB,personA;
	static int M;
	static int[][] BC;
	static int sum;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			personA = new int[M];
			personB = new int[M];
			map = new int[10][10][0];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++)
				personA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++)
				personB[i] = Integer.parseInt(st.nextToken());
			BC = new int[A + 1][4];//BC 1부터 시작
			for(int i=1;i<=A;i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=0;j<4;j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			mapInit(A,BC); //bc입력
			sum = 0;
			go2();
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	private static void go2() {
		int x1 = 0, y1 = 0;
		int x2 = 9 ,y2 = 9;
		int time = 0;
		while(time <= M) {
			
			int sz1 = map[x1][y1].length;
			int sz2 = map[x2][y2].length;
			if(sz1 == 0 && sz2  > 0) {
				int  tmp =0;
				for(int i=0;i<sz2 ;i++) {
					tmp = Math.max(tmp, BC[map[x2][y2][i]][3]);
				}
				sum+=tmp;
			}
			else if(sz1 > 0 && sz2 == 0) {
				int  tmp =0;
				for(int i=0;i<sz1 ;i++) {
					tmp = Math.max(tmp, BC[map[x1][y1][i]][3]);
				}
				sum+=tmp;
			}
			else if(sz1 > 0 && sz2 > 0) {
				int tmp = 0;
				for(int i=0;i<sz1 ;i++) {
					for(int j=0;j<sz2 ;j++) {
						if(map[x1][y1][i] == map[x2][y2][j]) {
							tmp = Math.max(tmp,BC[map[x1][y1][i]][3]);
						}else {
							tmp = Math.max(tmp,BC[map[x1][y1][i]][3] + BC[map[x2][y2][j]][3]);
						}
					}
				}
				sum+=tmp;
			}
			if(time == M)
				break;
			
			x1 += dx[personA[time]];
			y1 += dy[personA[time]];
			x2 += dx[personB[time]];
			y2 += dy[personB[time]];
			time++;
		}
		return;
	}

	private static void mapInit(int A, int[][] BC) {
		for(int i=1;i<=A;i++) {
			int x = BC[i][1] - 1;
			int y = BC[i][0] - 1;
			int c = BC[i][2];
			for(int j = x - c;j<=x+c;j++) {
				if(j<0 || j>= 10) continue;
				for(int k = y - c; k <=y+c;k++) {
					if(k<0 || k>= 10) continue;
					//D = |XA – XB| + |YA – YB|
					if(c>= (int)Math.abs(j - x) +  (int)Math.abs(k - y)) {
						map[j][k] = Arrays.copyOf(map[j][k], map[j][k].length + 1);
						map[j][k][map[j][k].length - 1] = i;
					}
				}
			}
			
			
		}
	}

}
