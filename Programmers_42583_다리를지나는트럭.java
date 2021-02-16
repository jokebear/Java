import java.util.LinkedList;
import java.util.Queue;

public class Programmers_42583_다리를지나는트럭 {

	// 다리에 들어갈 수 있는 트럭이면 다리큐에 집어넣고
	// 못들어가면 다리큐 poll() offer(0)
	// 전체 무게 계속 업데이트 해주고 while문 끝나면 bridge_length만큼 더해줌
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int truck : truck_weights)
        	trucks.offer(truck);
        
        for(int i=0;i<bridge_length;i++)
        	bridge.offer(0);
        
        int total = 0;
        int answer = 0;
        
        while(!trucks.isEmpty()) {	
        	
        	if(bridge.peek()!=0) {
        		total-=bridge.peek();
        	}
        	if(total+trucks.peek()<=weight) {
        		bridge.poll();
        		int truck = trucks.poll();
    			bridge.offer(truck);
    			total+=truck;
        	}else {
        		bridge.poll();
        		bridge.offer(0);
        	}
        	answer++;
        }
        return answer+bridge_length;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42583
		int bridge_length= 2;
		int weight =10;
		int[] truck_weights = {7,4,5,6};
		int bridge_length2= 100;
		int weight2 =100;
		int[] truck_weights2 = {10};
		int bridge_length3= 100;
		int weight3 =100;
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(bridge_length3,weight3,truck_weights3));
	}

}
