import java.util.ArrayList;

public class Programmers_42839_소수찾기 {

	// 1. 숫자 만들기 - for문 & 순열
	// 2. 중복 여부 확인(contains) & 소수 판별
	// 3. 배열리스트에 저장
	
    static boolean[] visit;
    static ArrayList<Integer> answer = new ArrayList<>();
    
	public static int solution(String numbers) {
 
        visit = new boolean[numbers.length()];
        for(int i=1;i<=numbers.length();i++)
        	permutation("",numbers,0,i);
        return answer.size();
    }	
    // 만들 수 있는 숫자 - 순열
    public static void permutation(String number, String numbers, int count, int depth) {
    	
    	if(count == depth) {
    		int num = Integer.parseInt(number);
    		if(!answer.contains(num)&&isPrime(num))
    				answer.add(num);
    		return;
    	}
    	for(int i=0;i<numbers.length();i++) {
    		if(!visit[i]) {
    			visit[i]=true;
    			permutation(number+numbers.substring(i,i+1),numbers,count+1,depth);
    			visit[i]=false;
    		}
    	}
    	
    }
    // 소수 판별 함수
    public static boolean isPrime(int n){
    	
        if (n <= 1) {
            return false;
        }

        int a = (int) Math.sqrt(n);
        for (int j = 2; j <= a; j++) {
            if (n % j == 0) {
               return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42839
    	System.out.println(solution("011"));
	}

}
