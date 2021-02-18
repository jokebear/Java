import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Programmers_42579_베스트앨범 {
    
	// 해시맵에 array of arraylist의 인덱스를 저장하여 사용
	// 장르에 해당하는 인덱스를 가진 리스트를 찾아서 재생횟수와 고유번호를 저장
	
	public static int[] solution(String[] genres, int[] plays) {
       
        // 1. key: 장르 value : 재생횟수
    	HashMap<Integer,Integer> play = new HashMap<>();    	
        
        for(int i=0;i<plays.length;i++) {
        	int key = genres[i].hashCode();
        	if(play.containsKey(key)) {
        		play.put(key,play.get(key)+plays[i]);
        	}else {
        		play.put(key, plays[i]);
        	}
        }
        // 2. 재생횟수 기준 오름차순 정렬
        List<Integer> keySetList = new ArrayList<>(play.keySet());
        Collections.sort(keySetList, (o1, o2) -> (play.get(o2).compareTo(play.get(o1))));
        int count = 0;
    	// 3. key: 장르 value : 재생횟수&고유번호 를 저장할 리스트의 인덱스
       	HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer key : keySetList) {
			map.put(key, count++);
		}
        ArrayList<int[]>[] list = new ArrayList[play.size()];
        for(int i=0;i<play.size();i++) {
        	list[i] = new ArrayList<>();
        }
        // 4. 리스트에 재생횟수&고유번호 저장
        for(int i=0;i<plays.length;i++) {
        	int key = genres[i].hashCode();
        	list[map.get(key)].add(new int[] {plays[i],i});
        }   
        // 5. 재생횟수, 고유번호 기준 정렬하여 최대 두개 result 리스트에 저장
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<play.size();i++) {
        	list[i].sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                	   if(a[0]==b[0])
                		     return a[1]-b[1];
                	   else if (a[0] < b[0])
                             return 1;
                       else
                             return -1;
                }
        	});
        	int limit = 0;
        	for(int[] arr : list[i]) {
    			if(limit++==2)
    				break;
    			result.add(arr[1]);
    		}
        }
        // 6. 배열에 담음
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size();i++)
        	answer[i]=result.get(i);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/42579
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500,600,500,500,2500};
		solution(genres,plays);
	}

}
