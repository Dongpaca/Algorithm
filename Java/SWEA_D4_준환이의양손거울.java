import java.io.*;
import java.util.StringTokenizer;

public class SWEA_D4_준환이의양손거울 {
	static int result;
	static int Factorial[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };//N! //추의 개수가 한정되있어 가능
	static int Exp[] = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };//2^N
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;tc++) {
			sb.append("#" + tc + " ");
			result = 0;
			int sum = 0;
			int N = Integer.parseInt(in.readLine());
			int[] weight = new int[N];
			boolean[] isvisited = new boolean[N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0;i<N;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum+=weight[i];
			}
				
			recur(0,N,0,0,isvisited,weight,sum);
			
			sb.append(result + "\n");
		}
		System.out.println(sb.toString());
	}
	private static void recur(int cnt, int N , int rightsum, int leftsum, boolean[] isvisited, int[] weight,int sum) {
		if(leftsum >= sum - leftsum) {//2^N * N! // 남은 추를 모두 오른쪽에 더해도 왼쪽 무게를 못넘을때 경우의 수 미리 더해버리기!
			result += Exp[N-cnt] * Factorial[N-cnt];
			return;
		}//중요한것 IF(cnt==N)보다 앞에 있어야함
		if(cnt == N) {//끝까지 추를 놓았을 때//성공
			result++;
			return;
		}
		
		for(int i = 0;i<N;i++) {
			if(isvisited[i] == true) continue;
			isvisited[i] = true;
			recur(cnt + 1, N,rightsum, leftsum + weight[i], isvisited, weight,sum);
			if(rightsum + weight[i] <= leftsum)//가지치기
				recur(cnt + 1, N,rightsum + weight[i], leftsum, isvisited, weight,sum);
			isvisited[i] = false;
			
		}
	}

}