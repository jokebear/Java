import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_B_1260_DFS와BFS {
	// https://www.acmicpc.net/problem/1260
	// arraylist, collection sort 로 그래프 구현
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int N;
	
	public static boolean isAllVisit(boolean[] array)
	{
	    for(boolean b : array) if(!b) return false;
	    return true;
	}
	
	// DFS
	private static void dfs(int from) {
		System.out.print(from+" ");
		visit[from]=true;
		if(isAllVisit(visit))
			return;
		graph[from].sort(null);
		for(int i=0;i<graph[from].size();i++) {
			if(!visit[graph[from].get(i)]) {
				dfs(graph[from].get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		
	 	graph = new ArrayList[N+1]; 
	 	visit = new boolean[N+1];
	 	
        for (int i = 1; i < N+1; i++) { 
            graph[i] = new ArrayList<Integer>(); 
        }

		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(start);
		System.out.println();
		
		// BFS
		visit = new boolean[N+1];
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(start);
		visit[start] = true;
		while(!bfs.isEmpty()) {
			int from = bfs.poll();
			System.out.print(from+" ");
			graph[from].sort(null);
			for(int i=0;i<graph[from].size();i++) {
				int node = graph[from].get(i);
				if(!visit[node]) {
					bfs.add(node);
					visit[node] = true;
				}
			}
		}
		
	}

}

