import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_S1225_D3_암호생성기 {
	public static void main(String[] args)  throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for(int test_case=1;test_case<=10;test_case++) {
			
			Queue<Integer> queue = new LinkedList<>();
			Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 8자리 숫자 큐에 저장
			for(int get=1;get<=8;get++)
				queue.add(Integer.parseInt(st.nextToken()));
			
			int code = 1;
			int num;
	
			// 0이 아닐때까지 숫자 꺼내서 1~5 빼주고 다시 큐에 넣기
			do {
				num = queue.poll();
				num -= code%6;
				if(num<=0) {
					queue.add(0);
					break;
				}else
					queue.add(num);
				if(++code%6==0)
					code++;
				
			} while(true);
			
			// 출력하기
			System.out.print("#"+test_case+" ");
			
			while(!queue.isEmpty())
				System.out.print(queue.poll()+" ");
			
			System.out.println();
		}
		
		
	}
}
