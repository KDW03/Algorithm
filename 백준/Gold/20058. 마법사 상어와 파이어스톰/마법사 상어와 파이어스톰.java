import java.io.*;
import java.util.*;


public class Main {
	
	static int[] moveX = {0,0,-1,1};
	static int[] moveY = {1,-1,0,0};

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int z = (int) (Math.pow(2, n));
		int[][] board = new int[z][z];
		
		
		for(int x = 0 ; x < z ; x++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int y = 0 ; y < z ; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) {
			int l = Integer.parseInt(st.nextToken());
			// 2^l 만큼 나눈다음 시계 방향으로 90도 돌리기
			int c = (int) Math.pow(2, l);
			recursive(z,c,0,0,board);
			downOne(board);
		}
		
		int max = 0;
		boolean [][] visited = new boolean[z][z];
		for(int x = 0 ; x < z ; x++) {
			for(int y = 0 ; y < z ; y++) {
				if(visited[x][y] || board[x][y] <= 0) continue;
				max = Math.max(dfs(x,y,board,visited),max);
			}
		}
		System.out.println(sum);
		System.out.println(max);
		
	}
	
	static int sum = 0;

	
	static int dfs(int x, int y, int[][] board, boolean[][] visited) {
		int count = 1;
		visited[x][y] = true;
		sum += board[x][y];
		for(int d = 0 ; d < moveX.length ; d++) {
			int nx = x + moveX[d];
			int ny = y + moveY[d];
			if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] <= 0 || visited[nx][ny]) continue;
			count += dfs(nx,ny,board,visited);
		}
		return count;
	}
	
	static void downOne(int[][] board) {
		
		
		int[][] tmp = new int[board.length][board.length];
		for(int x = 0 ; x < board.length; x++) tmp[x] = board[x].clone();
		
		for(int x = 0 ; x < board.length; x++) {
			for(int y = 0; y < board[0].length; y++) {
				int count = 0;
				for(int d = 0 ; d < moveX.length; d++) {
					int nx = x + moveX[d];
					int ny = y + moveY[d];
					if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || tmp[nx][ny] <= 0) continue;
					count++;
				}
				if(count <= 2) board[x][y] = Math.max(0, board[x][y] - 1);
			}
		}
	}
	
	
	static void recursive(int z , int c, int startX, int startY, int[][] board) {
		
		
		if(z == c) {
			clockWise90(c,startX,startY,board);
			return;
		}
		
		int newZ = z / 2;
		recursive(newZ, c, startX, startY, board);
		recursive(newZ, c, startX + newZ, startY ,board);
		recursive(newZ, c, startX, startY + newZ ,board);
		recursive(newZ, c, startX + newZ, startY + newZ ,board);
	}
	
	
	static void clockWise90(int c, int startX, int startY, int[][] board) {
	    int endX = startX + c - 1;
	    int endY = startY + c - 1;

	    for (int i = 0; i < c / 2; i++) {
	        for (int j = i; j < c - i - 1; j++) {
	            int temp = board[startX + i][startY + j];
	            board[startX + i][startY + j] = board[endX - j][startY + i];
	            board[endX - j][startY + i] = board[endX - i][endY - j];
	            board[endX - i][endY - j] = board[startX + j][endY - i];
	            board[startX + j][endY - i] = temp;
	        }
	    }
	}
	
}