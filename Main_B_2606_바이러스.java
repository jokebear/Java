import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_B_2606_바이러스 {
	// https://www.acmicpc.net/problem/2606
	// bfs & array of arraylist
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		boolean[] visit = new boolean[N+1];
		
		for(int i=1;i<=N;i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(1);
		visit[1]=true;
		int count = 0;
		while(!bfs.isEmpty()) {
			int from = bfs.poll();
			for(int i=0;i<adj[from].size();i++) {
				int to = adj[from].get(i);
				if(!visit[to]) {
					bfs.add(to);
					visit[to]=true;
					count++;
				}
			}
		}
		System.out.println(count);
		
		
		
	}

}
