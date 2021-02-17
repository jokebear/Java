import java.util.Arrays;

public class Programmers_42885_구명보트 {
	// 오름차순 정렬
	// 앞 사람 : i 뒷 사람 : j
	// 뒷사람이 앞사람과 같이 못탈 경우 보트+1
	// 같이 탈 수 있을경우 앞사람 인덱스 +1 보트+1
    public static int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        int answer = 0;
        int i=0;
        for(int j=people.length-1;j>=i;j--) {
        	if(people[i]+people[j]>limit)
        		answer++;
        	else {
        		i++;
        		answer++;
        	}
        }
        
        
        return answer;
    }
    
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42885 , GREEDY
		System.out.println(solution(new int[] {70,50,80,50},100));
	}

}
