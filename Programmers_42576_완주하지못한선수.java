import java.util.HashMap;
import java.util.Iterator;

public class Programmers_42576_완주하지못한선수 {
	
	 // https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
	 public static String solution(String[] participant, String[] completion) {
	    	String answer = "";
		 	HashMap<String,Integer> map = new HashMap();
	    
	    	for(String part : participant){
	    		Integer integer = map.getOrDefault(part, 0);
	    		map.put(part, ++integer);	
	    	}
	    	for(String comp : completion) {
	    		Integer integer = map.get(comp);
	    		if(integer==null) {
	    			answer = comp;
	    			break;
	    		} 
	    		else if(integer>1) 
	    			map.put(comp, --integer);
	    		else 
	    			map.remove(comp);
	    	}
	    	
	    	if(!map.isEmpty())
	    		answer =  map.keySet().iterator().next();
	    	return answer;
	    	
	}
	
	public static void main(String[] args) {
		String[] participant = {"leo","kiki","eden","leo"};
		String[] completion = {"eden","kiki","leo"};
		System.out.println(solution(participant,completion));

	}

}
