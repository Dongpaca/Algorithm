
public class PROG_타겟넘버 {
	static int result = 0;
	public static void main(String[] args) {
		int num[] = {1, 1, 1, 1, 1};
		int t = 3;
		solution(num,t);
	}
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        int order[] = new int[numbers.length];
        DFS(0,order,target,numbers);
        answer = result;
        
        return answer;
    }
	private static void DFS(int idx, int[] order, int target, int[] numbers) {
		if(idx == order.length) {
			int sum = 0;
			for(int i = 0;i<order.length;i++) {
				if(order[i] == 0) {
					sum += numbers[i];
				}else {
					sum -= numbers[i];
					
				}
			}
			if(target == sum) {
				for(int a: order)
					System.out.print(a + " ");
				System.out.println();
				result ++;
			}
			return;
		}
		
		order[idx] = 0;
		DFS(idx + 1,order,target,numbers);
		order[idx] = 1;
		DFS(idx + 1,order,target,numbers);
	
	}
}
