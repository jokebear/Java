import java.util.Arrays;
import java.util.Scanner;

public class Main_B_17135_캐슬디펜스 {
	
	private static boolean visit[];
	private static int[][] board;
	static int N,M,D;
	static int answer = 0;
	
	private static int[] findEnemy(int c, int[][] brd) {
		int len = 10;
		int[] coord = {-1,-1};
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(brd[i][j]==1) {
					int dist = Math.abs(N-i)+Math.abs(j-c);
					if(dist>D)
						continue;
					
					if(len>dist) {
						len=dist;
						coord[0]=i;
						coord[1]=j;		
					}else if(len == dist) {
						if(coord[1]>j) {
							coord[0]=i;
							coord[1]=j;
						}
					}
				}
			}
		}
		return coord;
	}
	
	
	private static boolean moveEnemy(int[][] brd) {
		boolean isEnemyExist = false;
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(brd[i][j]==1) {
					isEnemyExist = true;
					brd[i][j]=0;
					if(i+1<N)
						brd[(i+1)][j]=1;
				}
			}
		}
		return isEnemyExist;
	}
	
	
	private static void kill() {
		
		int[][] brd = new int[N][M];
		int[][] enemy = new int[3][2];
		int kill_count = 0;
		int count,r,c;
		// 배열 복사
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				brd[i][j] = board[i][j];
		
		
		for(int i=0;i<N;i++) {
			// 가장 가까운 적 찾기
			count = 0;
			for(int j=0;j<M;j++) {
				if(!visit[j])
					continue;
				int[] coord = findEnemy(j,brd);
				enemy[count][0] = coord[0];
				enemy[count][1] = coord[1];
				count++;
			}
			
			// 죽이고 킬카운트 +1
			for(int cnt=0;cnt<3;cnt++) {
				r = enemy[cnt][0];
				c = enemy[cnt][1];
				if(r!=-1&&c!=-1) {
					if(brd[r][c]!=0)
						kill_count++;
					brd[r][c] = 0;
				}
			}
			// 적 이동시키기
			if(!moveEnemy(brd))
				break;
		}
		answer = Math.max(answer, kill_count);
		
	}
	
	// 궁수 이동
	private static void moveArcher(int count) {
		if(count==3) {
			kill();
			return;
		}
		for(int i=0;i<M;i++) {
			if(!visit[i]) {
				visit[i]=true;
				moveArcher(count+1);
				visit[i]=false;
			}
			else
				return ;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		board = new int[N][M];
		visit = new boolean[M];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				board[i][j] = sc.nextInt();
		
		moveArcher(0);
		System.out.println(answer);
	}

}
