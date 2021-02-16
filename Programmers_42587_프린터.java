import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers_42587_프린터 {
	
	// max 우선순위큐에 중요도를 저장함
	// 대기열 큐 queue에 중요도와 초기 순서를 저장함
	// queue와 max 큐의 맨 앞 원소를 비교하여 인쇄할 수 있으면 두 큐를 poll 하고 인쇄순서를 1 더함
	// 인쇄할 수 없으면 다시 queue에 집어넣음
	
    public static int solution(int[] priorities, int location) {
        
    	  int answer = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++) {
        	max.offer(priorities[i]);
        	queue.offer(new int[] {priorities[i],i});
        }
        
        while(!queue.isEmpty()) {
        	int[] top = queue.poll();
        	if(top[0]>=max.peek()) {
        		max.poll();
        		answer++;
        		if(top[1]==location)
        			return answer;
        	}else {
        		queue.offer(top);
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42587
		System.out.println(solution(new int[] {1,1,9,1,1,1},0));
	}

}
