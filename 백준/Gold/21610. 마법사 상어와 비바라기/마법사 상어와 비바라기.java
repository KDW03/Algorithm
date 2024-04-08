import java.io.*;
import java.util.*;

class Point {
	int x = 0;
	int y = 0;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Point point = (Point) obj;
	    return x == point.x && y == point.y;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(x, y);
	}

}

public class Main {
	
	static int[] moveX = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// n x n
		int n = Integer.parseInt(st.nextToken());
		
		// 구름 이동 정보 수
		int m = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][n];
		
		// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
		
		
		for(int x = 0 ; x < n ; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0 ; y < n ; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Point> cloudPoints = new ArrayList();
		cloudPoints.add(new Point(n - 1,0)); 
		cloudPoints.add(new Point(n - 2,0));
		cloudPoints.add(new Point(n - 1,1));
		cloudPoints.add(new Point(n - 2,1));
		
		
		// 구름 정보
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			ArrayList<Point> newCloudPoints = move(n,d,s,cloudPoints);
			inCreaseOne(board,newCloudPoints);
			waterCopyBug(n,board,newCloudPoints);
			makeNewCloud(board,cloudPoints,newCloudPoints);
		}
		
		
		System.out.println(totalWater(board));
	}
	
	static int totalWater(int[][] board) {
		int sum = 0;
		
		
		for(int x = 0 ; x < board.length; x++) {
			for(int y = 0 ; y <  board[0].length; y++) {
				sum += board[x][y];
			}
		}
		
		return sum;
	}
	
	
	
	
	static void makeNewCloud(int[][] board, ArrayList<Point> cloudPoints, ArrayList<Point> newCloudPoints) {
		cloudPoints.clear();
		for(int x = 0 ; x < board.length ; x++) {
			for(int y = 0 ; y < board[0].length ; y++) {
				Point p = new Point(x,y);
				if(board[x][y] >= 2 && !newCloudPoints.contains(p)) {
					board[x][y] -= 2;
					cloudPoints.add(p);
				}
			}
		}
	}
	
	static void waterCopyBug(int n, int[][] board, ArrayList<Point> newCloudPoints) {
		// 대각선 4방향 중 범위내에 있고 물이 1이상인 구간의 수만큼 해당 구간 증가
		// 1 3 5 7
		
		for(Point p : newCloudPoints) {
			int count = 0;
			for(int d = 1 ; d < moveX.length ; d+=2) {
				int nx = p.x + moveX[d];
				int ny = p.y + moveY[d];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] < 1) continue;
				count++;
			}
			
			board[p.x][p.y] += count;
		}
	}
	
	
	static void inCreaseOne(int[][] board, ArrayList<Point> newCloudPoints) {
		for(Point p : newCloudPoints) board[p.x][p.y]++;
	}
	
	static ArrayList<Point> move(int n, int d, int s, ArrayList<Point> cloudPoints) {
		
		ArrayList<Point> newCloudsPoints = new ArrayList();
		
		for(Point p : cloudPoints) {
			int nx = p.x + moveX[d] * (s % n);
			int ny = p.y + moveY[d] * (s % n);
			
			if(nx < 0) nx = n + nx;
			if(ny < 0) ny = n + ny;
			if(nx >= n) nx = nx % n;
			if(ny >= n) ny = ny % n;
			
			newCloudsPoints.add(new Point(nx,ny));
		}
		
	
		return newCloudsPoints;
	}
}