import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_B_7576_토마토 {
// https://www.acmicpc.net/problem/7576
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int time = -1;
		Queue<int[]> queue = new LinkedList<>();
		int[][] tomatoes = new int[N][M];
		
		for(int i=0;i<N;i++) 
			for(int j=0;j<M;j++) {
				int t = sc.nextInt();
				if(t==1)
					queue.add(new int[] {i,j});
				tomatoes[i][j]= t;
			}
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
	
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int k=0;k<size;k++) {
				int[] coord = queue.poll();
				int r = coord[0];
				int c = coord[1];
				for(int i=0;i<4;i++) {
					int nr = r+dr[i];
					int nc = c+dc[i];
					if(nr<0||nc<0||nr>=N||nc>=M||tomatoes[nr][nc]!=0)
						continue;
					tomatoes[nr][nc]=1;
					queue.add(new int[] {nr,nc});
				}
			}
				time++;
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) 
				if(tomatoes[i][j]==0) {
					time=-1;
					break;
				}
		if(!queue.isEmpty())
			time=0;
		System.out.println(time);
		

	}

}
