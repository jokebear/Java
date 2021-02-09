import java.util.ArrayList;
import java.util.List;

public class Programmers_42840_모의고사 {
	// 완탐, 수포자 방법 배열에 담고 정답수 체크
	 public static int[] solution(int[] answers) {
	        
	        int[][] student = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
	        int[] count = new int[3];
	        
	        for(int i=0;i<answers.length;i++){
	            for(int s=0;s<3;s++){
	               if(answers[i]==student[s][i%student[s].length])
	                   count[s]++;
	            }
	        }
	        int max = 0;

	        for(int i=0;i<3;i++)
	        	max = Math.max(max, count[i]);
	        
	        List<Integer> arrayList = new ArrayList<>();

	        for(int i=0;i<3;i++)
	        	if(max == count[i])
	        		arrayList.add(i+1);
	        	
	        int[] answer = new int[arrayList.size()];
	        
	        for (int i=0; i < answer.length; i++)
	        	answer[i] = arrayList.get(i).intValue();
	        
	        
	        return answer;
	    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42840
		int[] answers = {1,2,3,4,5};
		int[] answers2 = {1,3,2,4,2};
		solution(answers);
	}

}
