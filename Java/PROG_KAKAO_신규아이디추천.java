import java.io.*;

public class PROG_KAKAO_신규아이디추천 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(solution(in.readLine()));
	}

	public static String solution(String new_id) {
		String answer = "";
		StringBuilder id = new StringBuilder(new_id);

		step1(id);
		//System.out.println(1 + " " + id.toString());
		step2(id);
		//System.out.println(2 + " " + id.toString());
		step3(id);
		//System.out.println(3 + " " + id.toString());
		step4(id);
		//System.out.println(4 + " " + id.toString());
		step5(id);
		//System.out.println(5 + " " + id.toString());
		step6(id);
		//System.out.println(6 + " " + id.toString());
		step7(id);
		return id.toString();
	}

	private static void step7(StringBuilder id) {
		if(id.length() == 1) {
			id.append(id.charAt(0)).append(id.charAt(0));
		}else if(id.length() == 2) {
			id.append(id.charAt(1));
		}
	}

	private static void step6(StringBuilder id) {
		if(id.length() >= 16) {
			id.setLength(15);
			if(id.charAt(14) == '.')
				id.deleteCharAt(14);
		}
	}

	private static void step5(StringBuilder id) {
		if(id.length() == 0)
			id.append('a');
	}

	private static void step4(StringBuilder id) {
		if(id.charAt(0)=='.') {
			id.deleteCharAt(0);
		}
		if(id.length() > 0 && id.charAt(id.length() - 1)=='.') {
			id.deleteCharAt(id.length() - 1);
		}
	}

	private static void step3(StringBuilder id) {
		for (int i = 0; i < id.length() - 1; i++) {
			char ch = id.charAt(i);
			if (id.charAt(i) == '.' && id.charAt(i + 1) == '.') {
				id.deleteCharAt(i);
				i--;
			}

		}
	}

	private static void step2(StringBuilder id) {
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);
			if ((Character.isDigit(ch)) || (ch >= 'a' && ch <= 'z') || ch == '.' || ch == '-' || ch == '_')
				continue;
			id.deleteCharAt(i);
			i--;
		}
	}

	private static void step1(StringBuilder id) {
		for (int i = 0; i < id.length(); i++) {
			if (id.charAt(i) >= 'A' && id.charAt(i) <= 'Z')
				id.setCharAt(i, (char) (id.charAt(i) - 'A' + 'a'));
		}
	}

}
