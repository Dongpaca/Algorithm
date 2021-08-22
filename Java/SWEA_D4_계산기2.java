import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_D4_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			char[] text = in.readLine().toCharArray();
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0;i<N;i++) {
				if(text[i] == '*') {
					stack.add((text[i+1]-'0') * stack.pop());
					i++;
				}else if(text[i] >= '0' && text[i] <= '9'){
					stack.add(text[i] -'0');
				}
			}
			int num = 0;
			while(!stack.isEmpty()) {
				num +=stack.pop();
			}
			sb.append(num).append("\n");
		}
		System.out.println(sb.toString());
	}

}
