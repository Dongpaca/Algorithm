

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String s1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static String s2 = "\"재귀함수가 뭔가요?\"\n";
	static String s3_1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static String s3_2 ="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String s3_3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String s4 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String s5 = "라고 답변하였지.\n";
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(s1);
		factory(sb,0);
		System.out.println(sb.toString());
	}

	private static void factory(StringBuilder sb, int i) {
		// TODO Auto-generated method stub
		if(i == n + 1)
			return;
		for (int j = 0; j < i; j++)
			sb.append("____");
		sb.append(s2);
		if(i == n) {
			for (int j = 0; j < i; j++)
				sb.append("____");
			sb.append(s4);
			for (int j = 0; j < i; j++)
				sb.append("____");
			sb.append(s5);
			return;
		}
		for (int j = 0; j < i; j++)
			sb.append("____");
		sb.append(s3_1);
		for (int j = 0; j < i; j++)
			sb.append("____");
		sb.append(s3_2);
		for (int j = 0; j < i; j++)
			sb.append("____");
		sb.append(s3_3);
		factory(sb,i+1);
		for (int j = 0; j < i; j++)
			sb.append("____");
		sb.append(s5);
	}

}
