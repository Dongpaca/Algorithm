import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_괄호짝짓기 {
	static String openPa = "({<[";
	static String closePa = ")}>]";
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int testcase = 10;
		for(int tc = 1; tc<=testcase;tc++) {
			sb.append("#").append(tc).append(" ");
			
			
			Stack<Character> stack = new Stack<>();
			int n = Integer.parseInt(in.readLine());
			char[] bracket = in.readLine().toCharArray();
			boolean success = true;
			for(int i=0;i<n;i++) {
				char pa =bracket[i];
				if(openPa.indexOf(pa) != -1) {//여는 괄호면 스택 저장
					stack.push(pa);
				}else {//닫는 괄호
					if(stack.isEmpty()) {//스택이 비어있다면->실패 , 여는 괄호가 없으니
						success = false;
					}else {
						char stackPa = stack.peek();
						stack.pop();
						if(closePa.indexOf(pa) != openPa.indexOf(stackPa)) {//짝이 맞지 않으면
							success = false;
						}
					}
				}
			}
			if(!stack.isEmpty())
				success = false;
			if(success == true)
				sb.append("1");
			else
				sb.append("0");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
