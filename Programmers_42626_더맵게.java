import java.util.Arrays;
import java.util.PriorityQueue;

// Priority Queue 사용
public class Programmers_42626_더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        if(scoville[0]>=K)
        	return answer;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int food : scoville)
        	pq.add(food);
        
        while(pq.size()>=2&&pq.peek()<K) {
        	int first = pq.poll();
        	int second = pq.poll();
        	pq.add(first+second*2);
        	answer++;
        }
        if(!pq.isEmpty()&&pq.poll()<K) {
        	return -1;
        }
        
       
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,7},7));

	}

}
