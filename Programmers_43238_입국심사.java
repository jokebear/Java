public class Programmers_43238_입국심사 {
  // 변수 long 처리
	// 0 ~ 최대 시간 * n 사이 이분탐색
	// 중간값 / 시간 을 더한 값과 n을 비교하며 탐색한다
	
	public static long solution(int n, int[] times) {
    	
        long answer = Long.MAX_VALUE;
        long right = 0;
        long left = 0;
        for(int time : times)
        	right = Math.max(right, time);
        
        right *= n;
        
        while(left<=right) {
        	long mid = (left+right)/2;
        	// 검사 할 수 있는 수
        	long count = 0;
        	for(int time : times)
        		count += mid/time;
        	
        	// 검사 해야하는 사람 수보다 작음
        	if(count<n) {
        		left=mid+1;
        	}
        	// 검사 해야하는 사람 수보다 크거나 같음
        	else {
        		// 일단 최솟값 갱신
        		if(mid<answer)
        			answer=mid;
        		// 가능 -> 시간 줄여보기 
        		right = mid-1;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/43238
		System.out.println(solution(6,new int[] {7,10}));
	}

}
