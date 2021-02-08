
public class Programmers_43105_정수삼각형 {
	// dp와 적절한 index 계산
	public static int solution(int[][] triangle) {
        int answer = 0;
        int depth = triangle.length;
        int[] dp = new int[depth*depth-1/2];
        answer = dp[0] = triangle[0][0];

        int index = 1;
        for(int i=1;i<depth;i++) {
        	for(int j=0;j<triangle[i].length;j++,index++) {
        		if(index == (i*(i+1))/2)
        			dp[index] = dp[index-i]+triangle[i][j];
        		else if(index == (i*(i+1))/2+i)
        			dp[index] = dp[index-i-1]+triangle[i][j];
        		else
        			dp[index] = Math.max(dp[index-i],dp[index-i-1]) + triangle[i][j];
        	
        		answer = Math.max(answer, dp[index]);
        	}
        	
        }
        return answer;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/43105
		int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(triangle));
	}

}
