import java.util.*;

public class PROG_KAKAO_오픈채팅방 {

	public static void main(String[] args) {
		
		String[] record = 
			{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
	public static String[] solution(String[] record) {
		int N = record.length;
        String[] answer;
        List<User> userList = new ArrayList<>();//유저언제들어왔는지
        Map<String,Integer> Idmap = new HashMap<String, Integer>(); 
        List<Integer> ComeOutList = new ArrayList<>();//유저언제들어왔는지
        int userCnt = 0;
        int userComeOutCnt = 0;
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(record[i]," ");
        	String Action = st.nextToken();
        	String Id = st.nextToken();
        	String nickname = null;
        	if(st.countTokens() != 0)
        		nickname = st.nextToken();
        	int useridx = 0;
        	if(Idmap.containsKey(Id))
        		useridx = Idmap.get(Id);
        	
        	if(Action.equals("Enter")) {
        		if(Idmap.containsKey(Id) == false) {
        			Idmap.put(Id, userCnt);//Id, userIdx
        			userList.add(new User(Id,nickname));
        			userCnt++;
        		}
        		else{
        			userList.get(Idmap.get(Id)).NickName = nickname;
        		}
        		userList.get(Idmap.get(Id)).add(userComeOutCnt);
        		userComeOutCnt++;
        		ComeOutList.add(0);
        		
        	}else if(Action.equals("Leave")) {
        		userList.get(Idmap.get(Id)).add(userComeOutCnt);
        		userComeOutCnt++;
        		ComeOutList.add(1);
        	}else if(Action.equals("Change")) {
        		userList.get(Idmap.get(Id)).NickName = nickname;
        	}
        }
        String printnicknameArr[] = new String[userComeOutCnt];
        for(int i=0;i<userList.size();i++) {
        	int whenSize= userList.get(i).userWhen.size();
        	for(int j=0;j<whenSize;j++) {
        		int whenIdx = userList.get(i).userWhen.get(j);
        		printnicknameArr[whenIdx] = userList.get(i).NickName;
        	}
        }
        //user1 1,3,6
        //user2 2,4,5
        //user1 user2 user1 user2 uesr2 
        answer = new String[userComeOutCnt];
        
        for(int i=0;i<ComeOutList.size();i++) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(printnicknameArr[i]);
        	if(ComeOutList.get(i) == 0) {
        		sb.append("님이 들어왔습니다.");
        	}else {
        		sb.append("님이 나갔습니다.");
        		
        	}
        	answer[i] = sb.toString();
        }
        return answer;
    }
	public static class User{
		String Id;
		String NickName;
		List<Integer> userWhen;//유저언제들어왔는지
		public User(String id, String nickName) {
			super();
			Id = id;
			NickName = nickName;
			userWhen = new ArrayList<>();
		}
		
		public void add(int a) {
			userWhen.add(a);
		}
	}
}
