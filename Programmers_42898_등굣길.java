
public class Programmers_42898_등굣길 {
    
	// 웅덩이 있는곳 -1 초기화
	// 시작 지점과 이동 지점이 웅덩이가 아닐 때, 이동 지점 += 시작 지점 % 1000000007
	
	public static boolean isPuddle(int i,int j,int[][] puddles) {
		for(int[] puddle : puddles)
			if(i==puddle[1]-1&&j==puddle[0]-1)
				return true;
		return false;
	}
	
	public static int solution(int m, int n, int[][] puddles) {

        int[][] board = new int[n][m];
        
        for(int[] puddle : puddles)
        	board[puddle[1]-1][puddle[0]-1] = -1;
        
        board[0][0]=1;
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(isPuddle(i,j,puddles))
        			continue;
        		if(j+1<m&&board[i][j+1]!=-1)
        			board[i][j+1]+=board[i][j]%1000000007;
        		if(i+1<n&&board[i+1][j]!=-1)
        			board[i+1][j]+=board[i][j]%1000000007;
        		
        	}
        }
        
        return board[n-1][m-1]%1000000007;
    }
	public static void main(String[] args) {
		solution(4,3,new int[][]{{2,2}});
	}

}
