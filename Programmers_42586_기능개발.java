import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_42586_기능개발 {
    
	// queue 사용
	// queue.peek() 100 이상일때까지 큐에 있는 모든 원소를 빼서 작업속도[인덱스]를 더해준뒤 다시 넣어줌
	// 100 이상인 작업을 꺼낸 개수만큼 인덱스++, 카운트++
	// 리스트에 저장한 카운트를 배열화해서 리턴함
	
	public static int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int progress : progresses)
        	queue.add(progress);
        int index = 0;
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	while(queue.peek()<=99) {
        		for(int i=0;i<size;i++) {
        			int progress = queue.poll()+speeds[index+i];
        			queue.add(progress);
        		}
        	}
        	int count = 0;
        	while(!queue.isEmpty()&&queue.peek()>=100) {
        		queue.poll();
        		count++;
        		index++;
        	}
        	result.add(count);
        }
        int[] answer = new int[result.size()];
        for(int i =0; i<result.size();i++)
        	answer[i] = result.get(i);
       
        return answer;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42586
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		int[] progresses2 = {95,90,99,99,80,99};
		int[] speeds2 = {1,1,1,1,1,1};
		solution(progresses2,speeds2);
	}

}
