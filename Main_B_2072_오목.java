import java.util.Scanner;

public class Main_B_2072_오목 {
	public static boolean isRange(int r, int c) {
		return (r>=1&&r<=19&&c>=1&&c<=19);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer,row,col,value;
		int[][] board = new int[21][21];
		int[] dr = {-1,-1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		
		for(answer=1;answer<=N;answer++) {
			// 흑 1, 백 -1
			row = sc.nextInt();
			col = sc.nextInt();
			value = answer%2-((answer+1)%2);
			board[row][col]=value;
			boolean check;
			for(int r=1;r<=19;r++) {
				for(int c=1;c<=19;c++) {
					for(int d=4;d<=7;d++) {
						// 5목 체크
						check=true;
						for(int cnt=0;cnt<5;cnt++) {
							int nr = r + cnt*dr[d];
							int nc = c + cnt*dc[d];
							if(!isRange(nr,nc)||board[nr][nc]!=value) {
								check=false;
								break;
							}
						}
						
						if(check) {
							// 6목 체크
							int or1=r+dr[7-d];
							int oc1=c+dc[7-d];
							int or2=r+5*dr[d];
							int oc2=c+5*dc[d];
							if(isRange(or1,oc1)) {
								if(board[or1][oc1]==value)
									continue;
							}
							if(isRange(or2,oc2))
								if(board[or2][oc2]==value)
									continue;
							System.out.println(answer);
							return;
						}
					}
				}
			}
			
			
		}
		if(answer==N+1)
			System.out.println(-1);

	}

}
