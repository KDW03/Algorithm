import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Person {
	int num;
	int depth;
	
	Person(int num, int depth) {
		this.num = num;
		this.depth = depth;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		boolean[][] graph = new boolean[n][n];
		Person start = new Person(0,0);
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph[a][b] = true;
			graph[b][a] = true;
		}

		Queue<Person> q = new LinkedList<Person>();
		q.add(start);
		boolean[] visited = new boolean[n]; 
		visited[start.num] = true;
		
		int count = 0;
		while(!q.isEmpty()) {
			Person p = q.poll();
			int depth = p.depth;
			int num = p.num;
			int newDepth = depth + 1;
			if(newDepth > 2) break;
			
			for(int i = 0 ; i < n ; i++) {
				if(graph[p.num][i] && !visited[i]) {
					visited[i] = true;
					count++;
					q.add(new Person(i,depth + 1));
				}
			}	
		}
		System.out.println(count);
	}
}