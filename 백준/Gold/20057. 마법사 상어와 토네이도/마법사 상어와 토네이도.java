import java.io.*;
import java.util.*;

public class Main {

	
	
	static int[] moveX = {0,1,0,-1};
	static int[] moveY = {-1,0,1,0};
	
	private static double[][] counterClockwise90(double[][] original) {
	    int rows = original.length;
	    int cols = original[0].length;
	    double[][] rotated = new double[cols][rows]; // 회전된 배열의 크기 조정

	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            rotated[cols - 1 - j][i] = original[i][j]; // 원소의 위치 변경
	        }
	    }
	    return rotated;
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// x에서 y로 이동하면, y의 모든 모래가 비율과 α가 적혀있는 칸으로 이동
		
		int[][] board = new int[n][n];
		StringTokenizer st;
		
		
		double[][] first = {
				{0,0,0.02,0,0},
				{0,0.1,0.07,0.01,0},
				{0.05,0,0,0,0},
				{0,0.1,0.07,0.01,0},
				{0,0,0.02,0,0}
		};
		
		double[][][] rotate = new double[4][5][5];
		rotate[0] = first;
		for(int i = 1; i < 4; i++) rotate[i] = counterClockwise90(rotate[i - 1]);
		
		
		
		int nowX = n / 2;
		int nowY = n / 2;
		
		for(int x = 0 ; x < n ; x++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int y = 0 ; y < n ; y++){
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int answer = 0;
		
	
		// 2개씩 1개 증가
		
		// 0,0 에 도달할 때 까지
		int count = 0;
		int distLen = 1;
		while(true) {
			if(nowX == 0 && nowY == 0) break;
	
			// 방향 바꿔가며
			for(int dir = 0 ; dir < 4 ; dir++) {
				
				// distLen 만큼 해당 방향으로 이동
				for(int nowLen = 0; nowLen < distLen; nowLen++) {
					if(nowX == 0 && nowY == 0) break;
					
					nowX += moveX[dir];
					nowY += moveY[dir];
					
					int alphaX = nowX + moveX[dir];
					int alphaY = nowY + moveY[dir];
					// 원래 있던거
					
					int m = board[nowX][nowY]; 
					int firstM = m;
					board[nowX][nowY] = 0;
					
					if(m == 0) continue;
					
					for(int x = 0; x < 5; x++) {
						for(int y = 0 ; y < 5; y++) {
							// 비율이 있다면
							
							int nx = nowX + x - 2;
							int ny = nowY + y - 2;
							
							double rota = rotate[dir][x][y];
							// 영향 없다면 pass
							if(rota < 0.01) continue;

							// 영향있고 영향 받는 곳이 격자 내에 있다면
							// 실제 적용 될 위치 
							int remove = (int) (firstM * rota);
							if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
								board[nx][ny] += remove;    
								m -= remove;
							}else {
								// 격자 내에 없다면 
								m -= remove;
								answer+= remove;
							}

						}
					}
					
					if(alphaX >= 0 && alphaX < n && alphaY >= 0 && alphaY < n) {
						board[alphaX][alphaY] += m;
					}else {
						answer += m;
					}
					
				}
				
				count++;
				if(count == 2) {
					distLen++;
					count =0;
				}
			
				
			}
		}
		
		System.out.println(answer);
	}
}