import java.io.*;
import java.util.*;

public class Solution_D3_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			Queue<String> q1= new LinkedList<>();
			Queue<String> q2= new LinkedList<>();
			Queue<String> sq= new LinkedList<>();
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			
			for(int i=0;i <N/2;i++)
				q1.add(st.nextToken());
			if(N%2 == 1)
				q1.add(st.nextToken());
			for(int i=0;i<N/2;i++)
				q2.add(st.nextToken());
			for(int i=0;i<N/2;i++) {
				sq.add(q1.poll());
				sq.add(q2.poll());
			}
			if(N%2 == 1)
				sq.add(q1.poll());
			int k = sq.size();
			for(int i=0;i<k;i++) {
				sb.append(sq.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	

}
