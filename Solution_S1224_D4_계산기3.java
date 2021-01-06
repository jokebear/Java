import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_S1224_D4_계산기3 {

	static Stack<Character> stack;
	static Queue<Character> result;

	static Stack<Integer> stack2;
	static int answer;

	public static int icp(char c) {
		int pri = 0;
		switch (c) {
		case '+':
		case '-':
			pri = 1;
			break;
		case '*':
		case '/':
			pri = 2;
			break;
		case '(':
			pri = 3;
			break;
		}
		return pri;
	}

	public static int isp(char c) {
		int pri = 0;
		switch (c) {
		case '+':
		case '-':
			pri = 1;
			break;
		case '*':
		case '/':
			pri = 2;
			break;
		case '(':
			pri = 0;
			break;
		}
		return pri;
	}

	public static void calculate(int num1, char token, int num2) {
		int answer = 0;
		switch (token) {
		case '+':
			answer = num1 + num2;
			break;
		case '*':
			answer = num1 * num2;
			break;
		case '-':
			answer = num1 - num2;
			break;
		case '/':
			answer = num1 / num2;
			break;
		}
		stack2.push(answer);
	}

	public static void cal(char token) {

		switch (token) {
		case '+':
		case '*':
		case '-':
		case '/':
			int num2 = stack2.pop();
			int num1 = stack2.pop();
			calculate(num1, token, num2);
			break;

		default:
			stack2.push(Character.getNumericValue(token));
			break;

		}

	}


	public static void init(char token) {
		
		switch(token) {
		case '(':
		case '+':
		case '-':
		case '*':
		case '/':
			if(stack.isEmpty())
				stack.push(token);
			else {
				if(icp(token)>isp(stack.peek())) {
					stack.push(token);
				}else {
				while(isp(stack.peek())>=icp(token)) {
					result.add(stack.pop());
				}
				stack.push(token);
				}
			}
			break;
		case ')':
			while(stack.peek()!='(') {
				result.add(stack.pop());
			}
			stack.pop();
			break;
		default:
			result.add(token);
			break;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			stack = new Stack<>();
			stack2 = new Stack<>();
			result = new LinkedList<>();
			int length = Integer.parseInt(br.readLine());

			answer = 0;
			String str = br.readLine();

			for (int k = 0; k < length; k++)
				init(str.charAt(k));

			
			while (!result.isEmpty())
				cal(result.poll());

			System.out.println("#" + i + " " + stack2.pop());
		}

	}

}
