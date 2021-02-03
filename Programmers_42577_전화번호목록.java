public class Programmers_42577_전화번호목록 {
	// https://programmers.co.kr/learn/courses/30/lessons/42577
	// String 일치하는지 확인할때 hashCode 사용 
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
       
        for(int i=0;i<phone_book.length-1;i++) {
        	int hash = phone_book[i].hashCode();
        	int i_len = phone_book[i].length();
        	for(int j=i+1;j<phone_book.length;j++) {
        		int j_len = phone_book[j].length();
        		if(j_len>=i_len&&phone_book[j].substring(0,i_len).hashCode()==hash) {
        			return false;
        		}else if(j_len<i_len&&phone_book[i].substring(0,j_len).hashCode()==phone_book[j].hashCode()) {
        			return false;
        		}
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235"};
		System.out.println(solution(phone_book));

	}

}
