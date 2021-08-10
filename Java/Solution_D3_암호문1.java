import java.io.*;
import java.util.*;

public class Solution_D3_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			List<String> list = new LinkedList<String>();
			
			int n1 = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0;i< n1;i++)
				list.add(st.nextToken());
			int n2 = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			
			while(n2-->0) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int i=0;i<y;i++)
					list.add(x + i, st.nextToken());
			}
			for(int i=0;i<10;i++)
				sb.append(list.get(i)).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
