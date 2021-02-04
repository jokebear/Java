import java.util.Arrays;

class Solution_체육복 {
	// 소팅한다음 여벌 체육복 가져온 학생이 도난당했을 경우를 먼저 제외시켜줌
	// 반복문 돌려서 빌려줄 수 있을 때 lost의 시작지점을 갱신해주기
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int j_start = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0;i<reserve.length;i++)
        	for(int j=0;j<lost.length;j++)
        		if(reserve[i]==lost[j]) {
        			reserve[i]=0;
        			lost[j]=0;
        			answer++;
        			break;
        		}
        	
        
        for(int i=0;i<reserve.length;i++) {
        	int res = reserve[i];
        	if(reserve[i]==0)
        		continue;
        	for(int j=j_start;j<lost.length;j++) {
        		if(lost[j]!=0&&(res-1==lost[j]||res+1==lost[j])) {
        				j_start=j+1;
        				answer++;
        				break;
        		}
        	}
        }
        answer += n-lost.length;
        return answer;
    }
}

public class Programmers_42862_체육복 {
	// https://programmers.co.kr/learn/courses/30/lessons/42862
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {3};
		Solution_체육복 a = new Solution_체육복();
		System.out.println(a.solution(n,lost,reserve));

	}

}
