import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Job{
	int request;
	int spend;
	public Job(int request,int spend) {
		this.request=request;
		this.spend = spend;
	}
}

public class Programmers_42627_디스크컨트롤러 {

	public static int solution(int[][] jobs) {
        
        // 대기시간 오름차순 정렬 리스크
        LinkedList<Job> request = new LinkedList<>();
        for(int[] job : jobs)
        	request.offer(new Job(job[0],job[1]));
        
        Collections.sort(request, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return j1.request - j2.request;
			}
    	});
        // 작업시간 오름차순 정렬 우선순위큐
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>(){
        	@Override
        	public int compare(Job j1, Job j2) {
        		return j1.spend - j2.spend;
        	}
        });
        
        int answer = 0;
        int cnt = 0;
    	int time = request.peek().request;

    	while(cnt < jobs.length) {
    		while(!request.isEmpty() && request.peek().request <= time) {
    			pq.offer(request.pollFirst());
    		}
    		
    		if(!pq.isEmpty()) {
    			Job job = pq.poll();
    			time += job.spend;
    			answer += time - job.request;
    			cnt++;
    		} else {
    			time++;
    		}
    	}
        
        return answer/cnt;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42627
		System.out.println(solution(new int[][]{{0, 3},{1,9},{2,6}})+" 9");
		System.out.println(solution(new int[][]{{0, 10}, {2, 10}, {9, 10}, {15, 2}} )+" 14");
		System.out.println(solution(new int[][]{{0, 10}, {2, 12}, {9, 19}, {15, 17}} )+" 25");
		System.out.println(solution(new int[][]{{0, 3}, {1,9}, {2,6}} )+" 9");
		System.out.println(solution(new int[][]{{0, 1}} )+" 1");
		System.out.println(solution(new int[][]{{1000,1000}} )+" 1000") ;
		System.out.println(solution(new int[][]{{0, 1}, {0,1}, {0,1}} )+" 2") ;
		System.out.println(solution(new int[][]{{0, 1}, {0,1}, {0,1}, {0,1}} )+" 2") ;
		System.out.println(solution(new int[][]{{0, 1},{1000,1000}} )+" 500") ;
		System.out.println(solution(new int[][]{{100,100},{1000,1000}} )+" 550") ; // 
		System.out.println(solution(new int[][]{{10,10},{30,10},{50,2},{51,2}} )+" 6") ; 
		System.out.println(solution(new int[][]{{0, 3},{1,9},{2,6},{30,3}} )+" 7") ;

	}

}
