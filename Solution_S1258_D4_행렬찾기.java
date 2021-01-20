import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_S1258_D4_행렬찾기 {

	static int board[][];
	static boolean visit[][];
	static int n;
	static PriorityQueue<Array> pq ;
	
	public static class Array implements Comparable<Array> {

		int row;
		int col;
		int size;

		Array(int row, int col) {
			this.row = row;
			this.col = col;
			this.size = row * col;
		}

		@Override
		public int compareTo(Array arr) {

			if (this.size < arr.size)
				return -1;
			else if (this.size > arr.size)
				return 1;
			else {
				if (this.row < arr.row)
					return -1;
				else if (this.row > arr.row)
					return 1;
				else
					return 0;
			}
		}
		public String toString() {
			return row+" "+col;
		}

	}

	public static void add(int sr,int sc) {
		
		int startrow=0,startcol=0;
		int endrow=0,endcol=0;
		boolean check=false;
		int end=n;
		
		L:for(int i=sr;i<n;i++) {
			for(int j=sc;j<end;j++) {
				
				if(visit[i][j]||board[i][j]==0)
					break;
				
				visit[i][j]=true;
				
				if(!check&&board[i][j]!=0) {
					startrow=i;
					startcol=j;
					check=true;
				}
				if(check&&board[i+1][j]==0&&board[i][j+1]==0) {
					endrow=i;
					endcol=j;
					break L;
				}
				if(check&&board[i][j]==0) {
					end=j;
					continue;
				}
			}
		}
		
		pq.add(new Array((endrow-startrow+1),(endcol-startcol+1)));
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine().trim());

		
		for (int t = 1; t <= test_case; t++) {

			n = Integer.parseInt(br.readLine().trim());
			board = new int[n+1][n+1];
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			
			
			visit = new boolean[n+1][n+1];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++) {
					if(visit[i][j]||board[i][j]==0)
						continue;
						add(i,j);}
			
			System.out.print("#"+t+" "+pq.size()+" ");
			while(!pq.isEmpty())
			System.out.print(pq.poll()+" ");
			System.out.println();
			
				
			}
		
		
			
			
			
			
			
			
			

		}

	}
