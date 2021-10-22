
public class PROG_KAKAO_숫자문자열과영단어 {
	static String[] numberAlpha = {
			"zero","one","two","three","four","five","six","seven","eight","nine"
	};
	public static void main(String[] args) {
		String s = "2three45sixseven";
		solution(s);
	}
    public static int solution(String s) {
        int answer = 0;
        for(int i=0;i<10;i++) {
        	String tmp = Character.toString((char)(i+'0'));
        	s = s.replaceAll(numberAlpha[i], tmp);
        }
        answer = Integer.parseInt(s);
        //System.out.println(answer);
        return answer;
    }
}
