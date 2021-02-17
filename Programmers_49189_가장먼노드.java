import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_49189_가장먼노드 {
	// 그래프 구현 arraylist
	// 노드 탐색 bfs
	// 최단거리 저장 array
	public static int solution(int n, int[][] edge) {
        
		int answer = 0;
        // 최단거리 저장 및 방문여부 
        int[] visit = new int[n+1];
        // 간선 저장
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        	arr[i] = new ArrayList<Integer>();
        for(int[] vertex : edge) {
        	arr[vertex[0]].add(vertex[1]);
        	arr[vertex[1]].add(vertex[0]);
        }
        // BFS 1부터 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while(!queue.isEmpty()) {
        	int node = queue.poll();
        	// 최초 방문일 경우 큐에 넣기, 부모 노드의 최단거리 +1 저장
        	for(int next_node : arr[node]) {
        		if(next_node==1||visit[next_node]!=0)
        			continue;
        		visit[next_node] = visit[node]+1;
        		queue.offer(next_node);
        	}
        }
     
        Arrays.sort(visit);
        int max = visit[n];
        for(int i=n;i>=1;i--) {
        	if(visit[i]!=max)
        		break;
        	answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/49189
		System.out.println(solution(6,new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
	}

}
