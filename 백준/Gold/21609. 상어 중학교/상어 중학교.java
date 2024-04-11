import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position {
	int x = 0;
	int y = 0;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

class Result {
	int size = 0;
	int count = 0;
	
	Result(int size, int count) {
		this.size = size;
		this.count = count;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        
        for(int x = 0 ; x < n ; x++) {
        	st = new StringTokenizer(br.readLine()," ");
        	for(int y = 0 ; y < n ; y++) {
        		arr[x][y] = Integer.parseInt(st.nextToken());
        	}
        }
        int score = 0;
        while(true) {
        	// 블록 찾기
        	Position p = findBlock(arr);
        	if(p == null) break;
        	// 해당 블록 제거
        	score += removeBlock(arr,p);
        	down(arr,n);
        	arr = counterClockWise(arr,n);
        	down(arr,n);
        }
        System.out.println(score);        
    }
    
    
    static void printArr(int[][] arr) {
    	StringBuilder sb = new StringBuilder();
    	for(int x = 0 ; x < arr.length; x++) {
    		for(int y = 0 ; y < arr.length; y++) {
    			sb.append(arr[x][y]).append(" ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
    
    
    static int[] moveX = {0,0,-1,1};
    static int[] moveY = {-1,1,0,0};
    
    static int[][] counterClockWise(int[][] arr, int n) {
    	int[][] tmp = new int[n][n];
    	
    	for(int x = 0 ; x < n ; x++) {
    		for(int y = 0 ; y < n ; y++) {
    			tmp[x][y] = arr[y][n - x - 1];
    		}
    	}
    	
    	
    	return tmp;
    }
    
    static void down(int[][] arr,int n) {
    	// 제일 아래에서 부터 down
    	for(int y = 0 ; y < n ; y++) {
    		boolean flag = false;
    		for(int x = 0; x < n - 1 ; x++) {
    			if(arr[x][y] >= 0 && arr[x + 1][y] == -2) {
    				arr[x + 1][y] = arr[x][y];
    				arr[x][y] = -2;
    				flag = true;
    			}
    		}
    		if(flag) y--;
    	}
    }
    
    static int removeBlock(int[][] arr, Position p) {
    	int n = arr.length;
    	int fisrt = arr[p.x][p.y];
    	int size = removeDfs(arr,p.x,p.y,n,fisrt);
    	return size * size;
    }
    
    
    static ArrayList<Position> zeroAl = new ArrayList();
    
    static Position findBlock(int[][] arr) {
    	int n = arr.length;
    	int maxSize = 0;
    	int maxCount = 0;
    	Position re = null;
    	
    	boolean[][] visited = new boolean[n][n];
    	
    	for(int x = 0 ; x < n ; x++) {
    		for(int y = 0 ; y < n ; y++) {
    			int first = arr[x][y];
    			if(!visited[x][y] && first > 0) {
    				zeroAl.clear();
    				int size = dfs(arr,visited,x,y,n,first);
    				int count = zeroAl.size();
    				for(Position p : zeroAl) visited[p.x][p.y] = false;
    				if(size < 2) continue;
    				// 사이즈가 같으면 무지개 count 비교 
    				// 사이즈가 같으면 그냥 카운터로 넣어
    				if((size == maxSize && count >= maxCount) || size > maxSize) {
    					maxSize = size;
    					maxCount = count;
    					re = new Position(x,y);
    				}
    			}
    			
    		}
    	}
    	return re;
    }
    
    static int removeDfs(int[][] arr, int x, int y, int n, int first) {
    	int size = 1;
    	arr[x][y] = -2;
    	// 주위 4방향 중 무지개 또는 같은
    	for(int dir = 0 ; dir < moveX.length; dir++) {
    		int nx = x + moveX[dir];
    		int ny = y + moveY[dir];
    		
    		if(nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] < 0) continue;
    		
    		int value = arr[nx][ny];
    		if(value == first || value == 0) {
    			size += removeDfs(arr, nx, ny, n, first);
    		}
    	}
    	
    	return size;
    }
    
    
    
    static int dfs(int[][] arr, boolean[][] visited, int x, int y, int n, int first) {
    	int size = 1;
    	
    	visited[x][y] = true;
    	// 주위 4방향 중 무지개 또는 같은
    	for(int dir = 0 ; dir < moveX.length; dir++) {
    		int nx = x + moveX[dir];
    		int ny = y + moveY[dir];
    		if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;
    		int value = arr[nx][ny];
    		if(value == first || value == 0) {
    			size += dfs(arr,visited, nx, ny, n, first);
    			if(value == 0) {
    				zeroAl.add(new Position(nx,ny));
    			}
    		}
    	}
    	
    	return size;
    }
}