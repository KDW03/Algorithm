import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class FireBall{
	int m;
	int s;
	int d;
	
	public FireBall(int m, int s, int d) {
		this.m = m;
		this.s = s;
		this.d = d;
	}
	
}

public class Main {
	
	static ArrayList<FireBall>[][] makeTmp(int n) {
		ArrayList<FireBall>[][] tmp = new ArrayList[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				tmp[i][j] = new ArrayList();
			}
		}
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] moveX = {-1,-1,0,1,1,1,0,-1};
		int[] moveY = {0,1,1,1,0,-1,-1,-1};
		
		ArrayList<FireBall>[][] board = makeTmp(n);
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				board[i][j] = new ArrayList();
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int fm = Integer.parseInt(st.nextToken());
			int fs = Integer.parseInt(st.nextToken());
			int fd = Integer.parseInt(st.nextToken());
			
			board[x][y].add(new FireBall(fm,fs,fd));
		}
		
		
		for(int i = 0 ; i < k ; i++) {
			ArrayList<FireBall>[][] tmp = makeTmp(n);
			for(int x = 0 ; x < n ; x++) {
				for(int y = 0 ; y < n ; y++) {
					if(board[x][y].isEmpty()) continue;
					
					for(FireBall ball : board[x][y]) {
						int s = ball.s;
						int d = ball.d;
						
						
						int nx = x + moveX[d] * s;
						int ny = y + moveY[d] * s;
						
						while(nx < 0 || nx >= n || ny < 0 || ny >= n) {
							if(nx < 0) nx = n + nx;  
							if(nx >= n) nx = nx - n;
							if(ny < 0) ny = n + ny;  
							if(ny >= n) ny = ny - n;
						}
						
						tmp[nx][ny].add(new FireBall(ball.m, s, d));
					}
				}
			}

			for(int x = 0 ; x < n ; x++) {
				for(int y = 0 ; y < n ; y++) {
					if(tmp[x][y].size() >= 2) {
						// 0 섞인거 1 짝수 2 홀수
						int flag = -1;
						int sumM = 0;
						int sumS = 0;
						
						for(FireBall ball : tmp[x][y]) {
							sumM += ball.m;
							sumS += ball.s;
							// 이미 섞인거라면 볼 필요없다
							if(flag == 0) continue;
							
							if(ball.d % 2 == 0) {
								if(flag == 2) flag = 0;
								else flag = 1;
							}
							
							if(ball.d % 2 == 1) {
								if(flag == 1) flag = 0;
								else flag = 2;
							}
						}
						
						
						
						int newM = sumM/5;
						int newS = sumS/tmp[x][y].size();
						tmp[x][y].clear();
						if(newM == 0) continue;

						
						if(flag == 0) {
							for(int nd = 1 ; nd <= 7 ; nd += 2) {
								tmp[x][y].add(new FireBall(newM, newS, nd));
							}
						} else {
							for(int nd = 0 ; nd <= 6 ; nd += 2) {
								tmp[x][y].add(new FireBall(newM, newS, nd));
							}
						}
					}
				}
			}	
			board = tmp;
		}
		
		int answer = 0;
		for(int x = 0 ; x < n ; x++) {
			for(int y = 0 ; y < n ; y++) {
				if(board[x][y].isEmpty()) continue;
				answer += board[x][y].get(0).m * board[x][y].size();
			}
		}
		
		System.out.println(answer);
	}
}