import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1873_D3_상호의배틀필드 {

	// 					   상1 하2 좌3 우4
	static int dr[] = { 0,-1, 1, 0, 0 };
	static int dc[] = { 0,0, 0, -1, 1 };

	static char map[][];
	static int play[];
	
	
	static Tank tank;

	static int H;
	static int W;
	static int N;

	static int answer;
	
	public static class Tank {
		
		int row;
		int col;
		int dir;

		Tank(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

	}

	// 평지 = 0
	// 바깥 && 강철 = 3
	// 벽돌 = 1
	// 물 = 2
	public static void startGame() {
		
		int pdir,prow,pcol;
		int ndir,nrow,ncol;
		for(int i=0;i<N;i++) {
			
			ndir = tank.dir;
			nrow = tank.row;
			ncol = tank.col;
			
			
			if(play[i]==0) {
				
	
				prow = nrow+dr[ndir];
				pcol = ncol+dc[ndir];
				
				while(map[prow][pcol]!='#') {
					
					if(map[prow][pcol]=='*') {
						map[prow][pcol]='.';
						break;
					}
					
					prow+=dr[ndir];
					pcol+=dc[ndir];
				}
			}
			else {
				
				pdir = play[i];
				prow = nrow+dr[pdir];
				pcol = ncol+dc[pdir];
				
				tank.dir=pdir;
				
				char cdir=map[nrow][ncol];
				
				switch(pdir) {
				case 1:cdir ='^';break;
				case 2:cdir ='v';break;
				case 3:cdir = '<';break;
				case 4:cdir = '>';break;
				}

				if(map[prow][pcol]=='.') {
					
					map[nrow][ncol]='.';
					map[prow][pcol]=cdir;
					
					tank.row=prow;
					tank.col=pcol;
					
				}
				else
					map[nrow][ncol]=cdir;
				
			}
			
			
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		String temp="";
		char token;
	
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H + 2][W + 2];

			for (int i = 0; i <= H + 1; i++) {
				map[i][0] = '#';
				map[i][W + 1] = '#';
			}

			for (int i = 0; i <= W + 1; i++) {
				map[0][i] = '#';
				map[H + 1][i] = '#';
			}

			int direction = -1;

			for (int i = 0; i < H; i++) {
				temp = br.readLine();
				for (int j = 0; j < W; j++) {
					direction = -1;
					token = temp.charAt(j);

					switch (token) {
					case '^': direction = 1; break;
					case 'v': direction = 2; break;
					case '<': direction = 3; break;
					case '>': direction = 4; break;
					}

					if (direction != -1)
						tank = new Tank(i+1, j+1, direction);
					map[i+1][j+1]=token;
				}
			}
			
			N = Integer.parseInt(br.readLine());
			play = new int[N];
			
			temp = br.readLine();
			for(int i=0;i<N;i++) {
				token = temp.charAt(i);
				switch (token) {
				case 'S':direction=0; break;
				case 'U':direction=1; break;
				case 'D':direction=2; break;
				case 'L':direction=3; break;
				case 'R':direction=4; break;
				}
				
				play[i]=direction;
			}
			
			answer =0 ;
		
			startGame();
			System.out.print("#"+t+" ");
			
			for(int i=1;i<=H;i++) {
				for(int j=1;j<=W;j++) {
					System.out.print(map[i][j]);
				}
			System.out.println();	
			}
			
			

		}

	}

}
