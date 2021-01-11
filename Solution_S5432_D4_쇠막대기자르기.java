import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_S5432_D4_쇠막대기자르기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String[] array = new String[tc];
		for(int i=0;i<tc;i++) {
			
			/* result : 잘린 개수
			   check : (,) 여부
			   stack : 입력 저장  */
 			
			array[i] = br.readLine();
			int result=0;
			boolean check = false;
			Stack<Character> stack = new Stack<Character>();
			
			for(int j=0;j<array[i].length();j++) {
				char input = array[i].charAt(j);
				
				switch(input) {
				case '(':
					stack.push(input);
					check = true;
					break;
				case ')':
					stack.pop();
					if(check) 
						result+=stack.size();
					else
						result++;
					check= false;
					break;
				}
			}
			System.out.println("#"+(i+1)+" "+result);
		}
		

	}

}
