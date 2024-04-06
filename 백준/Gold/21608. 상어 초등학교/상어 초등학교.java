import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int nearFavorite;
	int nearEmpty;
	
	Point(int x, int y, int nearFavorite, int nearEmpty) {
		this.x = x;
		this.y = y;
		this.nearFavorite = nearFavorite;
		this.nearEmpty = nearEmpty;
	}
	

}


public class Main {
	
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] board = new int[n][n];
		
		Comparator<Point> customComparator = (p1, p2) -> {
		    // 1. 주위 좋아하는 수가 많은 순서대로 정렬합니다. (내림차순)
		    int compareFavorite = Integer.compare(p2.nearFavorite, p1.nearFavorite);
		    if (compareFavorite != 0) {
		        return compareFavorite;
		    }

		    // 2. 좋아하는 수가 같다면, 주위 빈 칸의 수로 정렬합니다. (내림차순)
		    int compareEmpty = Integer.compare(p2.nearEmpty, p1.nearEmpty);
		    if (compareEmpty != 0) {
		        return compareEmpty;
		    }

		    // 3. 빈 칸의 수도 같다면, x 좌표가 작은 순서대로 정렬합니다. (오름차순)
		    int compareX = Integer.compare(p1.x, p2.x);
		    if (compareX != 0) {
		        return compareX;
		    }

		    // 4. x 좌표가 같다면, y 좌표가 작은 순서대로 정렬합니다. (오름차순)
		    return Integer.compare(p1.y, p2.y);
		};


		HashSet<Integer>[] fArr = new HashSet[n*n];
		
		for(int i = 0 ; i < n * n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			HashSet<Integer> favoSet = new HashSet();
			
			while(st.hasMoreTokens()) {
				int favorite = Integer.parseInt(st.nextToken());
				favoSet.add(favorite);
			}
			
			fArr[num - 1] = favoSet;
			
			// 좋아 하는 사람 가장 많이 인접
			// 인접하는 칸 여러개 1 여러개
			PriorityQueue<Point> pq = new PriorityQueue(customComparator);
			for(int x = 0 ; x < n ; x++) {
				for(int y = 0 ; y < n ; y++) {
					if(board[x][y] != 0) continue;
					int nearEmpty = 0;
					int nearFavorite = 0;
					
					for(int dir = 0 ; dir < 4 ; dir++) {
						int nx = x + moveX[dir];
						int ny = y + moveY[dir];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
						
						int value = board[nx][ny];
						if(value == 0) nearEmpty++;
						else if(favoSet.contains(value)) nearFavorite++;
					}
					Point p = new Point(x, y, nearFavorite, nearEmpty);
					pq.add(p);
				}
			}
			
		
			Point p = pq.poll();
			board[p.x][p.y] = num;
		}
		
		int answer = 0;
		
		for(int x = 0 ; x < n ; x++) {
			for(int y = 0 ; y < n ; y++) {
				int num = board[x][y];
				int count = 0;
				HashSet<Integer> favoSet = fArr[num - 1];
				for(int dir = 0 ; dir < 4; dir++) {
					int nx = x + moveX[dir];
					int ny = y + moveY[dir];
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
					
					int nNum = board[nx][ny];
					// 포함한다면
					if(favoSet.contains(nNum)) count++;
				}
				
				if(count <= 1) {
					answer += count;
				}
				if(count == 2) answer += 10;
				if(count == 3) answer += 100;
				if(count == 4) answer += 1000;
			}
		}
		
	
		System.out.println(answer);
	}
}