import java.util.Scanner;

public class Solution_S1493_D3_수의새로운연산 {
	static int[][] array = new int[300][300];
	
	public static int[] find(int num) {
		for(int i=1;i<300;i++) 
			for(int j=1;j<300;j++) 
				if(array[i][j]==num) 
					return new int[] {i,j};
		return null;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<300;i++) 
			for(int j=0;j<300;j++) 
				array[i][j] = (i*i+i+(2*i-2+j)*(j-1))/2;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int[] p_arr = find(p);
			int[] q_arr = find(q);
			int x = p_arr[0]+q_arr[0];
			int y = p_arr[1]+q_arr[1];
			int answer = array[x][y];
			System.out.println("#"+t+" "+answer);
		}
		
		
	}

}
