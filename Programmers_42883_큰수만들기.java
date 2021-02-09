public class Programmers_42883_큰수만들기 {
	// stringbuilder 사용, 반복문에서 k+i개수 내에서 최대값 찾으면 인덱스를 그 위치로 갱신
    public static String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0')
        	return "0";
        
        for(int i = 0; i < number.length() - k; i++) {
        	max = '0';
        	for(int j = idx; j <= k + i; j++) {
	        	if(max < number.charAt(j)) {
	        		max = number.charAt(j);
	        		idx = j + 1;
	        	}
			}			
			answer.append(max);
        }
        return answer.toString();
    }
	public static void main(String[] args) {
		System.out.println(solution("4177252841",4));

	}

}
