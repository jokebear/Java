import java.util.Scanner;

public class Main_B_10775_공항 {
	// https://www.acmicpc.net/problem/10775
  // 큰숫자부터 방문체크
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		int P = sc.nextInt();
		int answer = 0;
		boolean[] visit = new boolean[G];
		boolean isDocking;
		for(int i=0;i<P;i++) {
			isDocking = false;
			int gi = sc.nextInt();
			for(int g=gi-1;g>=0;g--) {
				if(!visit[g]) {
					visit[g]=true;
					isDocking=true;
					answer++;
					break;
				}
			}
			if(!isDocking)
				break;
			
		}
		System.out.println(answer);
	}

}
