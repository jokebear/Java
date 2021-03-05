
public class Programmers_49993_스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int pos = 0;
        boolean pass;
        for(String skill_tree : skill_trees) {
        	pass = true;
        	pos = 0;
        	out :for(int i=0;i<skill_tree.length();i++) {
        			if(pos==skill.length())
        				break;
        			if(skill.charAt(pos)==skill_tree.charAt(i)) {
        				pos++;
        				continue;
        			}
	        		for(int p=pos+1;p<skill.length();p++) {
		        			if(skill.charAt(p)==skill_tree.charAt(i)) {
		        				pass = false;
		        				break out;
		        			}
	        		}
        	}
        	if(pass) {
        		pos++;
        		answer++;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		
		String skill="CBD";
		String[] skill_trees = {"BACDE","CBADF","AECB","BDA"};
		String[] sk = {"CBADF"};
		System.out.println(solution(skill,skill_trees));
	}

}
