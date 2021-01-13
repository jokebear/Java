import java.util.Scanner;

public class Main_B_1912_연속합 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] dp = new int[num];		
		for(int i=0;i<num;i++)
			dp[i] = sc.nextInt();
		
		int max = dp[0];
		for(int i=1;i<num;i++) {
			if (dp[i-1] > 0 && dp[i] + dp[i-1] > 0) {
				dp[i] += dp[i-1];
			} 
			if (max < dp[i]) {
				max = dp[i];
			}

		}
		System.out.println(max);
	}

}
