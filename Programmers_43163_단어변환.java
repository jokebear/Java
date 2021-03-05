
public class Programmers_43163_단어변환 {

	static boolean visit[];
	static int answer;
	
	public static void dfs(String begin, String target, int count, String[] words) {
		
		if(compare(begin,target)==1) {
			answer = Math.min(answer, count);
			return;
		}
		
		for(int i=0;i<words.length;i++) {
			if(!visit[i]&&compare(begin,words[i])==0) {
				visit[i]=true;
				dfs(words[i],target,count+1,words);
				visit[i]=false;
			}
		}
		
	}
	
	// 변환가능:0 목표단어:1 패스:-1
	public static int compare(String str, String str_comp) {
		if(str.equals(str_comp))
			return 1;
		
		int diff = 0;
		for(int i=0;i<str.length();i++) {
			if(!str.substring(i,i+1).equals(str_comp.substring(i,i+1)))
				diff++;
		}
		if(diff==1)
			return 0;
		
		return -1;
	}
    public static int solution(String begin, String target, String[] words) {
        
    	answer = Integer.MAX_VALUE;
        visit = new boolean[words.length];
        dfs(begin,target,0,words);
        if(answer==Integer.MAX_VALUE)
        	answer = 0;
        return answer;
    }
    
    
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		System.out.println(solution(begin,target,words));

	}

}
