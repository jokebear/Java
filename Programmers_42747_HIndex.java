import java.util.Arrays;

public class Programmers_42747_HIndex {
	// 완탐 그자체
    public static int solution(int[] citations) {
        int answer = 0;
        int count;
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        
        for(int h=max;h>=0;h--) {
        	count = 0;
        	for(int i=0;i<citations.length;i++) {
        		if(citations[i]>=h)
        			count++;
        	}
        	if(count>=h && citations.length-count<=h) {
        		answer = h;
        		break;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42747
		int[] citations = {3,0,6,1,5};
		System.out.println(solution(citations)); //3
		
	}

}
