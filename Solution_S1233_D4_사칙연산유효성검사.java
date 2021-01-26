import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1233_D4_사칙연산유효성검사 {

	public static boolean isNumber(String node) {
		if(node.equals("*")||node.equals("+")||node.equals("-")||node.equals("/"))
			return false;
		else
			return true;
		
	}
	public static int leaf(int N) {
		int num = 0;
		for(int i=1;i<=8;i++) {
			if(Math.pow(2, i)>N) {
				num=i-1;
				break;
			}
		}
		int k = N - (int)Math.pow(2, num) + 1;
		int z = (int)Math.pow(2, num-1) - (k+1)/2;
		return (k+z);
		
	}
	public static void main(String[] args) throws IOException{
  	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i=1;i<=10;i++) {
			int N = Integer.parseInt(br.readLine());
			int leafN = N - leaf(N);
			int answer = 1;
			for(int n=0;n<N;n++) {
					String node = br.readLine().split(" ")[1];;
					// 말단노드가 아닐경우
					if(n<leafN) {
						if(isNumber(node))
							answer = 0;
					}
					// 말단노드일 경우
					else {
						if(!isNumber(node))
							answer = 0;
					}
				
			}
			// 노드 개수가 1, 짝수이면 불가능
			if(N==1||N%2==0)
				answer = 0;
			System.out.println("#"+i+" "+answer);
		}

	}

}
