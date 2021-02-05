
public class Programmers_43165_타겟넘버 {
	
	// dfs
	static int answer;
	
	public static void dfs(int sum, int count, int[] numbers, int target) {
		if(count==numbers.length) {
			if(sum==target)
				answer++;
			return;
		}
		dfs(sum+numbers[count],count+1,numbers,target);
		dfs(sum-numbers[count],count+1,numbers,target);
		
		
	}
    public static int solution(int[] numbers, int target) {
        answer = 0;
    	dfs(0,0,numbers,target);
        return answer;
    }
    
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/43165
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers,target));
	}

}
