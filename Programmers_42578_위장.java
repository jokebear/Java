import java.util.HashMap;

public class Programmers_42578_위장 {
	// 1. 의상 종류와 개수를 각각 키 밸류로 하여 해시맵에 담는다.
	// 2. 의상 (개수+1) 개를 종류별로 곱한다.
	// 3. 아무것도 안입을 경우 1을 뺀다.
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
       
        for(String[] cloth : clothes) {
        	if(map.containsKey(cloth[1]))
        		map.put(cloth[1], map.get(cloth[1])+1);
        	else
        		map.put(cloth[1], 1);
        }
        // map : {eyewear=1, headgear=2}

        for (int val : map.values()) {
            answer*=(val+1);
        }
        return answer-1;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42578
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
		
		
	}

}
