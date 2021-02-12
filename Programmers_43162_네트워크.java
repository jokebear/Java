public class Programmers_43162_네트워크 {
	
	// dfs 사용
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++) {
        	if(!visit[i]) {
        		dfs(i,computers,visit);
        		answer++;
        	}
        }
        return answer;
    }
    public static void dfs(int n, int[][]computers,boolean[] visit) {
    	visit[n]=true;
    	for(int i=0;i<computers.length;i++) {
    		if(!visit[i]&&computers[n][i]==1)
    			dfs(i,computers,visit);
    	}
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/43162
		int n = 3;
		int[][] computers = {{1,1,1},{1,1,1},{1,1,1}};
		System.out.println(solution(n,computers));
	}

}
