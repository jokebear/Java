import java.util.ArrayList;

// Array of ArrayList & dp, 계산해서 0이 될 경우 dp에 저장 X
// A&B = (A>=B), A와 B의 사칙연산
// a[1] = 5
// a[2] = 55, a[1]&a[1] 
// a[3] = 555, a[1]&a[2]
// a[4] = 5555, a[1]&a[3] a[2]&a[2]
// a[5] = 55555, a[1]&a[4] a[2]&a[3] 
// a[n] = 5*(pow(10,n-1))+a[n-1], a[1]&a[n-1],  . . . . . , a[n/2]&a[n-n/2]

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Integer>[] dp = new ArrayList[9]; 
        
        for (int i = 1; i < 9; i++) {
            dp[i] = new ArrayList<Integer>();
            if(i==1)
            	dp[i].add(N);
            else
            	dp[i].add(N*(int)Math.pow(10, i-1)+dp[i-1].get(0));
           
            if(dp[i].get(0)==number)
            	return i;
        }
        
        ArrayList<Integer> left = null;
        ArrayList<Integer> right = null;
        int a,b,add,min,div,mul;
        
        for (int i = 2; i<9;i++) {
        	
        	for(int j=1;j<=(i/2);j++) {
        		
        		left = dp[j];
        		right = dp[i-j];
        		
        		for(int l = 0;l<left.size();l++) {
        			for(int r = 0;r<right.size();r++) {
        				a = Math.max(left.get(l),right.get(r));
        				b = Math.min(left.get(l),right.get(r));
        				add = a+b;
        				min = a-b;
        				div = a/b;
        				mul = a*b;
        				if(add==number||min==number||div==number||mul==number)
        					return i;
        				else {
        					if(min!=0)
        						dp[i].add(min);
        					dp[i].add(add);
        					dp[i].add(div);
        					dp[i].add(mul);
        				}
        			}
        		}
        		
        	}

        }
        
        return answer==0?-1:answer;
    }
}

public class Programmers_42895_N으로표현 {
	// https://programmers.co.kr/learn/courses/30/lessons/42895

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(5,12));  // 4
		System.out.println(s.solution(2,11));  // 3
		
	}

}
