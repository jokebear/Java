
public class Programmers_42860_조이스틱 {
    public static int solution(String name) {
        int answer = 0;
        int min_move = name.length()-1;
       
        for(int i=0;i<name.length();i++) {
        	 // 상하
        	answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
      
        	int next = i+1;
        	//내 다음이 A라면 계속 NEXT++
        	while(next<name.length() && name.charAt(next) == 'A')
        		next++;
        	
        	min_move = Math.min(min_move, i+name.length()-next + i);
        }
 
        answer += min_move;
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "JEROEN";
		System.out.println(solution(name));
	}

}
