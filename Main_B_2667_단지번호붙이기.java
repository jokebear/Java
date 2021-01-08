import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_B_2667_단지번호붙이기 {
	
	static int[][] map;
	static PriorityQueue<Integer> sum = new PriorityQueue<>();
	
	public static void find(int row,int col) {
		
		// 1. 집찾기 - BFS
		Queue<int[]> danji = new LinkedList<int[]>();
		
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		danji.add(new int[] {row,col});

		int count = 0;
		while(!danji.isEmpty()) {
			int[] rc = danji.poll();
			
			for(int pos=0;pos<4;pos++) {
				int next_r = rc[0] + dr[pos];
				int next_c = rc[1] + dc[pos];
				if(map[next_r][next_c]==0)
					continue;
				danji.add(new int[] {next_r,next_c});
				map[next_r][next_c]=0;
				count++;
			}
		}
		
		// 2. 집의 수 오름차순 저장 - Priority Queue
		sum.add(count==0?1:count);
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		
		for(int row=1;row<=N;row++) {
			String st = br.readLine();
			for(int col=1;col<=N;col++) {
				map[row][col] = Integer.parseInt(st.substring(col-1, col));
			}
		}
		
		for(int row=1;row<=N;row++) {
			for(int col=1;col<=N;col++) {
				if(map[row][col]!=0)
					find(row,col);
			}
		}
		
		System.out.println(sum.size());
		
		while(!sum.isEmpty()) {
			System.out.println(sum.poll());
		}
		
	}

}
