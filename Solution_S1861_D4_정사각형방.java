import java.util.Scanner;

public class Solution_S1861_D4_정사각형방 {

	static int N;
	static int[][] room;
	static int[][] dp;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void find(int row, int col) {
	
		dp[row][col]=1;
		
		for(int dir=0;dir<4;dir++) {
			
			int nr = row+dr[dir];
			int nc = col+dc[dir];
			if(nr<0||nc<0||nr>=N||nc>=N||room[row][col]+1!=room[nr][nc])
				continue;
			
            if(dp[nr][nc] == 0)
            	find(nr, nc);
            
            // dp
            if(dp[row][col] < 1 + dp[nr][nc])
                dp[row][col] = 1 + dp[nr][nc];
            
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int t=1;t<=test_case;t++) {
			N = sc.nextInt();
			room = new int[N][N];
			dp = new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					room[r][c]=sc.nextInt();
				}
			}
			// 처음에 출발해야 하는 방 번호
            int room_start = Integer.MAX_VALUE;
            // 최대 몇 개의 방을 이동할 수 있는지
			int room_max = Integer.MIN_VALUE;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    
                    if (dp[r][c] == 0)
                        find(r, c);
                    
                    // dp
                    if (room_max < dp[r][c]) {
                    	room_max = dp[r][c];
                        room_start = room[r][c];
                    } else if (room_max == dp[r][c]) {
                    	room_start = room_start > room[r][c] ? room[r][c] : room_start;
                    }
 
                }
            }
			
			System.out.println("#"+t+" "+ room_start + " " + room_max);
		}
		
	}

}
