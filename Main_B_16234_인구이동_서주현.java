import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_16234_인구이동_서주현 {

	static int N;
	static int L;
	static int R;
	static int answer = 0;
	static int arr[][];
	static boolean visit[][];

	static Queue<Point> queue = new LinkedList<>();
	static ArrayList<ArrayList<Point>> divideAP;

	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static class Point {
		int row;
		int col;
		int value;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
			this.value = arr[row][col];
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	private static void divide() {

		int sum, avg;

		for (int i = 0; i < divideAP.size(); i++) {
			ArrayList<Point> AP = divideAP.get(i);

			sum = 0;
			for (int k = 0; k < AP.size(); k++)
				sum += (AP.get(k).value);
			avg = sum / AP.size();

			for (int k = 0; k < AP.size(); k++)
				arr[AP.get(k).row][AP.get(k).col] = avg;

		}
	}

	private static void add(int i, int j) {

		int row, col, value, nrow, ncol, diff;
		ArrayList<Point> ap = new ArrayList<>();

		queue.add(new Point(i, j));

		while (!queue.isEmpty()) {

			Point p = queue.poll();
			row = p.row;
			col = p.col;
			value = p.value;
			visit[row][col] = true;
			ap.add(new Point(row, col));

			for (int k = 0; k < 4; k++) {

				nrow = row + dr[k];
				ncol = col + dc[k];

				if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= N)
					continue;

				if (visit[nrow][ncol])
					continue;

				diff = Math.abs(arr[nrow][ncol] - value);
				if (diff < L || diff > R)
					continue;

				queue.add(new Point(nrow, ncol));
				visit[nrow][ncol] = true;
			}
		}

		if (ap.size() > 1)
			divideAP.add(ap);

	}

	private static void find() {

		while (true) {
			visit = new boolean[N][N];
			divideAP = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;
					add(i, j);
				}
			}
			if (divideAP.isEmpty())
				break;

			divide();
			answer++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		find();
		System.out.println(answer);
	}

}
