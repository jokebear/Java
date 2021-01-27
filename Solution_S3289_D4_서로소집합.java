import java.util.Arrays;
import java.util.Scanner;

public class Solution_S3289_D4_서로소집합 {
	// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr&categoryId=AWBJKA6qr2oDFAWr&categoryType=CODE
	
	static int[] parents;
	
	public static void init(int num) {
		parents = new int[num+1];
		Arrays.fill(parents, -1);
	}
	
	public static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if(ap!=bp) {
			parents[bp] = ap;
		}
	}
	
	public static int find(int a) {
		if(parents[a]==-1)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		int n,m,a,b,c;
		for(int t=1;t<=test_case;t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			init(n);
			System.out.print("#"+t+" ");
			for(int u=0;u<m;u++) {
				c = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				if(c==0) {
					union(a,b);
				}else {
					if(find(a)==find(b))
						System.out.print(1);
					else
						System.out.print(0);
					
				}
			}
			System.out.println();
		}

	}

}
