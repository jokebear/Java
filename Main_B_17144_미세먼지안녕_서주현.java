import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_B_17144_미세먼지안녕_서주현 {

	static int R;
	static int C;
	static int T;

	static int area[][];

	static Point ccw; // 반시계방향
	static Point cw; // 시계방향

	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static class Point {
		int x;
		int y;
		int val;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Point(int x, int y, int val) {
			this(x, y);
			this.val = val;
		}

	}

	public static void dust() {

		int nrow, ncol, count;

		ArrayList<Point> isDust = new ArrayList<>();

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (area[i][j] >= 5)
					isDust.add(new Point(i, j, area[i][j]));
			}
		}

		Iterator<Point> p = isDust.iterator();

		while (p.hasNext()) {

			Point point = p.next();

			int i = point.x;
			int j = point.y;
			int value = point.val / 5;

			count = 0;

			for (int k = 0; k < 4; k++) {

				nrow = i + dr[k];
				ncol = j + dc[k];

				if (area[nrow][ncol] == -1)
					continue;

				count++;
				area[nrow][ncol] += value;
			}

			area[i][j] -= (count * value);

		}

	}

	
	public static void push() {
		
		int arow = ccw.x;	int brow = cw.x;
		int acol = ccw.y;	int bcol = cw.y;

		//#1
		for(int i=C+1;i>=acol+2;i--)
			area[arow][i]=area[arow][i-1];
		area[arow][acol+1]=0;

		//#2
		for(int i=0;i<=arow-2;i++)
			area[i][C]=area[i+1][C];
		area[arow-1][C]=area[arow][C+1];
	
		//#3
		for(int i=0;i<=C-1;i++)
			area[1][i]=area[1][i+1];
		area[1][C-1]=area[0][C];
		
		//#4
		for(int i=arow-1;i>=2;i--)
			area[i][1]=area[i-1][1];
		area[2][1]=area[1][0];
			
		
		//#1
		for(int i=C+1;i>=bcol+2;i--)
			area[brow][i]=area[brow][i-1];
		area[brow][bcol+1]=0;
		
		//#2
		for(int i=R+1;i>=brow+1;i--)
			area[i][C]=area[i-1][C];
		area[brow+1][C]=area[brow][C+1];
		
		//#3
		for(int i=0;i<C;i++)
			area[R][i]=area[R][i+1];
		area[R][C-1]=area[R+1][C];
		
		
		//#4
		for(int i=brow+1;i<=R-1;i++)
			area[i][1]=area[i+1][1];
		area[R-1][1]=area[R][0];
		
		
	}
	
	public static int count() {
		int sum=0;
		for (int i = 1; i <= R; i++)
			for (int j = 1; j <= C; j++)
				if(area[i][j]>0)
				sum+=area[i][j];
			return sum;
	}


	public static void init() {

		for (int i = 0; i < R + 2; i++) {
			area[i][0] = -1;
			area[i][C + 1] = -1;
		}
		for (int j = 0; j < C + 2; j++) {
			area[0][j] = -1;
			area[R + 1][j] = -1;
		}
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int num = 0;
		int answer = 0;
		boolean check = false;

		area = new int[R + 2][C + 2];

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				num = Integer.parseInt(st.nextToken());
				area[i][j] = num;
				if (num == -1) {
					if (!check) {
						ccw = new Point(i, j);
						check = true;
					} else {
						cw = new Point(i, j);
					}
				}
			}
		}

		while(T-->0) {
		init();
		dust();
		push();
		}

		answer+=count();
		System.out.println(answer);
	}

}
