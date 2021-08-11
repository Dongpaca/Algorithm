import java.io.*;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	static int N,M,R;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[] order = new int[R];
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<R;i++) {
			rotate(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=1;i<=map.length - 1;i++) {
			for(int j=1;j<=map[0].length -1;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void rotate(int t) {
		switch(t) {
		case 1:
			updownChange();
			break;
		case 2:
			sideChange();
			break;
		case 3:
			rightRotate();
			break;
		case 4:
			leftRotate();
			break;
		case 5:
			leftquarterRotate();
			break;
		case 6:
			rightquarterRotate();
			break;
		}
	}
	private static void rightquarterRotate() {
		leftquarterRotate();
		leftquarterRotate();
		leftquarterRotate();
	}
	private static void leftquarterRotate() {
		int[][] copy = new int[N+1][M+1];
		
		for(int i = 1;i<=N/2;i++) {
			for(int j = 1;j<=M/2;j++)
				copy[i][j+M/2] = map[i][j];
		}
		for(int i = 1;i<=N/2;i++) {
			for(int j = M/2 + 1;j<=M;j++)
				copy[i + N/2][j] = map[i][j];
		}
		for(int i = N/2 + 1;i<=N;i++) {
			for(int j = M/2 + 1;j<=M;j++)
				copy[i][j -M/2] = map[i][j];
		}
		for(int i = N/2 + 1;i<=N;i++) {
			for(int j = 1;j<=M/2;j++)
				copy[i - N/2][j] = map[i][j];
		}
		map =  new int[copy.length][copy[0].length];
		map = copy;
		
	}
	private static void rightRotate() {
		int[][] copy = new int[M+1][N+1];
		for(int j=1;j<=M;j++) {
			for(int i = N;i>=1;i--) {
				copy[j][N - i + 1] = map[i][j];
			}
		}
		map =  new int[M+1][N+1];
		map = copy;
		int tmp = N;
		N = M;
		M = tmp;
	}
	private static void leftRotate() {
		int[][] copy = new int[M+1][N+1];
		for(int j=1;j<=M;j++) {
			for(int i = 1;i<=N;i++) {
				copy[M - j + 1][i] = map[i][j];
			}
		}
		map =  new int[M+1][N+1];
		map = copy;
		int tmp = N;
		N = M;
		M = tmp;
	}
	private static void sideChange() {
		int[][] copy = new int[N+1][M+1];
		
		for(int j=1;j<=M;j++) {
			for(int i = 1;i<=N;i++) {
				copy[i][M - j + 1] = map[i][j];
			}
		}
		
		map = copy;
	}
	private static void updownChange() {
		int[][] copy = new int[N+1][M+1];
		
		for(int i = 1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				copy[N - i + 1][j] = map[i][j];
			}
		}
		
		map = copy;
	}

}
