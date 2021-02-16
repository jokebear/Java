import java.util.Arrays;

public class Programmers_42842_카펫 {
    public static int[] solution(int brown, int yellow) {
        
    	// brown+yellow 를 만들 수 있는 가로길이와 세로길이를 구한 뒤에
    	// 그 길이로부터 brown 개수의 격자를 만들 수 있을 경우 리턴
        
    	int all = brown+yellow;
        int max = (int)Math.sqrt(all);
        for(int r=3;r<=max;r++) {
        	if(all%r==0&&r<=all/r) {
        		int c = all/r;
        		if(2*(r+c)-4==brown)
        			return new int[] {c,r};
        	}
        }
        
        return null;
    
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42842
		System.out.println(Arrays.toString(solution(24,24)));
		
	}

}
