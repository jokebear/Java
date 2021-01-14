import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B_10828_스택 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		int num = Integer.parseInt(br.readLine());
		int n;
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty())
					System.out.println(-1);
				else {
					n= stack.pop();
					System.out.println(n);
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
				break;
			}
		}
	}

}
