import java.io.*;
import java.util.*;

public class Solution_D3_암호생성기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int testcase = 2;
		for(int tc = 1; tc<=testcase;tc++) {
			sb.append("#").append(tc).append(" ");
			Queue<Integer> queue = new LinkedList<>();
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for(int i=0;i<8;i++)
				queue.offer(Integer.parseInt(st.nextToken()));
			
			boolean isFinish = false;
			while(!isFinish) {
				for(int i=1;i<=5;i++) {
					int num = queue.poll();
					if(num - i <= 0) {
						num = 0;
						queue.offer(0);
						isFinish = true;
						break;
					}else {
						queue.offer(num-i);
					}
				}
			}
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
