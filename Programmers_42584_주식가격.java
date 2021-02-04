import java.util.Arrays;
import java.util.Stack;

public class Programmers_42584_주식가격 {
	// https://programmers.co.kr/learn/courses/30/lessons/42584
	// 1. 중첩 반복문
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length-1;i++) {
        	int count = 0;
        	for(int j=i+1;j<prices.length;j++) {
        		count++;
        		if(prices[i]>prices[j]) {
        			break;
        		}
        	}
        	answer[i] = count;
        }
        return answer;
    }

    // 2. 스택 사용
    public static int[] solution2(int[] prices) {
    	int[] answer = new int[prices.length];
    	Stack<Integer> stack = new Stack<>();
    
    	for(int i=0; i<prices.length;i++) {
    		 // stack의 top에 해당하는 시간의 주식 가격이 클 경우 pop하고 top 정답을 갱신
    		 while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                 int top = stack.peek();
                 stack.pop();
                 answer[top] = i - top;
             }
             // 현재 주식 가격이 클 경우 초를 저장
             stack.push(i);
    	}
  
        System.out.println(stack);
    	while(!stack.isEmpty()) {
    		int k = stack.pop();
    		answer[k] = prices.length-1-k;
    	}
        return answer;
 
    }
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3,1};
		// st = 0초
		// answer = 5 4 1 2 1 0
		System.out.println(Arrays.toString(solution2(prices)));
		
	}

}
