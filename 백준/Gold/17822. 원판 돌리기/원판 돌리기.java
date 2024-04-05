import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

class Main {
	
	static boolean[][] visited;
	static ArrayList<Integer>[] board;
	static int n;
	static int m;
	static boolean isChange = false;
	static boolean isInjub = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		
		// n개의 원판
		n = Integer.parseInt(input[0]);
		// 각 원판 m개의 수
		m = Integer.parseInt(input[1]);
		// 회전 수
		int t = Integer.parseInt(input[2]);
		
		// 원판 각 수는 1000보다 작은
		board = new ArrayList[n + 1];
		
		
		// 원판 숫자 초기화
		for(int x = 1 ; x <= n ; x++) {
			board[x] = new ArrayList<Integer>();
			String[] nums = br.readLine().split(" ");
			for(int y = 0 ; y < m ; y++) {
				board[x].add(Integer.parseInt(nums[y]));
			}
		}
		
		
		visited = new boolean[n + 1][m];
		
		for(int i = 0; i < t; i++) {
			String[] rots = br.readLine().split(" ");
			// x 배수 원판은 전부 회전
			int x = Integer.parseInt(rots[0]);
			// 방향 0인 경우 시계, 1인 경우 반시계
			int d = Integer.parseInt(rots[1]);
			// k칸 회전
			int k = Integer.parseInt(rots[2]);
			
			// x 배수 원판마다
			for(int nx = x ; nx <= n ; nx += x) {
				
				// 시계면 마지막꺼 빼서 처음에 추가
				if(d == 0) {
					
					// k번 
					for(int r = 0 ; r < k ; r++) {
						int last = board[nx].remove(m - 1);
						board[nx].add(0,last);
					}
					
				} else { // 반시계면 처음꺼 빼서 마지막에 추가
					
					// k번 회전
					for(int r = 0 ; r < k ; r++) {
						int first = board[nx].remove(0);
						board[nx].add(first);
					}
					
				}
			}
			
			
			visited = new boolean[n + 1][m];
			isChange = false;
			// 그리고 이제 중복 검사
			for(int cx = 1 ; cx <= n ; cx++) {
				for(int cy = 0; cy < m ; cy++) {
					int nowValue = board[cx].get(cy);
					if(visited[cx][cy] || nowValue == -1) continue;
					// 방문되지 않았고 제외된것도아니라면 check 
					check(cx, cy, nowValue);
				}
			}
			
			
			// 변경된게 없다면
			if (!isChange) {
				double sum = 0.0;
				int count = 0;
				for(int sx = 1 ; sx <= n ; sx++) {
					for(int sy = 0; sy < m ; sy++) {
						int value = board[sx].get(sy);
						if(value != -1) {
							sum += value;
							count++;
						}
					}
				}
				if(count > 0) {
					double avg = sum / count;
					for(int sx = 1 ; sx <= n ; sx++) {
						for(int sy = 0; sy < m ; sy++) {
							int value = board[sx].get(sy);
							if(value != -1) {
								if(value > avg) {
									board[sx].set(sy, value - 1);
								} else if(value < avg) {
									board[sx].set(sy, value + 1);
								}
							}
						}
					}
				}
			}
		}
		
		int sum = 0;
		for (int x = 1; x <= n ; x++) {
			for (int y = 0; y < m ; y++){
				if(board[x].get(y) == -1) continue;
				sum += board[x].get(y);
			}
		}
		
		System.out.println(sum);
	}

	static void check(int x, int y, int preValue) {
		visited[x][y] = true;
		
		if(x + 1 <= n && board[x + 1].get(y) == preValue && !visited[x + 1][y]) {
			// 같다면 -1 로 변환하고 check 또 실행
			board[x].set(y, -1);
			match(x + 1, y, preValue);
		}
		
		if(x - 1 >= 1 && board[x - 1].get(y) == preValue && !visited[x - 1][y]) {
			board[x - 1].set(y, -1);
			match(x - 1, y, preValue);
		}
		
		if(y + 1 < m) { 
			if(board[x].get(y + 1) == preValue && !visited[x][y + 1]) {
				board[x].set(y, -1);
				match(x, y+1, preValue);
			}
		} else {
			if(board[x].get(0) == preValue && !visited[x][0]) {
				board[x].set(y, -1);
				match(x, 0, preValue); 
			}
		}
		
		if(y - 1 >= 0) {
			if(board[x].get(y - 1) == preValue && !visited[x][y - 1]) {
				board[x].set(y, -1);
				match(x, y - 1, preValue);
			}
		} else {
			if(board[x].get(m - 1) == preValue && !visited[x][m - 1]) {
				board[x].set(y, -1);
				match(x, m - 1, preValue);
			}
		}
		
		
	}
	
	static void match(int x, int y, int preValue) {
		isChange = true;
		board[x].set(y, -1);
		check(x, y, preValue);
	}
}