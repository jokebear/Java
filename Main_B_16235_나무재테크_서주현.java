import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_B_16235_나무재테크_서주현 {

	public static class Tree implements Comparable<Tree> {		
		int age;

		Tree(int age) {this.age = age;}

		@Override
		public int compareTo(Tree tree) {
			if (this.age < tree.age) return -1;
			else if (this.age > tree.age) return 1;
			else return 0;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int A[][] = new int[N+1][N+1];
		int food[][] = new int[N+1][N+1];
		ArrayList<Tree>[][] land = new ArrayList[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int value = Integer.parseInt(st.nextToken());

				A[i][j] = value;
				food[i][j] = 5;
				land[i][j] = new ArrayList<Tree>();
			}
		}

		for (int m = 0; m < M; m++) {
			
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int treeage = Integer.parseInt(st.nextToken());

			land[row][col].add(new Tree(treeage));
		}

		
		
		int age,deleteindex;
		
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		
		while (K-- > 0) {

			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					
					if(land[i][j].isEmpty())
						continue;
					
					Collections.sort(land[i][j]);
					deleteindex = Integer.MAX_VALUE;
					
					/* Spring */
					for (int k = 0; k < land[i][j].size(); k++) {
						age = land[i][j].get(k).age;
						if (age > food[i][j]) {
							deleteindex = k;
							break; 
						}
						food[i][j] -= age;
						land[i][j].get(k).age+=1;
						
					}
					/* Summer */
					for (int k = land[i][j].size() - 1; k >= deleteindex; k--) {
						food[i][j] += (land[i][j].get(k).age / 2);
						land[i][j].remove(k);

					}
			
					
				}
			
			/* Fall */
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++) {
					for (int k = 0; k < land[i][j].size(); k++) {
						if (land[i][j].get(k).age % 5 == 0) {

							for (int t = 0; t < 8; t++) {
								int nr = i + dr[t];
								int nc = j + dc[t];

								if (nr < 1 || nc < 1 || nr > N || nc > N)
									continue;
								land[nr][nc].add(new Tree(1));

							}
						}
					}
				}
			
			/* Winter */
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					food[i][j] += A[i][j];
		}

		int answer =0;
		for (int i = 1; i <= N; i++) 
			for (int j = 1; j <= N; j++) 
				answer += land[i][j].size();
	
		System.out.println(answer);

	}

}


