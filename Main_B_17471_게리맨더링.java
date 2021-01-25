import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_17471_게리맨더링 {

	static ArrayList<Node> list = new ArrayList<>();
	static ArrayList<Integer> head;
	static ArrayList<Integer> tail;

	static int N;
	static boolean check;
	static boolean[] selected;

	static int answer = Integer.MAX_VALUE;

	public static class Node {

		int people;
		ArrayList<Integer> li;

		Node() {
		}

		Node(int people) {
			this.people = people;
			li = new ArrayList<>();
		}

		public void add(int number) {
			li.add(number);
		}

		public int getPeople() {
			return this.people;
		}

		public boolean isAdj(int number) {

			for (int i = 0; i < li.size(); i++)
				if (li.get(i) == number)
					return true;
			return false;

		}

	}

	public static int cal() {

		int headsum = 0;
		int tailsum = 0;

		for (int i = 0; i < head.size(); i++)
			headsum += list.get(head.get(i)).getPeople();

		for (int i = 0; i < tail.size(); i++)
			tailsum += list.get(tail.get(i)).getPeople();

		return Math.abs(headsum - tailsum);

	}

	public static boolean check() {

		head = new ArrayList<>();
		tail = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (selected[i])
				head.add(i);
			else
				tail.add(i);
		}

		boolean visit1[] = new boolean[head.size()];
		boolean visit2[] = new boolean[tail.size()];

		check = false;
		dfs(0, 0, head, visit1);
		if (!check)
			return false;

		check = false;
		dfs(0, 0, tail, visit2);
		if (!check)
			return false;

		return true;
	}

	public static void dfs(int index, int count, ArrayList<Integer> arr, boolean visit[]) {

		if(check)
			return;
		
		if (count == arr.size() - 1) {
			check = true;
			return;
		}

		visit[index] = true;

		for (int i = 0; i < arr.size(); i++) {

			if (visit[i])
				continue;

			if (!list.get(arr.get(index)).isAdj(arr.get(i)))
				continue;

			dfs(i, count + 1, arr, visit);
			visit[index] = false;

		}

	}

	public static void divide(int index, int count, int r) {

		if (count == r) {
			if (check()) {
				int sum = cal();
				if (sum < answer)
					answer = sum;
			}
			return;
		}

		for (int i = index; i <= N; i++) {

			if (selected[i])
				continue;

			selected[i] = true;
			divide(i, count + 1, r);
			selected[i] = false;

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list.add(new Node());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++)
			list.add(new Node(Integer.parseInt(st.nextToken())));

		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());

			for (int k = 0; k < count; k++)
				list.get(i).add(Integer.parseInt(st.nextToken()));

		}

		selected = new boolean[N + 1];

		for (int r = 1; r <= N / 2; r++)
			divide(1, 0, r);

		if (answer == Integer.MAX_VALUE)
			answer = -1;

		System.out.println(answer);

	}

}
