import java.io.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;


public class PROG_KAKAO_추석트래픽 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> li = new LinkedList<String>();
        while(true) {
        	String tmp = in.readLine();
        	if(tmp == null)
        		break;
        	li.add(tmp);
        }
        String[] t = li.toArray(new String[li.size()]);
		System.out.println(solution(t));
	}
	public static int solution(String[] lines) throws FileNotFoundException {
		int answer = 1;
        int N = lines.length;
        int[] startArr = new int[N];
        int[] endArr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st,Tt,Pt,sst,Psst;
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(lines[i]);
        	String NDate = st.nextToken();
        	String NTime = st.nextToken();
        	Tt = new StringTokenizer(NTime,":");
        	int Hour = Integer.parseInt(Tt.nextToken());
        	int Minute = Integer.parseInt(Tt.nextToken());
        	sst = new StringTokenizer(Tt.nextToken(),".");
        	int seceond = Integer.parseInt(sst.nextToken());
        	int milliseceond = Integer.parseInt(sst.nextToken());
        	endArr[i] = calc(Hour,Minute,seceond,milliseceond);
        	//String ProcessingTime = st.nextToken();
        	Psst = new StringTokenizer(st.nextToken(),".s");
        	int Pseceond = Integer.parseInt(Psst.nextToken());
        	int Pmilliseceond;
        	if(Psst.countTokens() == 0)
        		Pmilliseceond = 0;
        	else
        		Pmilliseceond = Integer.parseInt(Psst.nextToken());
        	
        	if(Pmilliseceond == 0) {
        		Pseceond -=1;
        		Pmilliseceond = 999;
        	}
        	else
        		Pmilliseceond = Pmilliseceond -  1;
        	int PTimeCalc = calc(0,0,Pseceond,Pmilliseceond);
        	startArr[i] = endArr[i] - PTimeCalc;
        }
       for(int i=0;i<N;i++) {
    	   int tmpcnt = 1;
    	   for(int j = i+1;j<N;j++) {
    		   //if(i==j) continue;
    		   if(ismatch(startArr[i],endArr[i],startArr[j],endArr[j]))
    			   tmpcnt++;
    	   }
    	   if(tmpcnt > answer)
    		   answer = tmpcnt;
       }
        return answer;
    }
	private static boolean ismatch(int startA, int endA, int startB, int endB) {
		if(startB <= endA + 999)
			return true;
		else
			return false;
	}
	private static int calc(int hour, int minute, int seceond, int milliseceond) {
		int tmp = 0;
		tmp += hour * 60 * 60;
		tmp += minute * 60;
		tmp += seceond;
		tmp *=1000;
		tmp += milliseceond;
		return tmp;
	}

}
