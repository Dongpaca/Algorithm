import java.util.*;

public class PROG_N으로표현 {
	static int answer = -1;
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
	}
	 public static int solution(int N, int number) {
//	        int answer = 0;
	        
	        DFS(N,number,0,0);
	        
	        return answer;
	 }
	private static void DFS(int N, int number, int cnt, int nowNum) {
		if(cnt > 8)
			return;
		if(nowNum == number) {
			if( answer > cnt || answer == -1) {
				answer = cnt;
			}
			return;
		}
		
		int NN = 0;
		
		for(int i=1;i<=8;i++) {
			NN = NN*10 + N;
			DFS(N,number,cnt + i,nowNum + NN);
			DFS(N,number,cnt + i,nowNum - NN);
			DFS(N,number,cnt + i,nowNum * NN);
			DFS(N,number,cnt + i,nowNum / NN);
		}
		
	}
}
