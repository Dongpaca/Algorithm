import java.io.*;
import java.util.*;

public class Main_2605_줄세우기 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		
		List<Integer> student = new LinkedList<Integer>();
		
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		student.add(1);
		st.nextToken();
		for(int i = 2; i <=N;i++) {
			int m = Integer.parseInt(st.nextToken());
			student.add(i - m - 1,i);
		}
		for(int i=0;i<student.size();i++)
			System.out.print(student.get(i) + " ");
	}

	
}
