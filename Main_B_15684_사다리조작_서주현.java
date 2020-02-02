import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_15684_사다리조작_서주현 {

	static int N;
	static int M;
	static int H;
	static int answer = Integer.MAX_VALUE;

	static boolean[][] ladder;

	/* i번 세로선의 결과가 i번이 나오는지 확인한다. */
	public static boolean check() {

		for (int n = 1; n <= N; n++) {
			int col = n;

			for (int h = 1; h <= H; h++) {
				if (ladder[h][col]) {
					col++;
					continue;
				}
				if (ladder[h][col - 1]) {
					col--;
					continue;
				}
			}
			if (col != n)
				return false;
		}

		return true;
	}

	/* 가로선을 추가한다 */
	public static void add(int row,int count) {

		if (count > 3)
			return;

		if (check()) {
			if (answer > count)
				answer = count;
			return;
		}

		for (int i = row; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1])
					continue;
				ladder[i][j] = true;
				add(i,count + 1);
				ladder[i][j] = false;

			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		/* 첫째 줄에 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H가 주어진다. */
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		if (M == 0) {
			System.out.println(0);
			return;
		}

		/* 둘째 줄부터 M개의 줄에는 가로선의 정보가 한 줄에 하나씩 주어진다. */
		ladder = new boolean[H + 2][N + 2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			ladder[row][col] = true;

		}
		add(1,0);

		if (answer <= 3)
			System.out.println(answer);
		else
			System.out.println("-1");
	}

}
