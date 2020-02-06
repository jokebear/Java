import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_16236_아기상어_서주현 {

	static int dr[] = { -1, 0, 0, 1 };
	static int dc[] = { 0, -1, 1, 0 };
	static boolean visit[][];

	static int N;
	static int fish[][];
	static int time = 0;
	static Shark shark;

	public static class Point implements Comparable<Point> {

		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point p) {
			
			/* sort by row */
			if (this.x < p.x) return -1;
			else if (this.x > p.x) return 1;
			
			/* sort by col */
			else {
				if (this.y < p.y) return -1;
				else if (this.y > p.y) return 1;
				else return 0;
			}
		}

	}

	public static class Shark {

		int row;
		int col;
		int size;
		int count;

		Shark(int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
			this.count = 0;
		}

		public void move(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public void eat() {
			this.count++;
			if (count == size) {
				this.count = 0;
				this.size++;
			}
		}

	}

	public static boolean Help() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (fish[i][j] < shark.size && fish[i][j] != 0)
					return false;

		return true;
	}

	public static void start() {
		
		int row, col, nrow, ncol, nfish, time_temp;
		Queue<Point> queue;
		boolean canEat = true;
		
		while (!Help() && canEat) {

			visit = new boolean[N][N];
			time_temp = 0;
			canEat = false;

			queue = new LinkedList<>();
			queue.add(new Point(shark.row, shark.col));
			visit[shark.row][shark.col] = true;
			
			ArrayList<Point> arr = new ArrayList<>();
			
			while (!queue.isEmpty() && !canEat) {

				time_temp++;
				int depth = queue.size();

				for (int k = 0; k < depth; k++) {

					Point p = queue.poll();
					row = p.x;
					col = p.y;

					for (int i = 0; i < 4; i++) {

						nrow = row + dr[i];
						ncol = col + dc[i];

						if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= N)
							continue;
						
						if (visit[nrow][ncol])
							continue;

						nfish = fish[nrow][ncol];

						if (nfish > shark.size)
							continue;

						if (nfish < shark.size && nfish > 0) {
							canEat = true;
							arr.add(new Point(nrow, ncol));
							break;
						}

						visit[nrow][ncol] = true;
						queue.offer(new Point(nrow, ncol));
					}

				}

			}
			
			if (canEat) {
				
				Collections.sort(arr);
				nrow = arr.get(0).x;
				ncol = arr.get(0).y;

				time += time_temp;
				shark.eat();
				shark.move(nrow, ncol);
				fish[nrow][ncol] = 0;
				
			}

		}

	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fish = new int[N][N];
		int num;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 9) {
					shark = new Shark(i, j, 2);
					fish[i][j] = 0;
				} else
					fish[i][j] = num;
			}
		}

		start();
		System.out.println(time);

	}



}
