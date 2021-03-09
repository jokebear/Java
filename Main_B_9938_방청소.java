import java.util.Scanner;

public class Main_B_9938_방청소 {
	static int[] parent = new int[300001];
	static boolean[] visited = new boolean[300001];
	static StringBuilder sb = new StringBuilder();

	public static void union(int a, int b) {
	    a = find(a);
	    b = find(b);
	    parent[a] = b;
	    sb.append("LADICA\n");
	}
	 
	public static int find(int u) {
	    if (u == parent[u]) {
	        return u;
	    }
	    return parent[u] = find(parent[u]);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int l = sc.nextInt();
	 
	    for (int i = 1; i <= l; i++) {
	        parent[i] = i;
	    }
	 
	    for (int i = 1; i <= n; i++) {
	        int a = sc.nextInt();
	        int b = sc.nextInt();
	        /* 1. 서랍 Ai가 비어있다면, i번 술을 그 서랍에 보관한다.*/
	        if (!visited[a]) {
	            visited[a] = true;
	            union(a, b);
	        /* 2. 서랍 Bi가 비어있다면, i번 술을 그 서랍에 보관한다.*/
	        } else if (!visited[b]) {
	            visited[b] = true;
	            union(b, a);
	        /* 3. Ai에 들어있는 술을 다른 서랍으로 이동시킨다.(다른 서랍은 Ai에 들어있는 술이 들어갈 수 있는 서랍 중 하나이다) 
	              만약, 그 서랍에도 이미 술이 들어있다면, 그 술을 다른 서랍으로 이동시킨다. 이런 과정을 거쳐서 빈 서랍을 하나 찾아 술을 모두 이동할 수 있는 경우에는,
	              술을 이동시키고 i번 술을 Ai에 보관한다. 불가능한 경우에는 다음 규칙으로 넘어간다.*/
	        } else if (!visited[find(parent[a])]) {
	            visited[find(parent[a])] = true;
	            union(a, b);
	        /* 4. Bi에 들어있는 술을 다른 서랍으로 이동시킨다.
	              만약, 그 서랍에도 이미 술이 들어있다면, 그 술을 다른 서랍으로 이동시킨다. 이런 과정을 거쳐서 빈 서랍을 하나 찾아 술을 모두 이동할 수 있는 경우에는,
	              술을 이동시키고 i번 술을 Bi에 보관한다. 불가능한 경우에는 다음 규칙으로 넘어간다.*/
	        } else if (!visited[find(parent[b])]) {
	            visited[find(parent[b])] = true;
	            union(b, a);
	        /* 위의 과정이 모두 불가능한 경우에는 i번 술을 그 자리에서 마셔버린다. (은기는 전혀 취하지 않는다)*/
	        } else {
	            sb.append("SMECE\n");
	        }
	    }
	    System.out.println(sb.toString());

	}

}
