import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S4408_D4_자기방으로돌아가기 {

	static int[] visit;
	static int[][] room;
	
	static int answer;
	static int N;
	

		
	
	public static void main(String[] args) throws IOException{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	
	for(int t=1;t<=T;t++) {
		
		N = Integer.parseInt(br.readLine());
		
		room = new int[N][2];
		answer = Integer.MAX_VALUE;
		
		visit = new int[200];
		
		
		for(int i=0;i<N;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from=(Integer.parseInt(st.nextToken())-1)/2;
			int to =(Integer.parseInt(st.nextToken())-1)/2;
			
			if(from<to) {
				room[i][0]=from;
				room[i][1]=to;
			}else {
				room[i][0]=to;
				room[i][1]=from;
			}
			
		}
		
		for(int i=0;i<N;i++) {
			
			int from = room[i][0];
			int to = room[i][1];
			
			for(int j=from;j<=to;j++)
				visit[j]++;
			
		}
		
		int min = 0;
		for(int i=0;i<200;i++)
			if(visit[i]>min)
				min=visit[i];
		
		
		//if(answer==Integer.MAX_VALUE)
		//	answer=1;
		
		System.out.println("#"+t+" "+min);
	}
		

	}

	

}
