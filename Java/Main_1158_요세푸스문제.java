import java.io.*;
import java.util.*;

public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		Deque<Integer> d = new ArrayDeque<Integer>();
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		sb.append("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) 
			d.addLast(i);
		
		
		int cnt = 0;
		int idx = 0;
		while(!d.isEmpty()) {
			for(int i=0;i<K - 1;i++) {
				d.addLast(d.pollFirst());
			}
			sb.append(d.pollFirst()).append(",").append(" ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}

}
