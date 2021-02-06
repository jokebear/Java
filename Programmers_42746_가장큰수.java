import java.util.Arrays;
import java.util.Comparator;

public class Programmers_42746_가장큰수 {
    // comparator 사용
    public static String solution(int[] numbers) {
        
    	String answer = "";
        String[] array = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++)
        	array[i] = numbers[i]+"";
        
	    Arrays.sort(array, new Comparator<String>() {
	    	@Override
	    	public int compare(String s1, String s2) {
	    		return (s2+s1).compareTo(s1+s2);
	    	}
	    });
	    
	    for(String s: array)
	    	answer+=s;
	    
	    if (answer.startsWith("0"))
            answer = "0";
        
        return answer;
    }

   
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42746
		int[] numbers = {6,10,2}; //6210
		int[] number2 = {3,30,34,5,9};  // 9534330
		System.out.println(solution(number2));

	}

}
