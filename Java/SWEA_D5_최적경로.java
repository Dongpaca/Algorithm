import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D5_최적경로 {
	static int N;
	static int sumResult;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;tc++) {
			sb.append("#" + tc + " ");
			int result = 0;
			N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			Position[] Customer = new Position[N + 2];
			for(int i=0;i<N + 2;i++)//2~N + 1까지가 고객 0: 회사 : 1
				Customer[i] = new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			int distance[] = new int[N + 2];
			boolean isvisited[] = new boolean[N + 2];
			sumResult = Integer.MAX_VALUE;
			go(Customer,0,0,isvisited, 0);
			
			sb.append(sumResult + "\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void go(Position[] customer, int cnt,int start, boolean[] isvisited,int sum) {
		if(sum > sumResult)
			return;
		if(cnt == N) {
			sum += calcDistance(customer,start,1);
			if(sum < sumResult)
				sumResult = sum;
			return;
		}
		for(int i = 2;i<N+2;i++) {
			if(isvisited[i] == true) continue;
			isvisited[i] = true;
			go(customer,cnt+1,i,isvisited, sum + calcDistance(customer,start,i));
			isvisited[i] = false;
		}
		
	}
	private static int calcDistance(Position[] customer,int start, int end) {
		return Math.abs(customer[start].x - customer[end].x) + Math.abs(customer[start].y - customer[end].y);
	}
	private static class Position{
		int x,y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
