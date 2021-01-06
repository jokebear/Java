import java.util.*;
import java.io.*;

public class Solution_S1210 {
	
	static int answer;
	static int dr[] = {0,0,-1};
	static int dc[] = {1,-1,0};
	static int board[][] = new int[100][102];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case;
		int num;
		
		for(int i=0;i<10;i++) {
			
			st = new StringTokenizer(br.readLine());
			test_case = Integer.parseInt(st.nextToken());
			answer = 0;
			int row,col=0;
			
			for(int r=0;r<100;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=1;c<=100;c++) {
					num = Integer.parseInt(st.nextToken());
					if(num==2)
						col = c;
					board[r][c] = num;
				}
			}

			for(row=99;row>=0;row--) {
				
				if(board[row][col-1]==1) {
					while(true) {
						col-=1;
						if(board[row][col]!=1) {
							col+=1;break;}
					}
				}
				else if(board[row][col+1]==1) {
					while(true) {
						col+=1;
						if(board[row][col]!=1){
							col-=1;break;}
					}
				}
			}
			answer = col-1;
			System.out.println("#"+test_case+" "+answer);
			
		}
		
	
	
	}
	
}
