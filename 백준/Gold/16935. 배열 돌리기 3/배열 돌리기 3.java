import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		
		for(int x = 0 ; x < n ; x++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int y = 0 ; y < m ; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine()," ");
		
		while(st.hasMoreTokens()) {
			int cmd = Integer.parseInt(st.nextToken());
			arr = processCmd(cmd,arr);
		}
		
		printArr(arr);
	}
	
	static void printArr(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int x = 0 ; x < arr.length ; x++) {
			for(int y = 0 ; y < arr[0].length ; y++) {
				sb.append(arr[x][y]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[][] processCmd(int cmd, int[][] arr) {
		if(cmd == 1) arr = cmd1(arr);
		if(cmd == 2) arr = cmd2(arr);
		if(cmd == 3) arr = cmd3(arr);
		if(cmd == 4) arr = cmd4(arr);
		if(cmd == 5) arr = cmd5(arr);
		if(cmd == 6) arr = cmd6(arr);
		return arr;
	}
	
	// 상하반전
	static int[][] cmd1(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		
		for(int x = 0 ; x < n ; x++) {
			for(int y = 0 ; y < m ; y++) {
				tmp[x][y] = arr[n - x - 1][y];
			}
		}
		return tmp;
	}
	
	
	// 좌우 반전
	static int[][] cmd2(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		
		for(int x = 0 ; x < n ; x++) {
			for(int y = 0 ; y < m ; y++) {
				tmp[x][y] = arr[x][m - y - 1];
			}
		}
		
		return tmp;
	}
	
	// 오른쪽 90
	static int[][] cmd3(int[][] arr) {
		int n = arr[0].length;
		int m = arr.length;
		int[][] tmp = new int[n][m];
		
		for(int x = 0 ; x < n ; x++) {
			for(int y = 0 ; y < m ; y++) { 
				tmp[x][y] = arr[m - y - 1][x];
			}
		}		
		
		return tmp;
	}

	static int[][] cmd4(int[][] arr) {
		int n = arr[0].length;
		int m = arr.length;
		int[][] tmp = new int[n][m];
		
		for(int x = 0 ; x < n ; x++) {
			for(int y = 0 ; y < m ; y++) { 
				tmp[x][y] = arr[y][n - x -1];
			}
		}
		
		return tmp;
	} 
	
	static int[][] cmd5(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		
		int dx = n / 2;
		int dy = m / 2;
		
		// 1 -> 2
		for(int x = 0 ; x < dx ; x++) {
			for(int y = 0 ; y < dy ; y++) { 
				tmp[x][dy + y] = arr[x][y];
			}
		}
		

		// 2 -> 3
		for(int x = 0 ; x < dx ; x++) {
			for(int y = m / 2 ; y < m ; y++) { 
				tmp[dx + x][y] = arr[x][y];
			}
		}
		
		// 3 -> 4
		for(int x = dx ; x < n ; x++) {
			for(int y = dy ; y < m ; y++) { 
				tmp[x][y - dy] = arr[x][y];
			}
		}
		
		// 4 -> 1
		for(int x = dx ; x < n ; x++) {
			for(int y = 0 ; y < dy ; y++) { 
				tmp[x - dx][y] = arr[x][y];
			}
		}
		
		
		return tmp;
	} 
	
	
	
	
	static int[][] cmd6(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		
		int dx = n / 2;
		int dy = m / 2;
		
		
		// 1 -> 4
		for(int x = 0 ; x < dx ; x++) {
			for(int y = 0 ; y < dy ; y++) { 
				tmp[x + dx][y] = arr[x][y];
			}
		}
		

		// 4 -> 3
		for(int x = dx ; x < n ; x++) {
			for(int y = 0 ; y < dy ; y++) { 
				tmp[x][y + dy] = arr[x][y];
			}
		}
		
		// 3 -> 2
		for(int x = dx ; x < n ; x++) {
			for(int y = dy ; y < m ; y++) { 
				tmp[x - dx][y] = arr[x][y];
			}
		}
		
		// 2 -> 1
		for(int x = 0 ; x < dx ; x++) {
			for(int y = dy ; y < m ; y++) { 
				tmp[x][y - dy] = arr[x][y];
			}
		}
		
		
		return tmp;
	} 
	
	
	
}